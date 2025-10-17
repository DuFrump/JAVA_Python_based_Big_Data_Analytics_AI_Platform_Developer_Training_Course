package com.example.interest.service;

import com.example.interest.domain.InterestResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InterestService {

  @Value("${python.script.path}")
  private String pythonScriptPath;

  public InterestResult analyze(List<String> answers) {

    // 기본 점수
    Map<String, Double> scores = new HashMap<>();
    scores.put("기술/IT", 0.0);
    scores.put("스포츠", 0.0);
    scores.put("영화/미디어", 0.0);
    scores.put("경제/재테크", 0.0);
    scores.put("일상/여행", 0.0);

    // ✅ 질문 키워드에 따라 점수 증가
    for (String ans : answers) {
      String lower = ans.toLowerCase();

      if (lower.contains("it")
          || lower.contains("컴퓨터")
          || lower.contains("기술")
          || lower.contains("개발")) {
        scores.put("기술/IT", scores.get("기술/IT") + 20);
      } else if (lower.contains("운동") || lower.contains("축구") || lower.contains("농구")) {
        scores.put("스포츠", scores.get("스포츠") + 20);
      } else if (lower.contains("영화") || lower.contains("드라마") || lower.contains("유튜브")) {
        scores.put("영화/미디어", scores.get("영화/미디어") + 20);
      } else if (lower.contains("주식") || lower.contains("부동산") || lower.contains("경제")) {
        scores.put("경제/재테크", scores.get("경제/재테크") + 20);
      } else {
        scores.put("일상/여행", scores.get("일상/여행") + 20);
      }
    }

    // 총합으로 퍼센티지 계산
    double total = scores.values().stream().mapToDouble(Double::doubleValue).sum();
    if (total == 0) { // 0으로 나누는 경우 방지
      return new InterestResult(scores, "없음", "없음");
    }

    for (String key : scores.keySet()) {
      scores.put(key, (scores.get(key) / total) * 100);
    }

    // 내림차순 정렬 후 상위 2개 선택
    List<Map.Entry<String, Double>> sorted = new ArrayList<>(scores.entrySet());
    sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    String top1 = sorted.get(0).getKey();
    String top2 = sorted.size() > 1 ? sorted.get(1).getKey() : "없음";

    return new InterestResult(scores, top1, top2);
  }

  public Map<String, Double> analyzeWithPython(String userInput) {
    log.info("Python 스크립트를 사용하여 문장 분석 시작. 스크립트 경로: {}", pythonScriptPath);

    try {
      java.io.File scriptFile = new java.io.File(pythonScriptPath);
      ProcessBuilder processBuilder = new ProcessBuilder("python", scriptFile.getName());
      processBuilder.directory(scriptFile.getParentFile()); // 실행 디렉토리를 스크립트가 있는 폴더로 설정
      processBuilder.environment().put("PYTHONIOENCODING", "UTF-8"); // Python의 입출력 인코딩을 UTF-8로 설정

      Process process = processBuilder.start();

      // Python 스크립트에 문장을 표준 입력으로 전달
      try (OutputStream os = process.getOutputStream()) {
        os.write(userInput.getBytes(StandardCharsets.UTF_8));
      }

      // 프로세스가 끝날 때까지 최대 30초 대기
      boolean finished = process.waitFor(30, TimeUnit.SECONDS);
      if (!finished) {
        process.destroy();
        throw new RuntimeException("Python 스크립트 실행 시간이 초과되었습니다.");
      }

      // 프로세스 종료 후 스트림 읽기 (교착 상태 방지)
      String jsonOutput = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
      String errorOutput = new String(process.getErrorStream().readAllBytes(), StandardCharsets.UTF_8);

      if (process.exitValue() != 0) {
        log.error("Python 스크립트 실행 중 에러 발생. Exit Code: {}", process.exitValue());
        log.error("Python 에러 출력: {}", errorOutput);
        throw new RuntimeException("Python 스크립트 실행에 실패했습니다: " + errorOutput);
      }

      log.info("Python 스크립트 실행 완료. JSON 출력: {}", jsonOutput);

      // 결과 JSON을 Map으로 파싱
      ObjectMapper objectMapper = new ObjectMapper();
      Map<String, Map<String, Double>> result =
          objectMapper.readValue(jsonOutput, new TypeReference<>() {});

      return result.get("scores");

    } catch (Exception e) {
      log.error("Python 프로세스 실행 중 예외 발생", e);
      throw new RuntimeException("Python 스크립트 실행 중 심각한 오류가 발생했습니다.", e);
    }
  }
}
