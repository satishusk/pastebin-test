package com.kazhukov.pastebin.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.kazhukov.pastebin.exception.TimeException;

import java.util.Map;

public enum ExpirationTime {
  TEN_MINUTES,
  ONE_HOUR,
  THREE_HOURS,
  ONE_DAY,
  ONE_WEEK,
  ONE_MONTH,
  NO_LIMITS;

  private static final Map<Long, ExpirationTime> valuesMap = Map.of(
    10L, TEN_MINUTES,
    60L, ONE_HOUR,
    180L, THREE_HOURS,
    1440L, ONE_DAY,
    10080L, ONE_WEEK,
    44640L, ONE_MONTH,
    0L, NO_LIMITS
  );

  @JsonCreator
  public static ExpirationTime forValue(Long value) {
    ExpirationTime expirationTime = valuesMap.get(value);
    if (expirationTime != null) {
      return expirationTime;
    }
    throw new TimeException("ExpirationTime type: " + value + " is not supported");
  }

  @JsonValue
  public Long toValue() {
    for (Map.Entry<Long, ExpirationTime> entry : valuesMap.entrySet()) {
      if (entry.getValue() == this) {
        return entry.getKey();
      }
    }
    throw new TimeException("ExpirationTime type: " + this + " is not supported");
  }
}
