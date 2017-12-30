package com.thesis.project.repositories;

import com.thesis.project.model.Contractor;

import java.util.ArrayList;

public interface ContractorRepository {
    Contractor findByContractorId(Long id);

    Contractor findContractorByStorageDepId(Long storageDepId);

    ArrayList<Contractor> getAllContractorsByFirmId(Long firmId);

    ArrayList<Contractor> getAllContractors();

    void update(Contractor contractor);

    void save(Contractor contractor);
}
