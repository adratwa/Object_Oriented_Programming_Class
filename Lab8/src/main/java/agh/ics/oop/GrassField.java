package agh.ics.oop;

import java.util.*;

public class GrassField extends WorldMap implements IPositionChangeObserver{

    private int numberOfGrass;
    private Map<Vector2d, Grass> grasses = new HashMap<>();;



    private MapBoundary mapBoundary = new MapBoundary();
    public GrassField(int numberOfGrass) {
        this.numberOfGrass = numberOfGrass;
        for (int i=1; i <= numberOfGrass;i++ ){
            createGrass();
        }
    }
    public MapBoundary getMapBoundary() {
        return mapBoundary;
    }
    public Map<Vector2d, Grass> getGrassList() {
        return grasses;
    }

    @Override
    public boolean place(Animal animal) {
        boolean canPlace = super.place(animal);
        mapBoundary.addElementX(animal.getLocation());
        mapBoundary.addElementY(animal.getLocation());
        animal.addObserver(mapBoundary);
        return canPlace;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        // if animal steps on the grass, the grass vanishes and appears in new free place
        if (this.isOccupiedByGrass(position)) {
            this.grasses.remove(position);
            createGrass();

        }
        return (this.objectAt(position) instanceof Grass || this.objectAt(position) == null);

    }


    public boolean isOccupiedByGrass(Vector2d position) {
        return this.objectAt(position) instanceof Grass;
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object == null) {
            object = this.grasses.get(position);
        }
        return object;
    }

    // to jest niedeterministyczne, to nie jest dobry pomysl
    // moznaby to zorbic za pomoca collections shuffle
    public void createGrass() {
        Random random = new Random();
        while (true) {
            int x = random.nextInt((int) (Math.sqrt(this.numberOfGrass * 10) - 0));
            int y = random.nextInt((int) (Math.sqrt(this.numberOfGrass * 10) - 0));
            Vector2d vector = new Vector2d(x, y);
            Grass grass = new Grass(new Vector2d(x, y));
            if (!this.isOccupied(vector)) {
                this.grasses.put(vector, grass);
                this.mapBoundary.addElementX(grass.getLocation());
                this.mapBoundary.addElementY(grass.getLocation());
                break;
            }
        }
    }

    @Override
    public Vector2d calculateUpperBound() {

       return this.mapBoundary.upperBound();

    }

    @Override
    public Vector2d calculateLowerBound() {

        return this.mapBoundary.lowerBound();

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition, newPosition);
        //this.mapBoundary.positionChanged(oldPosition, newPosition);
    }
}
