package one.digitalinnovation.project.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.project.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.project.personapi.entity.Person;
import one.digitalinnovation.project.personapi.repository.PersonRepository;

//REST layer
@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        System.out.println(person);
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
                                 .message("Created person with ID "+savedPerson.getId())
                                 .build();
    }
}
