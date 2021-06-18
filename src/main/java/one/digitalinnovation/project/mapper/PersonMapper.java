package one.digitalinnovation.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import one.digitalinnovation.project.personapi.dto.request.PersonDTO;
import one.digitalinnovation.project.personapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    //converters toModel and toDTO
    @Mapping(target = "birthDate", source="birthDate", dateFormat="dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
