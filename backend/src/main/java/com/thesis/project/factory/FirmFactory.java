package com.thesis.project.factory;

import com.thesis.project.dto.FirmDTO;
import com.thesis.project.model.Firm;
import com.thesis.project.repositories.FirmRepository;
import com.thesis.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirmFactory {

    @Autowired
    UserRepository userRepository;

    public FirmDTO firmToDto(Firm firm){
        FirmDTO firmDTO = new FirmDTO();
        firmDTO.setId(firm.getFirmId());
        firmDTO.setFirmName(firm.getFirmName());
        firmDTO.setNip(firm.getNip());
        firmDTO.setStreet(firm.getStreet());
        firmDTO.setPostcode(firm.getPostCode());
        firmDTO.setCity(firm.getCity());
        firmDTO.setUserId(firm.getUser().getId());
        return firmDTO;
    }

    public Firm firmFromDto(FirmDTO firmDTO){
        Firm firm = new Firm();
        firm.setFirmId(firmDTO.getId());
        firm.setFirmName(firmDTO.getFirmName());
        firm.setNip(firmDTO.getNip());
        firm.setStreet(firmDTO.getStreet());
        firm.setPostCode(firmDTO.getPostcode());
        firm.setCity(firmDTO.getCity());
        firm.setUser(userRepository.findById(firmDTO.getUserId()));
        return firm;
    }
}
