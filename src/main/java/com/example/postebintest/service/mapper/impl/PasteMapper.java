package com.example.postebintest.service.mapper.impl;

import com.example.postebintest.data.Paste;
import com.example.postebintest.dto.PasteDto;
import com.example.postebintest.service.mapper.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasteMapper implements ObjectMapper<PasteDto, Paste> {
  private final TimeMapper timeMapper;

  @Override
  public Paste mapForward(PasteDto pasteDto) {
    Paste paste = new Paste();
    paste.setHashId(pasteDto.getHashId());
    paste.setAccess(pasteDto.getAccess());
    paste.setExpirationEndDateTime(timeMapper.mapForward(pasteDto.getExpirationTime()));
    paste.setSeparatedText(pasteDto.getSeparatedText());
    return paste;
  }

  @Override
  public PasteDto mapBackward(Paste paste) {
    PasteDto dto = new PasteDto();
    dto.setHashId(paste.getHashId());
    dto.setAccess(paste.getAccess());
    dto.setExpirationTime(timeMapper.mapBackward(paste.getExpirationEndDateTime()));
    dto.setSeparatedText(paste.getSeparatedText());
    return dto;
  }
}