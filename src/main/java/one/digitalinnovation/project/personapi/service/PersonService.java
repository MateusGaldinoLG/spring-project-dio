package one.digitalinnovation.project.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.project.mapper.PersonMapper;
import one.digitalinnovation.project.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.project.personapi.dto.request.PersonDTO;
import one.digitalinnovation.project.personapi.entity.Person;
import one.digitalinnovation.project.personapi.repository.PersonRepository;

//REST layer
@Service
@AllArgsConstructor(onConstructor_= {@Autowired})
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper;

    //DTO to Entity using mapstruct
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        //System.out.println(personDTO);
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
                                 .message("Created person with ID "+savedPerson.getId())
                                 .build();
    }
}
