package com.thesis.project.repositories;

import com.thesis.project.model.Firm;

import java.util.ArrayList;

public interface FirmRepository {
    Firm findByFirmId(Long id);

    Firm findFirmByUserId(Long userId);

    ArrayList<Firm> getAllFirms();

    void update(Firm firm);

    void save(Firm firm);
}
