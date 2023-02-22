package com.example.postebintest.service.generator.identifier;

import com.example.postebintest.data.Paste;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HashGeneratorTest {
  private final HashGenerator hashGenerator = new HashGenerator();

  @ParameterizedTest
  @MethodSource("pasteArguments")
  void generate_shouldReturnMD5Hash(Object testPaste) {
    String actualHash = hashGenerator.generate(null, testPaste);

    assertTrue(isMd5(actualHash));
  }

  private boolean isMd5(String possible) {
    return possible.matches("(?i)^[a-f\\d]{32}$");
  }

  private static Stream<Arguments> pasteArguments() {
    return Stream.of(
      Arguments.of(mock(Paste.class)),
      Arguments.of(mock(Object.class)),
      Arguments.of((Object) null)
    );
  }
}