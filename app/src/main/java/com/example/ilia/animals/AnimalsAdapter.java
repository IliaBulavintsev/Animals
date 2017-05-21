package com.example.ilia.animals;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class AnimalsAdapter extends BaseAdapter {

    private final List<Animal> animals;

    public AnimalsAdapter() {
        this.animals = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Animal getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_animal_item,
                    parent, false);
            itemView.setTag(new ViewHolder(itemView));
        }
        bindView(itemView, position);
        return itemView;
    }

    private void bindView(View itemView, int position) {
        ViewHolder holder = (ViewHolder) itemView.getTag();
        Animal animal = animals.get(position);
        holder.speciesTextView.setText(animal.getmSpecies());
        holder.ageTextView.setText(animal.getmAge());
        holder.nameTextView.setText(animal.getmName());
    }

    public void setAnimals(List<Animal> animals) {
        Log.e(TAG, "setAnimals: " + animals.toString());
        this.animals.clear();
        this.animals.addAll(animals);
        notifyDataSetChanged();
    }

    private static class ViewHolder {

        public final TextView speciesTextView;
        public final TextView ageTextView;
        public final TextView nameTextView;

        public ViewHolder(View itemView) {
            speciesTextView = (TextView) itemView.findViewById(R.id.text_type);
            ageTextView = (TextView) itemView.findViewById(R.id.text_age);
            nameTextView = (TextView) itemView.findViewById(R.id.text_name);
        }
    }
}
