package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends WorldMap{

    //private int numberOfGrass;
    private List<Grass> grassList;

    public GrassField(int numberOfGrass) {
        this.grassList = new ArrayList<>();
        this.animalList = new ArrayList<>();
        for (int i=1; i <= numberOfGrass;i++ ){
            createGrass(numberOfGrass);
            }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        // if animal steps on the grass, the grass vanishes and appears in new free place
        if (this.isOccupiedByGrass(position)) {
            this.grassList.removeIf(grass -> grass.isAt(position));
            createGrass(this.grassList.size());

        }
        for (Animal animal : this.animalList) {
            if (animal.isAt(position) ) { return false;}
        }


        return true;
    }


    public boolean isOccupiedByGrass(Vector2d position) {
        for (Grass grass : this.grassList) {
            if (grass.isAt(position) ) { return true;}
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        for (Grass grass : this.grassList) {
            if (grass.isAt(position) ) { return grass;}
        }
        return object;
    }

    // to jest niedeterministyczne, to nie jest dobry pomysl
    // moznaby to zorbic za pomoca collections shuffle
    public void createGrass(int numberOfGrass) {
        Random random = new Random();
        while (true) {
            int x = random.nextInt((int) (Math.sqrt(numberOfGrass * 10) - 0));
            int y = random.nextInt((int) (Math.sqrt(numberOfGrass * 10) - 0));
            Vector2d vector = new Vector2d(x, y);
            Grass grass = new Grass(new Vector2d(x, y));
            if (!this.isOccupied(vector)) {
                this.grassList.add(grass);
                break;
            }
        }
    }

    @Override
    public Vector2d calculateUpperBound() {

        Vector2d upperBound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Grass grass : this.grassList) {
            upperBound = upperBound.upperRight(grass.getPositionBunchOfGrass());
        }

        for (Animal animal : this.animalList) {
            upperBound = upperBound.upperRight(animal.getLocation());
        }

        return upperBound;

    }

    @Override
    public Vector2d calculateLowerBound() {

        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Grass grass : this.grassList) {
            lowerBound = lowerBound.lowerLeft(grass.getPositionBunchOfGrass());
        }

        for (Animal animal : this.animalList) {
            lowerBound = lowerBound.lowerLeft(animal.getLocation());
        }

        return lowerBound;

    }
}
