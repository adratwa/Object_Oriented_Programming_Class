package agh.ics.oop;

public class RectangularMap extends WorldMap  {

    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (!position.precedes(new Vector2d(this.width, this.height)) || !position.follows(new Vector2d(0, 0))|| this.isOccupied(position) ) {
            return false;
        }
        return true;
    }
    @Override
    public Vector2d calculateLowerBound() {
        return new Vector2d(0, 0);
    }

    @Override
    public Vector2d calculateUpperBound() {
        return new Vector2d(this.width, this.height);
    }


}
