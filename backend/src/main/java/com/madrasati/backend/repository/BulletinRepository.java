package com.madrasati.backend.repository;

import com.madrasati.backend.model.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulletinRepository extends JpaRepository<Bulletin, Long> {}
