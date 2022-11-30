package agh.ics.oop;

import java.util.Objects;

public class Grass {
    /*
    Nie dodałam interejsu IMapElement, gdyż uważam że w tym przypadku nie uprościłby implementacji klasy Animal i Grass
    Niektore funkcje, np isOccupiedByGrass operują tylko na trawie/ zwierzetach, wiec zrobienie jednej listy IMapElement utrudniłoby
    implementaacje tej funkcji (za kazdym razem przy iterowaniu należałoby sprawdzac jaki to typ, co mija sie z celem)

    *  */

    private Vector2d positionBunchOfGrass;

    public Grass(Vector2d positionBunchOfGrass) {
        this.positionBunchOfGrass = positionBunchOfGrass;

    }

    public Vector2d getPositionBunchOfGrass() {
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
