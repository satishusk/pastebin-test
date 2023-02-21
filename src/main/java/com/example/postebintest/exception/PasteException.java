package com.example.postebintest.exception;

public class PasteException extends RuntimeException {
  public PasteException() {
    super();
  }

  public PasteException(String message) {
    super(message);
  }
}
