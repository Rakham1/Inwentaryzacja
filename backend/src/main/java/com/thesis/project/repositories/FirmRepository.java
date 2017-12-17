package com.thesis.project.repositories;

import com.thesis.project.model.Firm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmRepository{
    Firm findByFirmId(long id);
    void update(Firm firm);
    void save(Firm firm);
}
