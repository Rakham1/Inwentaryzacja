package com.thesis.project.repositories;

import com.thesis.project.model.Contractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Repository
@Transactional
public class ContractorRepositoryImpl implements ContractorRepository {
    @Override
    public Contractor findByContractorId(Long id) {
        return null;
    }

    @Override
    public Contractor findFirmByStorageDepId(Long storageDepId) {
        return null;
    }

    @Override
    public ArrayList<Contractor> getAllContractors() {
        return null;
    }

    @Override
    public void update(Contractor contractor) {

    }

    @Override
    public void save(Contractor contractor) {

    }
}
