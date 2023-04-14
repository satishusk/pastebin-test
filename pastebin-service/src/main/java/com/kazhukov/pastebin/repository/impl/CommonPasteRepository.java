package com.kazhukov.pastebin.repository.impl;

import com.kazhukov.pastebin.data.Paste;
import com.kazhukov.pastebin.repository.PasteRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Transactional
public class CommonPasteRepository implements PasteRepository {
  private final EntityManager entityManager;

  @Override
  public Paste save(Paste paste) {
    entityManager.persist(paste);
    return paste;
  }

  @Override
  public Optional<Paste> getByHashId(String hashId) {
    String queryString =
      "select p from Paste p " +
      "where p.timestampMinutes + p.expirationMinutes > :now and p.hashId = :hashId";
    return Optional.of(entityManager
      .createQuery(queryString, Paste.class)
      .setParameter("now", OffsetDateTime.now().toInstant().getEpochSecond() / 60)
      .setParameter("hashId", hashId)
      .getSingleResult());
  }

  @Override
  public List<Paste> listActualPastes(int count) {
    String queryString =
      "select p from Paste p " +
      "where p.access = 'PUBLIC' and  p.timestampMinutes + p.expirationMinutes > :now " +
      "order by p.timestampMinutes desc";
    return entityManager.createQuery(queryString, Paste.class)
      .setParameter("now", OffsetDateTime.now().toInstant().getEpochSecond() / 60)
      .setMaxResults(count)
      .getResultList();
  }
}
