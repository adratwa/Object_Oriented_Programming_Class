package agh.ics.oop;

import java.util.Objects;

public class Grass implements IElement {


    private Vector2d positionBunchOfGrass;

    public Grass(Vector2d positionBunchOfGrass) {
        this.positionBunchOfGrass = positionBunchOfGrass;

    }

    @Override
    public Vector2d getLocation() {
        return positionBunchOfGrass;
    }

    public boolean isAt(Vector2d position) {
        return Objects.equals(this.positionBunchOfGrass, position);
    }



    @Override
    public String toString() {
        return "*";
    }

}
