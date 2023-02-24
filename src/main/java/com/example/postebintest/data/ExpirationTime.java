package com.example.postebintest.data;

import com.example.postebintest.exception.TimeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;

public enum ExpirationTime {
  TEN_MINUTES,
  ONE_HOUR,
  THREE_HOURS,
  ONE_DAY,
  ONE_WEEK,
  ONE_MONTH,
  NO_LIMITS;

  private static final Map<Integer, ExpirationTime> valuesMap = Map.of(
    10, TEN_MINUTES,
    60, ONE_HOUR,
    180, THREE_HOURS,
    1440, ONE_DAY,
    10080, ONE_WEEK,
    44640, ONE_MONTH,
    0, NO_LIMITS
  );

  @JsonCreator
  public static ExpirationTime forValue(Integer value) {
    ExpirationTime expirationTime = valuesMap.get(value);
    if (expirationTime != null) {
      return expirationTime;
    }
    throw new TimeException("ExpirationTime type: " + value + " is not supported");
  }

  @JsonValue
  public Integer toValue() {
    for (Map.Entry<Integer, ExpirationTime> entry : valuesMap.entrySet()) {
      if (entry.getValue() == this) {
        return entry.getKey();
      }
    }
    throw new TimeException("ExpirationTime type: " + this + " is not supported");
  }
}
