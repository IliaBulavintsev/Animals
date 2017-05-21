package com.example.ilia.animals;

import android.app.Application;

public class BackGroundTaskApp extends Application  implements  AnimalGeneratorProvider{

    private AnimalGenerator animalGenerator;

    @Override
    public void onCreate() {
        super.onCreate();
        animalGenerator = new AnimalGenerator(AnimalGenerator.providersAnimals());
    }


    @Override
    public AnimalGenerator getAnimalGenerator() {
        return animalGenerator;
    }
}
