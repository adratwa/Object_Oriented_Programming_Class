package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class WorldMap implements IWorldMap, IPositionChangeObserver{

    //protected List<Animal> animals;
    Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public Map<Vector2d, Animal> getMapOfAnimals() {
        return Map.copyOf(this.animals);
    }



    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            this.animals.put(animal.getLocation(), animal);
            animal.setId(this.animals.size());
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals.get(position);
    }



    public abstract Vector2d calculateUpperBound();
    public abstract Vector2d calculateLowerBound();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.calculateLowerBound(), this.calculateUpperBound());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) this.objectAt(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

}
