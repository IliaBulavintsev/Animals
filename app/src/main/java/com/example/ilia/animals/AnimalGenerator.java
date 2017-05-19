package com.example.ilia.animals;


import java.util.ArrayList;
import java.util.List;

public class AnimalGenerator {

    public static final List<Animal> providersAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Кот", 10, "Барсик"));
        animals.add(new Animal("Кит", 2, "Вася"));
        animals.add(new Animal("Собака", 5, "Бобик"));
        return animals;
    }
}
