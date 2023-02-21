package com.example.postebintest.dto;

import com.example.postebintest.data.Access;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class PasteDto {
  private String hashId;
  private String separatedText;
  private OffsetDateTime expirationEndDateTime;
  private Access access;
}
