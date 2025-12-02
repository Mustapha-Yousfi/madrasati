package com.madrasati.backend.repository;

import com.madrasati.backend.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
