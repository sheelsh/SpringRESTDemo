package com.mastersheel007.springrestdemo.repo;

import com.mastersheel007.springrestdemo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mastersheel007
 */
@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{}
