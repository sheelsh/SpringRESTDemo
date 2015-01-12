package com.mastersheel007.springrestdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mastersheel007.springrestdemo.domain.Person;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mastersheel007
 */
@XmlRootElement(name = "person")
@XmlType(propOrder = {"personId", "firstName", "lastName"})
@JsonPropertyOrder({"personId", "firstName", "lastName"})
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long personId;

    private String firstName;

    private String lastName;

    @XmlElement
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @JsonIgnore
    public Person toDomain(){
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        if(this.personId!=null){
            person.setPersonId(this.personId);
        }
        return person;
    }
    
    @JsonIgnore
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