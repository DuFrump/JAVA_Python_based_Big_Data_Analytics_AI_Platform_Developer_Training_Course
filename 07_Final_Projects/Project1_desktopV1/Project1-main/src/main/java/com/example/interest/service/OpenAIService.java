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
public class OpenAIService {

  private final WebClient webClient;

  @Value("${openai.api-key}")
  private String apiKey;

  @Value("${openai.model}")
  private String model;

  @Value("${openai.url}")
  private String apiUrl;

  public Map<String, Object> getResponse(String userMessage) {
    Map<String, Object> requestBody =
        Map.of(
            "model",
            model,
            "messages",
            List.of(
                Map.of(
                    "role",
                    "system",
                    "content",
                    "너는 사용자의 답변을 분석해서 5가지 주제(영화/미디어, 스포츠, 경제/재테크, 기술/IT, 일상/여행)의 신뢰도 퍼센티지를 JSON으로 응답해야 해."),
                Map.of("role", "user", "content", userMessage)));

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

      log.info("OpenAI API로부터 성공적으로 응답을 받았습니다.");
      return response;

    } catch (Exception e) {
      log.error("OpenAI API 호출 중 에러 발생", e);
      return Map.of("error", "OpenAI API 호출에 실패했습니다.");
    }
  }
}
