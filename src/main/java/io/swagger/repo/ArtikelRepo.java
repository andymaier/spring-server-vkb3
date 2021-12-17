package io.swagger.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Artikel;

public interface ArtikelRepo extends JpaRepository<Artikel, UUID> {
    
}
