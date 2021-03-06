package one.digitalinnovation.project.personapi.dto.request;

//DTO = Data Transfer Object

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.project.personapi.entity.Phone;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    
    private Long id;

    @NotEmpty
    @Size(min=2, max=100)
    private String firstName;

    @NotEmpty
    @Size(min=2, max=100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpfString;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;
}
