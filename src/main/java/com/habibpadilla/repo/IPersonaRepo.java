package com.habibpadilla.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.habibpadilla.model.Person;

public interface IPersonaRepo extends JpaRepository<Person, Integer> {

}
