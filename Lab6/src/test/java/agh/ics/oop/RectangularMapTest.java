package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangularMapTest {

    @Test
    void isOccupiedTest() {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(rectangularMap, new Vector2d(3,3));
        Animal animal2 = new Animal(rectangularMap, new Vector2d(1,1));
        rectangularMap.place(animal1);
        rectangularMap.place(animal2);
        assertAll(
                () -> assertEquals(true, rectangularMap.isOccupied(new Vector2d(3,3))),
                () -> assertEquals(true, rectangularMap.isOccupied(new Vector2d(1,1))),
                () -> assertEquals(false, rectangularMap.isOccupied(new Vector2d(8,1)))

        );
    }

    @Test
    void objectAtTest() {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(rectangularMap, new Vector2d(3,3));
        Animal animal2 = new Animal(rectangularMap, new Vector2d(1,1));
        rectangularMap.place(animal1);
        rectangularMap.place(animal2);
        assertAll(
                () -> assertEquals(animal1, rectangularMap.objectAt(new Vector2d(3, 3))),
                () -> assertEquals(animal2, rectangularMap.objectAt(new Vector2d(1, 1))),
                () -> assertEquals(null, rectangularMap.objectAt(new Vector2d(0, 1)))

        );
    }

    @Test
    void canMoveToTest() {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(rectangularMap, new Vector2d(3,3));
        Animal animal2 = new Animal(rectangularMap, new Vector2d(1,1));
        rectangularMap.place(animal1);
        rectangularMap.place(animal2);
        assertAll(
                () -> assertEquals(false, rectangularMap.canMoveTo(new Vector2d(3,3))),
                () -> assertEquals(false, rectangularMap.canMoveTo(new Vector2d(1,1))),
                () -> assertEquals(true, rectangularMap.canMoveTo(new Vector2d(2,2))),
                () -> assertEquals(false, rectangularMap.canMoveTo(new Vector2d(-1,-1))),
                () -> assertEquals(false, rectangularMap.canMoveTo(new Vector2d(30,35))),
                () -> assertEquals(true, rectangularMap.canMoveTo(new Vector2d(0,0)))

        );
    }

    @Test
    void placeTest() {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(rectangularMap, new Vector2d(3,3));
        Animal animal2 = new Animal(rectangularMap, new Vector2d(11,1));

        assertAll(
                () -> assertEquals(true, rectangularMap.place(animal1)),
                () -> assertEquals(false, rectangularMap.place(animal2))

        );
    }
}
