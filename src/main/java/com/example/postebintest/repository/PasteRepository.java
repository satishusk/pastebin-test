package com.example.postebintest.repository;

import com.example.postebintest.data.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PasteRepository {

  Paste save(Paste paste);

  Optional<Paste> getByHashId(String hashId);

  List<Paste> listActualPastes(int count);
}
