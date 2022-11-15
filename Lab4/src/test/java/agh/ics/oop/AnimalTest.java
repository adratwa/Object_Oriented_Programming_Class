package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    void begininngOrientationTest() {
        assertAll(
            () -> assertEquals(MapDirection.NORTH, new Animal().getOrientation()),
            () -> assertEquals(new Vector2d(2,2), new Animal().getLocation())
        );
    }


    @Test
    void moveAnimalRightAndForwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(3,2), animal1.getLocation()),
                () -> assertEquals(MapDirection.EAST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalLeftAndForwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(1,2), animal1.getLocation()),
                () -> assertEquals(MapDirection.WEST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalRightAndBackwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(1,2), animal1.getLocation()),
                () -> assertEquals(MapDirection.EAST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalLeftAndBackwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(3,2), animal1.getLocation()),
                () -> assertEquals(MapDirection.WEST, animal1.getOrientation())
        );
    }



    @Test
    void moveAnimalRightRightForwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,1), animal1.getLocation()),
                () -> assertEquals(MapDirection.SOUTH, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalRightRightBackwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,3), animal1.getLocation()),
                () -> assertEquals(MapDirection.SOUTH, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalForwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,3), animal1.getLocation()),
                () -> assertEquals(MapDirection.NORTH, new Animal().getOrientation())
        );
    }

    @Test
    void moveAnimalBackwardTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,1), animal1.getLocation()),
                () -> assertEquals(MapDirection.NORTH, new Animal().getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapNorthTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,4), animal1.getLocation()),
                () -> assertEquals(MapDirection.NORTH, new Animal().getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapSouthTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,0), animal1.getLocation()),
                () -> assertEquals(MapDirection.NORTH, new Animal().getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapEastTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(4, 2), animal1.getLocation()),
                () -> assertEquals(MapDirection.EAST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapWestTest() {
        Animal animal1 = new Animal();
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(0,2), animal1.getLocation()),
                () -> assertEquals(MapDirection.WEST, animal1.getOrientation())
        );
    }

}
