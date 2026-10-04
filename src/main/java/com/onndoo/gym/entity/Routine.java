package com.onndoo.gym.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "routines")
public class Routine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;        // Ej: "Empuje / Push"
    private String targetGoal;  // Ej: "Hipertrofia"
    
    @ElementCollection
    private List<String> exercises; // Ej: ["Banca plana", "Press militar"]

    // Constructores, Getters y Setters
    public Routine() {}
    public Routine(String name, String targetGoal, List<String> exercises) {
        this.name = name;
        this.targetGoal = targetGoal;
        this.exercises = exercises;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTargetGoal() { return targetGoal; }
    public void setTargetGoal(String targetGoal) { this.targetGoal = targetGoal; }
    public List<String> getExercises() { return exercises; }
    public void setExercises(List<String> exercises) { this.exercises = exercises; }
}
