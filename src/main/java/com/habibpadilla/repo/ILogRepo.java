package com.habibpadilla.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habibpadilla.model.Log;

public interface ILogRepo extends JpaRepository<Log, Integer> {

}
