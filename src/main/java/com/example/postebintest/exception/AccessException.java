package com.example.postebintest.exception;

public class AccessException extends RuntimeException {
  public AccessException() {
    super();
  }

  public AccessException(String message) {
    super(message);
  }
}
