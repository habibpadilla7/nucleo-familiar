package com.habibpadilla.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habibpadilla.model.Family;


public interface IFamilyRepo extends JpaRepository<Family, Integer> {

}
