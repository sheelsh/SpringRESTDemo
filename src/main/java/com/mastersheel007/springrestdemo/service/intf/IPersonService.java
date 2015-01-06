package com.mastersheel007.springrestdemo.service.intf;

import com.mastersheel007.springrestdemo.domain.Person;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mastersheel007
 */
@Service
public interface IPersonService {

    public Person createPerson(Person person);

    public Boolean deletePersonById(Long personId);

    public Person findById(Long personId);

    public Person updatePerson(Person person);

    public List<Person> findAll();
}
