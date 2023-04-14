package com.kazhukov.pastebin.repository;

import com.kazhukov.pastebin.data.Paste;

import java.util.List;
import java.util.Optional;

public interface PasteRepository {

  Paste save(Paste paste);

  Optional<Paste> getByHashId(String hashId);

  List<Paste> listActualPastes(int count);
}
