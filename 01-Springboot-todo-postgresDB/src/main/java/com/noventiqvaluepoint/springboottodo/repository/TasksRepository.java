package com.noventiqvaluepoint.springboottodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noventiqvaluepoint.springboottodo.model.entity.Tasks;

// @Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    boolean existsByName(String name);
}
