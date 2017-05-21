package com.example.ilia.animals;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int LOADER_ID = 1;
    private final static String TAG = "MainActivity";

    private TextView type;
    private TextView age;
    private TextView name;
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        type = (TextView) findViewById(R.id.text_type);
        name = (TextView) findViewById(R.id.text_name);
        age = (TextView) findViewById(R.id.text_age);
        refresh = (Button) findViewById(R.id.button_refresh);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalLoaderCallBacks());
        Log.v(TAG, "onCreate");

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportLoaderManager().getLoader(LOADER_ID).forceLoad();
            }
        });
    }

    private class AnimalLoaderCallBacks implements LoaderManager.LoaderCallbacks <Animal>{


        @Override
        public Loader<Animal> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<Animal> loader, Animal data) {
            type.setText(data.getmSpecies());
            age.setText( data.getmAge());
            name.setText(data.getmName());
        }

        @Override
        public void onLoaderReset(Loader<Animal> loader) {
            Log.e(TAG, "onLoaderReset" );
        }
    }

}
