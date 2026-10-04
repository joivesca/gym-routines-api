package com.onndoo.gym.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onndoo.gym.entity.Routine;
import com.onndoo.gym.repository.RoutineRepository;

@RestController
@RequestMapping("/api/routines")
@CrossOrigin(origins = "*") // Permite que tu frontend se conecte sin problemas de CORS
public class RoutineController {

    private final RoutineRepository repository;

    // Inyección por constructor (Buena práctica)
    public RoutineController(RoutineRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Routine> getAllRoutines() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Routine> createRoutine(@RequestBody Routine routine) {
        Routine savedRoutine = repository.save(routine);
        return ResponseEntity.ok(savedRoutine);
    }
}

