package com.mastersheel007.springrestdemo.service.impl;

import com.mastersheel007.springrestdemo.domain.Person;
import com.mastersheel007.springrestdemo.repo.IPersonRepository;
import com.mastersheel007.springrestdemo.service.intf.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mastersheel007
 */
@Component
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonRepository personRepository;
    
    @Override
    public Person createPerson(Person person) {
        person.setModificationTime();
        return personRepository.save(person);
    }

    @Override
    public Boolean deletePersonById(Long personId) {
        try{
            personRepository.delete(personId);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Person findById(Long personId) {
        return personRepository.findOne(personId);
    }

    @Override
    public Person updatePerson(Person updatedPerson) {
        Person person = personRepository.findOne(updatedPerson.getPersonId());
        person.setFirstName(updatedPerson.getFirstName());
        person.setLastName(updatedPerson.getLastName());
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    
}
