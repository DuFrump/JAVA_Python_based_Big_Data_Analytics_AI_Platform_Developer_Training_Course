package com.example.interest.controller;

import com.example.interest.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plan")
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public Map<String, Object> getPlan(@RequestBody Map<String, String> body) {
        String topic = body.get("topic");
        String plan = planService.generatePlan(topic);
        return Map.of("plan", plan);
    }
}


