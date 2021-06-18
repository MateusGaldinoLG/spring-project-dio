package one.digitalinnovation.project.personapi.service;

import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.project.exception.PersonNotFoundException;
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
        return createMessageResponse(savedPerson.getId(), "Create person with id: ");
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                        .map(personMapper::toDTO)
                        .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        //Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException{
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(savedPerson.getId(), "Update person with id: ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                                 .message(message + id)
                                 .build();
    }
}
