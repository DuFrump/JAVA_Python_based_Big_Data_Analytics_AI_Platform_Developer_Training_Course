package com.example.interest.controller;

import com.example.interest.service.PlanService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plan")
@Slf4j
public class PlanController {

  private final PlanService planService;

  @PostMapping
  public Map<String, Object> getPlan(@RequestBody Map<String, String> body) {
    String topic = body.get("topic");
    log.info("[/api/plan] 주간 계획 생성 요청. 주제: {}", topic);
    String plan = planService.generatePlan(topic);
    return Map.of("plan", plan);
  }
}
