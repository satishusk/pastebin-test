package com.example.postebintest.service.mapper.impl;

import com.example.postebintest.data.ExpirationTime;
import com.example.postebintest.dto.PasteDto;
import com.example.postebintest.service.mapper.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.OffsetDateTime;

@Component
public class TimeMapper implements ObjectMapper<ExpirationTime, OffsetDateTime> {
  @Override
  public OffsetDateTime mapForward(ExpirationTime time) {
    return OffsetDateTime.now().plusMinutes(time.toValue());
  }

  @Override
  public ExpirationTime mapBackward(OffsetDateTime offsetDateTime) {
    Duration duration = Duration.between(OffsetDateTime.now(), offsetDateTime);
    return ExpirationTime.forValue((int) duration.toMinutes());
  }
}
