package com.thesis.project.services;

import com.thesis.project.dto.FirmDTO;
import com.thesis.project.factory.FirmFactory;
import com.thesis.project.model.Firm;
import com.thesis.project.repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class FirmService {
    @Autowired
    FirmRepository firmRepository;

    @Autowired
    FirmFactory firmFactory;

    public Firm findByFirmId(Long id) {
        Firm firm = firmRepository.findByFirmId(id);
        return firm;
    }

    public Firm findFirmByUserId(Long userId){
        return firmRepository.findFirmByUserId(userId);
    }

    public ArrayList<Firm> getAllFirms(){
        return firmRepository.getAllFirms();
    }

    @Transactional
    public void save(FirmDTO firmDTO) {
        firmRepository.save(firmFactory.firmFromDto(firmDTO));
    }

    @Transactional
    public void update(FirmDTO firmDTO) {
        firmRepository.update(firmFactory.firmFromDto(firmDTO));
    }
}
