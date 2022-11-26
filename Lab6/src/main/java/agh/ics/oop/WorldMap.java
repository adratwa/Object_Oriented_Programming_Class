package agh.ics.oop;

import java.util.List;

public abstract class WorldMap implements IWorldMap {

    protected List<Animal> animalList;

    @Override
    public List<Animal> getListOfAnimals() {
        return List.copyOf(this.animalList);
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
    public Object objectAt(Vector2d position) {
        return this.animalList.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst()
                .orElse(null);
    }



    public abstract Vector2d calculateUpperBound();
    public abstract Vector2d calculateLowerBound();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.calculateLowerBound(), this.calculateUpperBound());
    }

}
