package com.kazhukov.pastebin.dto;

import com.kazhukov.pastebin.data.Access;
import com.kazhukov.pastebin.data.ExpirationTime;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasteRequestDto {
  private String hashId;

  @NotBlank
  private String separatedText;

  @NotBlank
  private ExpirationTime expirationTime;

  @NotBlank
  private Access access;
}
