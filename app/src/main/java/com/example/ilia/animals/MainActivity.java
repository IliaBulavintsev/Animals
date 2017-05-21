package com.example.ilia.animals;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static int LOADER_ID = 1;
    private final static String TAG = "MainActivity";

    private ListView listView;
    private AnimalsAdapter animalsAdapter;

    private AnimalGenerator animalGenerator;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalGeneratorProvider provider = (AnimalGeneratorProvider) getApplication();
        animalGenerator = provider.getAnimalGenerator();

        listView = (ListView) findViewById(R.id.list_view);
        animalsAdapter = new AnimalsAdapter();
        listView.setAdapter(animalsAdapter);

        addButton = (Button) findViewById(R.id.add_animal_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalLoaderCallBacks());
        Log.e(TAG, "onCreate" + animalGenerator.getAnimals());

    }

    private class AnimalLoaderCallBacks implements LoaderManager.LoaderCallbacks <List<Animal>>{


        @Override
        public Loader<List<Animal>> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this, animalGenerator);
        }

        @Override
        public void onLoadFinished(Loader<List<Animal>> loader, List<Animal> data) {
            animalsAdapter.setAnimals(data);
        }

        @Override
        public void onLoaderReset(Loader<List<Animal>> loader) {
            Log.e(TAG, "onLoaderReset" );
        }
    }

}
