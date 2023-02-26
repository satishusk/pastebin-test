package com.example.postebintest.dto;

import com.example.postebintest.data.Access;
import com.example.postebintest.data.ExpirationTime;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class PasteResponseDto {
  private String hashId;

  @NotBlank
  private String separatedText;

  @NotBlank
  private OffsetDateTime expirationTime;

  @NotBlank
  private Access access;
}