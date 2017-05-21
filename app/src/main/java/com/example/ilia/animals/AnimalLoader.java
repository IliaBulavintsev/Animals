package com.example.ilia.animals;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

public class AnimalLoader extends AsyncTaskLoader<List<Animal>> implements OncontentChangeListener {

    private static final String TAG= "AnimalLoader";
    private List<Animal> animals;
    private AnimalGenerator animalGenerator;



    public AnimalLoader(Context context, AnimalGenerator animalGenerator) {
        super(context);
        this.animalGenerator = animalGenerator;
        this.animalGenerator.addOnContentChangeListener(this);

    }

    @Override
    public List<Animal> loadInBackground() {
        Log.e(TAG, "on back" + animalGenerator.getAnimals().toString());
        return animalGenerator.getAnimals();
    }



    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.e(TAG, "onStartLoading: animals:" + animals );
        if ((animals == null) || takeContentChanged()) {
            Log.e(TAG, "onStartLoading: forceload");
            forceLoad();
        } else {
            Log.e(TAG, "onStartLoading: noforceload:"  );
//            deliverResult(animals);
        }
        Log.v(TAG, "on start loading");
    }

    @Override
    public void deliverResult(List<Animal> data) {
        super.deliverResult(data);
        Log.e(TAG, "deliverResult: "+ data.toString() );
        animals = data;
    }

    @Override
    public void onAnimalAdded(AnimalGenerator sender, Animal animal) {
        onContentChanged();
    }
}
