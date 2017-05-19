package com.example.ilia.animals;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;
import java.util.Random;

public class AnimalLoader extends AsyncTaskLoader<Animal> {

    private static final String TAG= "RatesLoader";
    private List<Animal> animals;


    public AnimalLoader(Context context) {
        super(context);
        this.animals = AnimalGenerator.providersAnimals();

    }

    @Override
    public Animal loadInBackground() {
        Log.v(TAG, "on back");
        Random rn = new Random();
        int id = rn.nextInt(animals.size());
        return animals.get(id);
    }



    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
        Log.v(TAG, "on start loading");
    }
}
