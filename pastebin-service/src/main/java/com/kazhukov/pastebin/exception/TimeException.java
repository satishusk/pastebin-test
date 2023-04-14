package com.kazhukov.pastebin.exception;

public class TimeException extends RuntimeException {
  public TimeException() {
    super();
  }

  public TimeException(String message) {
    super(message);
  }
}
