package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static final Vector2d UPPER_BOUND = new Vector2d(4,4);


    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getLocation() {
        return location;
    }

    private Vector2d location;

    public Animal() {
        this.orientation = MapDirection.NORTH;
        location = new Vector2d(2,2);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", location=" + location +
                '}';
    }

    public boolean isAt(Vector2d position) {
        return Objects.equals(this.location, position);
    }

    public void  move(MoveDirection direction) {
        Vector2d newVector = this.location;
        switch(direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                switch (this.orientation) {
                    case NORTH -> newVector = this.location.add(new Vector2d(0, 1));
                    case EAST -> newVector = this.location.add(new Vector2d(1, 0));
                    case SOUTH -> newVector = this.location.subtract(new Vector2d(0, 1));
                    case WEST -> newVector = this.location.subtract(new Vector2d(1, 0));
                }
                break;
            case BACKWARD:
                switch (this.orientation) {
                    case NORTH -> newVector = this.location.subtract(new Vector2d(0, 1));
                    case EAST -> newVector = this.location.subtract(new Vector2d(1, 0));
                    case SOUTH -> newVector = this.location.add(new Vector2d(0, 1));
                    case WEST -> newVector= this.location.add(new Vector2d(1, 0));
                }
                break;
            default:
        }

        if (newVector.follows(LOWER_BOUND) && newVector.precedes(UPPER_BOUND)) {
            this.location = newVector;
        }

    }
}
