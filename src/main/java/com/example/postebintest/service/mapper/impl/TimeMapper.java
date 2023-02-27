package com.example.postebintest.service.mapper.impl;

import com.example.postebintest.data.ExpirationTime;
import com.example.postebintest.service.mapper.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class TimeMapper implements ObjectMapper<ExpirationTime, OffsetDateTime> {
  @Override
  public OffsetDateTime mapForward(ExpirationTime time) {
    return time.equals(ExpirationTime.NO_LIMITS)
      ? OffsetDateTime.of(100000, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(0))
      : OffsetDateTime.now().plusMinutes(time.toValue());
  }
}
