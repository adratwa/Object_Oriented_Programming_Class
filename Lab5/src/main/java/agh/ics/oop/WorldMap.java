package agh.ics.oop;

import java.util.List;

public abstract class WorldMap implements IWorldMap {

    protected List<Animal> animalList;

    @Override
    public List<Animal> getListOfAnimals() {
        return List.copyOf(this.animalList);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if ( !position.follows(new Vector2d(0,0))) {
            return false;
        }
        // can't use isOccupied, because in grassfield class by isOccupied function we check also, if grass is at this position
        for (Animal animal : this.animalList) {
            if (animal.isAt(position) ) { return false;}
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            this.animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (this.objectAt(position) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animalList.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst()
                .orElse(null);
    }


    public abstract Vector2d calculateDimensionsOfMap();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), this.calculateDimensionsOfMap());
    }

}
