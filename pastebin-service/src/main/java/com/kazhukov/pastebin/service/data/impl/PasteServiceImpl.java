package com.kazhukov.pastebin.service.data.impl;

import com.kazhukov.pastebin.data.Paste;
import com.kazhukov.pastebin.exception.PasteException;
import com.kazhukov.pastebin.repository.PasteRepository;
import com.kazhukov.pastebin.service.data.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
