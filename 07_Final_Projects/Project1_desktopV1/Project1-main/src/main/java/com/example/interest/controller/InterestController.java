package com.example.interest.controller;

import com.example.interest.service.InterestService;
import java.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class InterestController {

  private final InterestService service;

  @GetMapping("/")
  public String home() {
    return "index"; // templates/index.html
  }

  @GetMapping("/chat")
  public String chat() {
    return "chat"; // templates/chat.html
  }

  @GetMapping("/question")
  public String redirectQuestion() {
    return "redirect:/chat";
  }

  // 🔥 Flask와 통신하는 API 추가
  @PostMapping("/api/get-topic")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> analyze(@RequestBody Map<String, String> payload) {
    try {
      String userInput = payload.get("sentence");
      log.info("[/api/get-topic] 입력 문장: {}", userInput);

      if (userInput == null || userInput.isBlank()) {
        log.warn("입력 문장이 비어있습니다.");
        return ResponseEntity.badRequest().body(Map.of("error", "입력 문장이 비어 있습니다."));
      }

      Map<String, Double> scores = service.analyzeWithPython(userInput);
      return ResponseEntity.ok(Map.of("scores", scores));

            } catch (Exception e) {
                log.error("Python 스크립트 실행 중 에러 발생", e);
                return ResponseEntity.internalServerError()
                        .body(Map.of("error", "Python 스크립트 실행 실패", "message", e.getMessage()));
            }  }
}
