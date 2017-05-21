package com.example.ilia.animals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText type;
    private EditText age;
    private EditText name;
    private Button addButton;
    private AnimalGenerator animalGenerator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        AnimalGeneratorProvider provider = (AnimalGeneratorProvider) getApplication();
        animalGenerator = provider.getAnimalGenerator();

        type = (EditText) findViewById(R.id.edit_type);
        age = (EditText) findViewById(R.id.edit_age);
        name = (EditText) findViewById(R.id.edit_name);
        addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addAnimal();
                finish();

            }
        });
    }

    private void addAnimal(){
        Animal animal = new Animal(type.getText().toString(),
                Integer.parseInt(age.getText().toString()),
                name.getText().toString());
        animalGenerator.addAnimal(animal);

    }
}
