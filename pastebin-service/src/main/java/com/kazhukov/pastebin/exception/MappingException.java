package com.kazhukov.pastebin.exception;

public class MappingException extends RuntimeException {
  public MappingException() {
    super();
  }

  public MappingException(String message) {
    super(message);
  }
}
