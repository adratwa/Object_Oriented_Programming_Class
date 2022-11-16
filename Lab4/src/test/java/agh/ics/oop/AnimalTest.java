
package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Vector2d v1 = new Vector2d(3,4);


    @Test
    void beginningOrientationTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal = new Animal(map, v1);
        map.place(animal);
        assertAll(
                () -> assertEquals(MapDirection.NORTH, animal.getOrientation()),
                () -> assertEquals(new Vector2d(3,4), animal.getLocation())
        );
    }

    @Test
    void moveAnimalRightAndForwardTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal = new Animal(map, v1);
        map.place(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(4,4), animal.getLocation()),
                () -> assertEquals(MapDirection.EAST, animal.getOrientation())
        );
    }

    @Test
    void moveAnimalLeftAndForwardTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal = new Animal(map, v1);
        map.place(animal);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,4), animal.getLocation()),
                () -> assertEquals(MapDirection.WEST, animal.getOrientation())
        );
    }


    @Test
    void moveAnimalRightAndBackwardTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map, v1);
        map.place(animal1);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(2,4), animal1.getLocation()),
                () -> assertEquals(MapDirection.EAST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalLeftAndBackwardTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map, v1);
        map.place(animal1);
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(4,4), animal1.getLocation()),
                () -> assertEquals(MapDirection.WEST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalRightRightForwardTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map, v1);
        map.place(animal1);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(3,3), animal1.getLocation()),
                () -> assertEquals(MapDirection.SOUTH, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalRightRightBackwardTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map, v1);
        map.place(animal1);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(3,5), animal1.getLocation()),
                () -> assertEquals(MapDirection.SOUTH, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapSouthTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map, v1);
        map.place(animal1);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        animal1.move(MoveDirection.BACKWARD);
        assertAll(
                () -> assertEquals(new Vector2d(3,0), animal1.getLocation()),
                () -> assertEquals(MapDirection.NORTH, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapEastTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map, v1);
        map.place(animal1);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(8, 4), animal1.getLocation()),
                () -> assertEquals(MapDirection.EAST, animal1.getOrientation())
        );
    }

    @Test
    void moveAnimalOffTheMapWestTest() {
        IWorldMap map = new RectangularMap(8,8);
        Animal animal1 = new Animal(map,v1);
        map.place(animal1);
        animal1.move(MoveDirection.LEFT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        assertAll(
                () -> assertEquals(new Vector2d(0,4), animal1.getLocation()),
                () -> assertEquals(MapDirection.WEST, animal1.getOrientation())
        );
    }

}
