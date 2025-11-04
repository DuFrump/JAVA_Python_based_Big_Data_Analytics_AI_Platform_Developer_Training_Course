import torch
from transformers import GPT2Tokenizer, GptOssForSequenceClassification

MODEL_NAME = "heegyu/kodialogpt-v1"
tokenizer = GPT2Tokenizer.from_pretrained(MODEL_NAME)
model = GptOssForSequenceClassification.from_pretrained(MODEL_NAME, num_labels=2)

device = torch.device("cpu")
model.to(device)

print("=== KoBERT 감정 분석 테스트 ===")
print("종료하려면 'exit' 입력\n")

while True:
    text = input("문장 입력: ").strip()
    if text.lower() == "exit":
        print("종료합니다.")
        break

    # 토크나이징
    inputs = tokenizer(text, return_tensors="pt", truncation=True, padding=True, max_length=64)
    inputs = {k: v.to(device) for k, v in inputs.items()}

    with torch.no_grad():
        outputs = model(**inputs)
        logits = outputs.logits
        probs = torch.softmax(logits, dim=-1)
        pred = torch.argmax(probs, dim=-1).item()

    label = "긍정" if pred == 1 else "부정"
    print(f"결과 : {label} (score={probs[0][pred]:.3f})\n")