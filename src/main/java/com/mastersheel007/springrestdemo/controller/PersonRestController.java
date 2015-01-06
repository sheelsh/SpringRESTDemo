package com.mastersheel007.springrestdemo.controller;

import com.mastersheel007.springrestdemo.domain.Person;
import com.mastersheel007.springrestdemo.dto.PersonDTO;
import com.mastersheel007.springrestdemo.service.intf.IPersonService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mastersheel007
 */
@Controller
public class PersonRestController {
            
    @Autowired
    private IPersonService personService;
    
    @RequestMapping(value = "/RESTService/Person/", method = RequestMethod.GET)
    public @ResponseBody
    String personHome() {
        return "<h1>Welcome To The RESTFul Person</h1>";
    }
    
    @RequestMapping(value = "/RESTService/Person/createPerson/", method = RequestMethod.POST)
    public @ResponseBody
    PersonDTO createPerson(@RequestBody PersonDTO personDTO, HttpServletResponse httpServletResponse) {
        return new PersonDTO().toDTO(personService.createPerson(personDTO.toDomain()));
    }
    
    @RequestMapping(value = "/RESTService/Person/deletePerson/{personId}/", method = RequestMethod.DELETE)
    public @ResponseBody
    Boolean deletePerson(@PathVariable("personId") Long personId) {
        return personService.deletePersonById(personId);
    }
    
    @RequestMapping(value = "/RESTService/Person/getPerson/{personId}/", method = RequestMethod.GET)
    public @ResponseBody
    PersonDTO getPerson(@PathVariable("personId") Long personId) {
        return new PersonDTO().toDTO(personService.findById(personId));
    }
    
    @RequestMapping(value = "/RESTService/Person/updatePerson/", method = RequestMethod.POST, headers="Accept=application/json")
    public @ResponseBody
    PersonDTO updatePerson(@RequestBody PersonDTO updatedPersonDTO) {
        return new PersonDTO().toDTO(personService.updatePerson(updatedPersonDTO.toDomain()));
    }
    
    @RequestMapping(value = "/RESTService/Person/getAllPersons/", method = RequestMethod.GET)
    public @ResponseBody
    List<Person> getAllPersons() {
        return personService.findAll();
    }
}