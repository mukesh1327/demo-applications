package com.cloudxplorer13.springboottodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudxplorer13.springboottodo.model.entity.Tasks;

// @Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    boolean existsByName(String name);
}
