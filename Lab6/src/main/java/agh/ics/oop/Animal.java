package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements Comparable<Animal> {


    public int getId() {
        return id;
    }

    private int id;
    private Vector2d location;
    private MapDirection orientation;
    private IWorldMap map;
    private List<IPositionChangeObserver> observerList;

    // zrobic na odwrot konstruktory, to maly powinien "dziedziczyc" z zduzego
    public Animal(IWorldMap map) {
        this(map, new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d initialPoistion) {
        this.map = map;
        this.location = initialPoistion;
        this.orientation = MapDirection.NORTH;
        this.observerList = new ArrayList<>();
        this.addObserver((IPositionChangeObserver) map);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getLocation() {
        return location;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return this.orientation.toString();
    }

    public String toString2() {

        return "Animal{" +
                "orientation=" + this.orientation +
                ", location=" + this.location +
                '}';
    }

    public boolean isAt(Vector2d position) {
        return Objects.equals(this.location, position);
    }

    public void  move(MoveDirection direction) {
        Vector2d newVector = this.location;
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> newVector = this.location.add(this.orientation.toUnitVector());
            case BACKWARD -> newVector = this.location.subtract(this.orientation.toUnitVector());
            default -> {
            }
        }
        if (this.map.canMoveTo(newVector)) {
            this.positionChanged(this.location, newVector);
            this.location = newVector;
        }

    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observerList.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public int compareTo(Animal o) {
        return this.id - o.getId();
    }
}
