package com.kazhukov.pastebin.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@Data
@NoArgsConstructor
public class Paste {
  @Id
  @GenericGenerator(name = "hash_generator",
    strategy = "com.kazhukov.pastebin.service.generator.identifier.HashGenerator")
  @GeneratedValue(generator = "hash_generator")
  @Column(name = "id")
  private String hashId;

  @Column(name = "text", columnDefinition = "TEXT")
  private String separatedText;

  @Enumerated(EnumType.STRING)
  private Access access;

  @Basic
  private long timestampMinutes;

  @Basic
  private long expirationMinutes;

  @Transient
  private OffsetDateTime timestamp = OffsetDateTime.now();

  @Transient
  private ZoneOffset zoneOffset = timestamp.getOffset();

  @Transient
  private ExpirationTime expirationTime;

  @PostLoad
  void fillTransient() {
    if (timestampMinutes >= 0) {
      timestamp = OffsetDateTime.ofInstant(Instant.ofEpochSecond(timestampMinutes * 60), zoneOffset);
    }
    if (expirationMinutes >= 0) {
      expirationTime = ExpirationTime.forValue(expirationMinutes);
    }
  }

  @PrePersist
  void fillPersistent() {
    if (timestamp != null) {
      timestampMinutes = timestamp.toInstant().getEpochSecond() / 60;
    }
    if (expirationTime != null) {
      expirationMinutes = expirationTime.toValue();
    }
  }

  public OffsetDateTime getExpirationOffsetDateTime() {
    Long expirationMinutes = expirationTime.toValue();
    return timestamp.plusMinutes(expirationMinutes);
  }
}
