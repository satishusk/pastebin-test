package com.kazhukov.pastebin.controller;

import com.kazhukov.pastebin.data.Paste;
import com.kazhukov.pastebin.dto.PasteRequestDto;
import com.kazhukov.pastebin.dto.PasteResponseDto;
import com.kazhukov.pastebin.service.data.PasteService;
import com.kazhukov.pastebin.service.mapper.impl.PasteMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PasteController {
  private final PasteMapper mapper;
  private final PasteService pasteService;

  @PostMapping("/")
  public ResponseEntity<String> savePaste(HttpServletRequest request,
                                          @RequestBody PasteRequestDto pasteRequestDto) {
    Paste paste = mapper.toCentral(pasteRequestDto);
    Paste savedPaste = pasteService.save(paste);
    return ResponseEntity.ok().body(
      request.getRequestURL()
        .append(savedPaste.getHashId())
        .toString()
    );
  }

  @GetMapping("/{hashId}")
  public ResponseEntity<PasteResponseDto> getPaste(@PathVariable String hashId) {
    Paste paste = pasteService.getByHashId(hashId);
    return ResponseEntity.ok().body(mapper.fromCentral(paste));
  }

  @GetMapping("/latest")
  public ResponseEntity<List<PasteResponseDto>> getLatestPastes() {
    List<PasteResponseDto> latestPastes = pasteService.getLatestPastes(10).stream()
      .map(mapper::fromCentral).toList();
    return ResponseEntity.ok()
      .body(latestPastes);
  }
}
