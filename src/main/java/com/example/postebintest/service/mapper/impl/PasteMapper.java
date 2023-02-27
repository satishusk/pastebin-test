package com.example.postebintest.service.mapper.impl;

import com.example.postebintest.data.Paste;
import com.example.postebintest.dto.PasteRequestDto;
import com.example.postebintest.dto.PasteResponseDto;
import com.example.postebintest.service.mapper.UnidirectionalObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasteMapper implements UnidirectionalObjectMapper<PasteRequestDto, Paste, PasteResponseDto> {

  @Override
  public Paste toCentral(PasteRequestDto pasteRequestDto) {
    Paste paste = new Paste();
    paste.setHashId(pasteRequestDto.getHashId());
    paste.setAccess(pasteRequestDto.getAccess());
    paste.setExpirationTime(pasteRequestDto.getExpirationTime());
    paste.setSeparatedText(pasteRequestDto.getSeparatedText());
    return paste;
  }

  @Override
  public PasteResponseDto fromCentral(Paste paste) {
    PasteResponseDto pasteResponseDto = new PasteResponseDto();
    pasteResponseDto.setHashId(paste.getHashId());
    pasteResponseDto.setAccess(paste.getAccess());
    pasteResponseDto.setExpirationOffsetDateTime(paste.getExpirationOffsetDateTime());
    pasteResponseDto.setSeparatedText(paste.getSeparatedText());
    return pasteResponseDto;
  }
}