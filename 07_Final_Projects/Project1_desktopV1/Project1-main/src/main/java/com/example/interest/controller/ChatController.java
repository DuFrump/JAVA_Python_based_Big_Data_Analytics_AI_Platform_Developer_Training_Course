package com.example.interest.controller;

import com.example.interest.service.OpenAIService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

  private final OpenAIService service;

  @PostMapping("/ask")
  public Map<String, Object> ask(@RequestBody Map<String, String> req) {
    String userMessage = req.get("message");
    log.info("[/api/ask] 사용자 메시지: {}", userMessage);
    return service.getResponse(userMessage);
  }
}
