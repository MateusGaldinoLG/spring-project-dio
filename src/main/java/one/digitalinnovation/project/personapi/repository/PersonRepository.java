package one.digitalinnovation.project.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.project.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
