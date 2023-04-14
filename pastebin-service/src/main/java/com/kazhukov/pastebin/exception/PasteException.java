package com.kazhukov.pastebin.exception;

public class PasteException extends RuntimeException {
  public PasteException() {
    super();
  }

  public PasteException(String message) {
    super(message);
  }
}
