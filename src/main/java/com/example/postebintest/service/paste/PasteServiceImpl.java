package com.example.postebintest.service.paste;

import com.example.postebintest.data.Paste;
import com.example.postebintest.exception.PasteException;
import com.example.postebintest.repository.PasteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PasteServiceImpl implements PasteService {
  private final PasteRepository pasteRepository;

  public Paste save(Paste paste) {
    return pasteRepository.save(paste);
  }

  public Paste getByHashId(String hashId) {
    Optional<Paste> optionalPaste = pasteRepository.findById(hashId);
    if (optionalPaste.isPresent()) {
      return optionalPaste.get();
    } else {
      throw new PasteException("Paste with id" + hashId + "not found");
    }
  }
}
