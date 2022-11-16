package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTests {

    @Test
    void moveTwoAnimalsAroundTheMapWithCollision() {
        String[] arg = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse2(arg);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertAll(
                () -> assertEquals(MapDirection.SOUTH, map.getListOfAnimals().get(0).getOrientation()),
                () -> assertEquals(new Vector2d(2,0), map.getListOfAnimals().get(0).getLocation()),
                () -> assertEquals(MapDirection.NORTH, map.getListOfAnimals().get(1).getOrientation()),
                () -> assertEquals(new Vector2d(3,5), map.getListOfAnimals().get(1).getLocation())
        );
    }

    @Test
    void moveThreeAnimalsAroundTheMapUnevenNUmberOfTimes() {
        String[] arg = new String[] {"r", "l", "b", "b", "b", "r", "f"};
        MoveDirection[] directions = new OptionParser().parse2(arg);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(0,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertAll(
                () -> assertEquals(MapDirection.EAST, map.getListOfAnimals().get(0).getOrientation()),
                () -> assertEquals(new Vector2d(2,2), map.getListOfAnimals().get(0).getLocation()),
                () -> assertEquals(MapDirection.WEST, map.getListOfAnimals().get(1).getOrientation()),
                () -> assertEquals(new Vector2d(4,4), map.getListOfAnimals().get(1).getLocation()),
                () -> assertEquals(MapDirection.EAST, map.getListOfAnimals().get(2).getOrientation()),
                () -> assertEquals(new Vector2d(0,0), map.getListOfAnimals().get(2).getLocation())
        );
    }


}
