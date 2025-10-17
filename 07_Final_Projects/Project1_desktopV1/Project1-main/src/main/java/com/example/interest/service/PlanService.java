package com.example.interest.service;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlanService {

  private final WebClient webClient;

  @Value("${openai.api-key}")
  private String apiKey;

  @Value("${openai.url}")
  private String apiUrl;

  @Value("${openai.model}")
  private String model;

  public String generatePlan(String topic) {
    String prompt =
        """
                당신은 사용자의 관심사에 맞춰 맞춤형 일주일 계획을 제안하는 스마트 플래너입니다.
                선택된 관심사: '%s'

                형식:
                월: ~
                화: ~
                수: ~
                목: ~
                금: ~
                토: ~
                일: ~

                각 요일마다 1~2문장으로 구체적이고 실천 가능한 계획을 제시하세요.
                """
            .formatted(topic);

    Map<String, Object> requestBody =
        Map.of(
            "model",
            model,
            "messages",
            List.of(
                Map.of("role", "system", "content", "당신은 일상 계획을 세우는 전문가입니다."),
                Map.of("role", "user", "content", prompt)));

    try {
      Map<String, Object> response =
          webClient
              .post()
              .uri(apiUrl)
              .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
              .contentType(MediaType.APPLICATION_JSON)
              .bodyValue(requestBody)
              .retrieve()
              .bodyToMono(Map.class)
              .block();

      List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
      Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
      String plan = ((String) message.get("content")).replace("\n", "<br>");
      log.info("주간 계획을 성공적으로 생성했습니다. 주제: {}", topic);
      return plan;

    } catch (Exception e) {
      log.error("OpenAI API를 이용한 주간 계획 생성 중 에러 발생", e);
      return "⚠️ 계획을 생성하는 중 오류가 발생했습니다.";
    }
  }
}
