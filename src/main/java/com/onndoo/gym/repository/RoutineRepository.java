package com.onndoo.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onndoo.gym.entity.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
}