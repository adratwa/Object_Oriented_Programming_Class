package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private SortedSet<Vector2d> sortedElementsX;
    private SortedSet<Vector2d> sortedElementsY;

    public SortedSet<Vector2d> getSortedElementsX() {
        return sortedElementsX;
    }

    public SortedSet<Vector2d> getSortedElementsY() {
        return sortedElementsY;
    }

    public MapBoundary() {

        Comparator comparatorX = new XPositionComparator();
        Comparator comparatorY = new YPositionComparator();
        sortedElementsX = new TreeSet<>(comparatorX);
        sortedElementsY = new TreeSet<>(comparatorY);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.sortedElementsX.remove(oldPosition);
        this.sortedElementsX.add(newPosition);
        this.sortedElementsY.remove(oldPosition);
        this.sortedElementsY.add(newPosition);

    }

    public void addElementX (Vector2d vector) {
        this.sortedElementsX.add(vector);
    }

    public void addElementY (Vector2d vector) {
        this.sortedElementsY.add(vector);
    }

    public Vector2d lowerBound () {
        return new Vector2d(this.sortedElementsX.last().x, this.sortedElementsY.last().y);
    }

    public Vector2d upperBound () {
        return new Vector2d(this.sortedElementsX.first().x, this.sortedElementsY.first().y);
    }
}
