package com.workintech.s17d1.controller;

import com.workintech.s17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/workintech/animal")
@RestController
public class AnimalController {
    Map<Integer, Animal> animals;

    @PostConstruct
    public void init() {
        this.animals = new HashMap<>();
        animals.put(1, new Animal(1, "papagan"));
        animals.put(2, new Animal(2, "kedi"));
        animals.put(3, new Animal(3, "kopek"));

    }

    @GetMapping
    public List<Animal> findAll() {
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id, @RequestBody Animal newAnimal){
        animals.put(id,newAnimal);
        return newAnimal;
    }

    @DeleteMapping("/{id}")
    public Animal delete(@PathVariable Integer id){
        return animals.remove(id);
    }

}
