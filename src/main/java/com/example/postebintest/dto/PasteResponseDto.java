package com.example.postebintest.dto;

import com.example.postebintest.data.Access;
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
  private OffsetDateTime expirationOffsetDateTime;

  @NotBlank
  private Access access;
}