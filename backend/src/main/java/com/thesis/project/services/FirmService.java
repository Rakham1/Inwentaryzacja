package com.thesis.project.services;

import com.thesis.project.dto.FirmDTO;
import com.thesis.project.model.Firm;
import com.thesis.project.repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmService {
    @Autowired
    FirmRepository firmRepository;

    public Firm findByFirmId(Long id){
        Firm firm = firmRepository.findByFirmId(id);
        return firm;
    }
}
