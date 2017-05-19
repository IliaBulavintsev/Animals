package com.example.ilia.animals;


import java.util.Stack;

public class Animal {
    private String mSpecies;
    private int mAge;
    private String mName;

    public Animal(String mSpecies, int mAge, String mName) {
        this.mSpecies = mSpecies;
        this.mAge = mAge;
        this.mName = mName;
    }

    public String getmSpecies() {
        return mSpecies;
    }

    public void setmSpecies(String mSpecies) {
        this.mSpecies = mSpecies;
    }

    public String getmAge() {
        return (String.valueOf( mAge));
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (mAge != animal.mAge) return false;
        if (mSpecies != null ? !mSpecies.equals(animal.mSpecies) : animal.mSpecies != null)
            return false;
        return mName != null ? mName.equals(animal.mName) : animal.mName == null;

    }

    @Override
    public int hashCode() {
        int result = mSpecies != null ? mSpecies.hashCode() : 0;
        result = 31 * result + mAge;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        return result;
    }
}
