package agh.ics.oop;

public class Animal {
    private MapDirection orientation;

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
        return this.location.equals(position);
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

        if (newVector.follows(new Vector2d(0,0)) && newVector.precedes(new Vector2d(4,4))) {
            this.location = newVector;
        }

    }
}
