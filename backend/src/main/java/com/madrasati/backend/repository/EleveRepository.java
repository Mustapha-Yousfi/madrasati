package com.madrasati.backend.repository;

import com.madrasati.backend.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
}
