package com.application.functionalapproach.service;

import com.application.functionalapproach.model.Philosopher;
import com.application.functionalapproach.repository.PhilosopherRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PhilosopherService {

    private final PhilosopherRepository philosopherRepository;

    private PhilosopherService(PhilosopherRepository philosopherRepository) {
        this.philosopherRepository = philosopherRepository;
    }

    public Optional<Philosopher> getPhilosopherById(final Long id) {
        return philosopherRepository.findById(id);
    }

    public Optional<List<Philosopher>> getPhilosopherByCategory(final String category) {
        return philosopherRepository.findByCategory(category);
    }

    public Philosopher addPhilosopher(final Philosopher philosopher) {
        return philosopherRepository.save(philosopher);
    }

    // Stream API Operations
    public Optional<Integer> getOldestPhilosopherByAge() {

        List<Philosopher> philosophers = new ArrayList<>();
        var comparator = Comparator.comparing(Philosopher::getAge);
        var getOldestOne = philosophers.stream().max(comparator);
        return philosopherRepository.findOldestPhilosopherByAge(getOldestOne);

    }

    //TODO: PUT Method and Delete Method
    //TODO: GET: Philosopher > certain age
}
