package com.thesis.project.repositories;

import com.thesis.project.model.Firm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmRepository extends JpaRepository<Firm, Long>{
    Firm findByFirmId(Long id);
}
