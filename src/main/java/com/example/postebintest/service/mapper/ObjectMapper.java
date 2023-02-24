package com.example.postebintest.service.mapper;

public interface ObjectMapper<F, S> {
  S mapForward(F firstType);
  F mapBackward(S secondType);
}
