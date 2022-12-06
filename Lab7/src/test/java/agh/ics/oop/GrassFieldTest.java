package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    void placeTest() {
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(grassField, new Vector2d(3,3));
        Animal animal2 = new Animal(grassField, new Vector2d(11,1));

        assertAll(
                () -> assertEquals(true, grassField.place(animal1)),
                () -> assertEquals(true, grassField.place(animal2)),
                () -> assertThrows(IllegalArgumentException.class, () -> {
            grassField.place(animal2);
        })
        );
    }

    @Test
    void isOccupiedTest() {
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(grassField, new Vector2d(3,3));
        Animal animal2 = new Animal(grassField, new Vector2d(1,1));
        grassField.place(animal1);
        grassField.place(animal2);
        assertAll(
                () -> assertEquals(true, grassField.isOccupied(new Vector2d(3,3))),
                () -> assertEquals(true, grassField.isOccupied(new Vector2d(1,1)))

        );
    }

    @Test
    void objectAtTest() {
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(grassField, new Vector2d(3, 3));
        Animal animal2 = new Animal(grassField, new Vector2d(1, 1));
        grassField.place(animal1);
        grassField.place(animal2);
        assertAll(
                () -> assertEquals(animal1, grassField.objectAt(new Vector2d(3, 3))),
                () -> assertEquals(animal2, grassField.objectAt(new Vector2d(1, 1))),
                () -> assertEquals(null, grassField.objectAt(new Vector2d(20, 20)))

        );
    }

        @Test
        void canMoveToTest() {
            GrassField grassField = new GrassField(10);
            Animal animal1 = new Animal(grassField, new Vector2d(3,3));
            Animal animal2 = new Animal(grassField, new Vector2d(1,1));
            grassField.place(animal1);
            grassField.place(animal2);
            assertAll(
                    () -> assertEquals(false, grassField.canMoveTo(new Vector2d(3,3))),
                    () -> assertEquals(false, grassField.canMoveTo(new Vector2d(1,1))),
                    () -> assertEquals(true, grassField.canMoveTo(new Vector2d(2,2))),
                    () -> assertEquals(true, grassField.canMoveTo(new Vector2d(-1,-1))),
                    () -> assertEquals(true, grassField.canMoveTo(new Vector2d(30,35))),
                    () -> assertEquals(true, grassField.canMoveTo(new Vector2d(0,0)))

            );
    }
}
