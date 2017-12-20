package com.thesis.project.factory;

import com.thesis.project.dto.PersonInputDTO;
import com.thesis.project.dto.PersonOutputDTO;
import com.thesis.project.model.Person;
import com.thesis.project.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonFactory {
    @Autowired
    RoleRepository roleRepository;

    public ArrayList<PersonInputDTO> personToDTO(ArrayList<Person> people) {
        ArrayList<PersonInputDTO> personInputDTOS = new ArrayList<>();
        people.stream().forEach((i -> personInputDTOS.add(personToDTO(i))));
        return personInputDTOS;
    }

    public PersonInputDTO personToDTO(Person person) {
        PersonInputDTO personInputDTO = new PersonInputDTO();

        personInputDTO.setId(person.getId());
        personInputDTO.setName(person.getName());
        personInputDTO.setSurname(person.getSurname());
        personInputDTO.setUsername(person.getUsername());
        personInputDTO.setPassword(person.getPassword());
        personInputDTO.setRoleId(person.getRole().getId());
        return personInputDTO;
    }

    public Person personFromDto(PersonInputDTO personInputDTO) {
        Person person = new Person();

        person.setId(personInputDTO.getId());
        person.setName(personInputDTO.getName());
        person.setSurname(personInputDTO.getSurname());
        person.setUsername(personInputDTO.getUsername());
        person.setPassword(personInputDTO.getPassword());
        person.setRole(roleRepository.findRoleById(personInputDTO.getRoleId()));
        return person;
    }

    private PersonOutputDTO personToDTO2(Person person) {
        PersonOutputDTO personOutputDTO = new PersonOutputDTO();

        personOutputDTO.setId(person.getId());
        personOutputDTO.setName(person.getName());
        personOutputDTO.setSurname(person.getSurname());
        personOutputDTO.setUsername(person.getUsername());
        personOutputDTO.setPassword(person.getPassword());
        personOutputDTO.setRoleName(person.getRole().getName());
        return personOutputDTO;
    }

    public ArrayList<PersonOutputDTO> persontoDTO2(ArrayList<Person> people) {
        ArrayList<PersonOutputDTO> personOutputDTOS = new ArrayList<>();
        people.stream().forEach((i -> personOutputDTOS.add(personToDTO2(i))));
        return personOutputDTOS;
    }
}
