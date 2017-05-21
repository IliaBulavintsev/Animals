package com.example.ilia.animals;


import java.util.ArrayList;
import java.util.List;

public class AnimalGenerator {

    private List<Animal> animals;
    private List<OncontentChangeListener> listeners;

    public static final List<Animal> providersAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Кот", 10, "Барсик"));
        animals.add(new Animal("Кит", 2, "Вася"));
        animals.add(new Animal("Собака", 5, "Бобик"));
        return animals;
    }

    public AnimalGenerator(List<Animal> animals) {
        this.animals = animals;
        this.listeners = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        for (OncontentChangeListener listener : listeners) {
            listener.onAnimalAdded(this, animal);
        }
    }

    public void addOnContentChangeListener(OncontentChangeListener listener) {
        listeners.add(listener);
    }

    public void removeOnContentChangeListener(OncontentChangeListener listener) {
        listeners.remove(listener);
    }

}
