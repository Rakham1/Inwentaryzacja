package com.thesis.project.repositories;

import com.thesis.project.model.Contractor;

import java.util.ArrayList;

public interface ContractorRepository {
    Contractor findByContractorId(Long id);

    Contractor findFirmByStorageDepId(Long storageDepId);

    ArrayList<Contractor> getAllContractors();

    void update(Contractor contractor);

    void save(Contractor contractor);
}
