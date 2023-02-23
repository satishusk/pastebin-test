package com.example.postebintest.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
public class Paste {
  @Id
  @GenericGenerator(name = "hash_generator",
    strategy = "com.example.postebintest.service.generator.identifier.HashGenerator")
  @GeneratedValue(generator = "hash_generator")
  @Column(name = "id")
  private String hashId;

  @Enumerated()
  @Column(name = "text")
  private String separatedText;

  @Column(name = "end_time")
  private OffsetDateTime expirationEndDateTime;

  private Access access;
}
