package com.example.postebintest.service.paste;

import com.example.postebintest.data.Paste;
import com.example.postebintest.exception.PasteException;
import com.example.postebintest.repository.PasteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface PasteService {
  Paste save(Paste paste);
  Paste getByHashId(String hashId);
}
