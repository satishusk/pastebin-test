package com.kazhukov.pastebin.service.data;

import com.kazhukov.pastebin.data.Paste;

import java.util.List;


public interface PasteService {
  Paste save(Paste paste);

  Paste getByHashId(String hashId);

  List<Paste> getLatestPastes(int count);
}