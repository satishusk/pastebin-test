package com.example.postebintest.service.data.impl;

import com.example.postebintest.data.Paste;
import com.example.postebintest.exception.PasteException;
import com.example.postebintest.repository.PasteRepository;
import com.example.postebintest.service.data.PasteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PasteServiceImpl implements PasteService {
  private final PasteRepository pasteRepository;

  @Autowired
  public PasteServiceImpl(PasteRepository pasteRepository) {
    this.pasteRepository = pasteRepository;
  }

  @Override
  public Paste save(Paste paste) {
    return pasteRepository.save(paste);
  }

  @Override
  public Paste getByHashId(String hashId) {
    Optional<Paste> optionalPaste = pasteRepository.getByHashId(hashId);
    return optionalPaste.orElseThrow(() -> new PasteException("Paste with id" + hashId + " not found"));
  }

  @Override
  public List<Paste> getLatestPastes(int count) {
    return pasteRepository.listActualPastes(count);
  }
}
