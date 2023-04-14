package com.kazhukov.pastebin.service.mapper.impl;

import com.kazhukov.pastebin.data.Paste;
import com.kazhukov.pastebin.dto.PasteRequestDto;
import com.kazhukov.pastebin.dto.PasteResponseDto;
import com.kazhukov.pastebin.service.mapper.UnidirectionalObjectMapper;
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