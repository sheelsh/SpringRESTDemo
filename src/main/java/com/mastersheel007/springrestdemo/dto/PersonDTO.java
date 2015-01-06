package com.mastersheel007.springrestdemo.dto;

import com.mastersheel007.springrestdemo.domain.Person;
import java.io.Serializable;

/**
 *
 * @author mastersheel007
 */
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long personId;

    private String firstName;

    private String lastName;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Person toDomain(){
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        if(this.personId!=null){
            person.setPersonId(this.personId);
        }
        return person;
    }
    
    public PersonDTO toDTO(Person person){
        PersonDTO personDTO = new PersonDTO();
        if(person.getPersonId()!=null){
            personDTO.setPersonId(person.getPersonId());
        }
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        return personDTO;
    }

}
