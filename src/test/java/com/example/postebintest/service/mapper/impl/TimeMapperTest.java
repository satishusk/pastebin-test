package com.example.postebintest.service.mapper.impl;

import com.example.postebintest.data.ExpirationTime;
import com.example.postebintest.exception.TimeException;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TimeMapperTest {
  private final TimeMapper timeMapper = new TimeMapper();

  @Test
  void mapForward_shouldExistType() {
    ExpirationTime oneMonth = ExpirationTime.ONE_MONTH;

    OffsetDateTime now = OffsetDateTime.now();
    OffsetDateTime offsetDateTime = timeMapper.mapForward(oneMonth);

    Duration duration = Duration.between(now, offsetDateTime);
    assertEquals(oneMonth.toValue(), (int) duration.toMinutes());
  }

  @Test
  void mapBackward_shouldExistType() {
    OffsetDateTime now = OffsetDateTime.now();
    OffsetDateTime inYear = now.plusDays(1);
    int minutesDuration = (int) Duration.between(now, inYear).toMinutes();

    ExpirationTime expirationTime = timeMapper.mapBackward(inYear);

    assertEquals(minutesDuration, expirationTime.toValue());
  }

  @Test()
  void mapBackward_shouldThrowException() {
    OffsetDateTime now = OffsetDateTime.now();
    OffsetDateTime inYear = now.plusDays(2);
    int minutesDuration = (int) Duration.between(now, inYear).toMinutes();

    assertThrows(TimeException.class, () -> timeMapper.mapBackward(inYear));
  }
}