package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends WorldMap {

    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animalList = new ArrayList<Animal>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        boolean canMoveTo = super.canMoveTo(position);
        if (!position.precedes(new Vector2d(this.width, this.height))) {
            return false;
        }
        return canMoveTo;
    }
    @Override
    public Vector2d calculateDimensionsOfMap() {
        return new Vector2d(this.width, this.height);
    }

}
