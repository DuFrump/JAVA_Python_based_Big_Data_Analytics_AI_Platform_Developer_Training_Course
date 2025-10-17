package com.example.interest.domain;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class InterestResult {
  private Map<String, Double> scores;
  private String top1;
  private String top2;
}
