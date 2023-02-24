package com.example.postebintest.service.mapper;

public interface EntityMapper<DTO, E> {
  E mapDto(DTO dto);
  DTO mapEntity(E entity);
}
