package com.example.postebintest.data;

import com.example.postebintest.exception.AccessException;
import com.example.postebintest.exception.TimeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;

public enum Access {
  PUBLIC, UNLISTED;

  private static final Map<String, Access> namesMap = Map.of(
    "public", PUBLIC,
    "unlisted", UNLISTED
  );

  @JsonCreator
  public static Access forValue(String name) {
    Access access = namesMap.get(name);
    if (access != null) {
      return access;
    }
    throw new AccessException("Access type: " + name + " is not supported");
  }

  @JsonValue
  public String toValue() {
    for (Map.Entry<String, Access> entry : namesMap.entrySet()) {
      if (entry.getValue() == this) {
        return entry.getKey();
      }
    }
    throw new AccessException("Access type: " + this + " is not supported");
  }
}
