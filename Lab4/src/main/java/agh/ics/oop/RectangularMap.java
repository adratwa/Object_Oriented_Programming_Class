package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private int width;
    private int height;
    private List<Animal> listOfAnimals;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        listOfAnimals = new ArrayList<Animal>();
    }

    public List<Animal> getListOfAnimals() {
        return List.copyOf(listOfAnimals); // ze wzgledow bezpieczenstwa robimy kopie zeby nie mozna bylo tego zmienic
        // return Collections.unmodifiableList(listOfAnimals); //blokuje dostep do tej listy, lepsze niz kopia bo bardziej wydajne
    }

    // tu poprawić
    @Override
    public boolean canMoveTo(Vector2d position) {

        for (Animal animal : listOfAnimals) {
            if (animal.isAt(position) || !position.precedes(new Vector2d(this.width, this.height)) || !position.follows(new Vector2d(0,0))) {
                return false;}
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            listOfAnimals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
//        for (Animal animal : listOfAnimals) {
//            if (animal.isAt(position) ) { return true;}
//        }
//        return false;

        // drugi sposob na streamach
        return listOfAnimals.stream()
                .anyMatch(animal -> animal.isAt(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
//        for (Animal animal : listOfAnimals) {
//            if (animal.isAt(position) ) { return animal;}
//        }
//        return null;

        return listOfAnimals.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst()
                .orElse(null);
    }


    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }
}
