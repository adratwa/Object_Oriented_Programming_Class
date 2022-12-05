package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapDirectionTest {

    @Test
    void nextTest(){
        MapDirection direction = MapDirection.WEST;
        MapDirection direction2 = MapDirection.NORTH;
        MapDirection direction3 = MapDirection.EAST;
        MapDirection direction4 = MapDirection.SOUTH;
        

        assertAll(
                () -> assertEquals(MapDirection.NORTH, direction.next()),
                () -> assertEquals(MapDirection.EAST, direction2.next()),
                () -> assertEquals(MapDirection.SOUTH, direction3.next()),
                () -> assertEquals(MapDirection.WEST, direction4.next())
        );

    }

    @Test
    void previousTest(){
        MapDirection direction = MapDirection.WEST;
        MapDirection direction2 = MapDirection.NORTH;
        MapDirection direction3 = MapDirection.EAST;
        MapDirection direction4 = MapDirection.SOUTH;

        assertAll(
                () -> assertEquals(MapDirection.SOUTH, direction.previous()),
                () -> assertEquals(MapDirection.WEST, direction2.previous()),
                () -> assertEquals(MapDirection.NORTH, direction3.previous()),
                () -> assertEquals(MapDirection.EAST, direction4.previous())
        );

    }


}
