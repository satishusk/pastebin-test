package com.example.postebintest.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
public class Paste {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column(name = "id")
  private String hashId;

  @Enumerated()
  @Column(name = "text")
  private String separatedText;

  @Column(name = "end_time")
  private OffsetDateTime expirationEndDateTime;

  private Access access;
}
