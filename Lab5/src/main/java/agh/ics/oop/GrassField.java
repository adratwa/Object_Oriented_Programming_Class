package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends WorldMap{

    private int numberOfGrass;
    private List<Grass> grassList;

    public GrassField(int numberOfGrass) {
        this.grassList = new ArrayList<Grass>();
        this.animalList = new ArrayList<Animal>();
        this.numberOfGrass = numberOfGrass;
        for (int i=1; i <= numberOfGrass;i++ ){
            createGrass();
            }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        boolean canMove = super.canMoveTo(position);
        if (canMove) {
            // if animal steps on the grass, the grass vanishes and appears in new free place
            if (this.isOccupiedByGrass(position)) {
                this.grassList.removeIf(grass -> grass.isAt(position));
                createGrass();
            }
        }
        return canMove;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean isOccupied = super.isOccupied(position);
        if (this.objectAt(position) != null) {
            return true;
        }
        return isOccupied;
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

    public void createGrass() {
        Random random = new Random();
        while (true) {
            int x = random.nextInt((int) (Math.sqrt(this.numberOfGrass * 10) - 0));
            int y = random.nextInt((int) (Math.sqrt(this.numberOfGrass * 10) - 0));
            Vector2d vector = new Vector2d(x, y);
            Grass grass = new Grass(new Vector2d(x, y));
            if (!this.isOccupied(vector)) {
                this.grassList.add(grass);
                break;
            }
        }
    }

    @Override
    public Vector2d calculateDimensionsOfMap() {

        int width = 0;
        int height = 0;

        for (Grass grass : this.grassList) {
            if (grass.getPositionBunchOfGrass().x > width) {
                width = grass.getPositionBunchOfGrass().x;
            }
            if (grass.getPositionBunchOfGrass().y > height) {
                height = grass.getPositionBunchOfGrass().y;
            }

        }

        for (Animal animal : this.animalList) {
            if (animal.getLocation().x > width) {
                width = animal.getLocation().x;
            }
            if (animal.getLocation().y > height) {
                height = animal.getLocation().y;
            }

        }


        return new Vector2d(width, height);

    }
}
