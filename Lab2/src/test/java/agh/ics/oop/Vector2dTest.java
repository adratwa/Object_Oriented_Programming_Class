package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {

    @Test
    void equalsTest() {
        Vector2d vector = new Vector2d(3,4);
        Object other = new Vector2d(3, 4);
        Object other2 = null;
        assertAll(
                () -> assertEquals (true, vector.equals(other)),
                () -> assertEquals (false, vector.equals(other2))
                );
    }

    @Test
    void toStringTest() {
        Vector2d vector = new Vector2d(3,4);
        assertEquals("(3, 4)", vector.toString());
    }

    @Test
    void precedesTest() {
        Vector2d vector = new Vector2d(3,4);
        Vector2d other = new Vector2d(4,5);
        Vector2d other2 = new Vector2d(3, 4);
        Vector2d other3 = new Vector2d(1, 2);
        assertAll(
                () -> assertEquals(true, vector.precedes(other)),
                () -> assertEquals(true, vector.precedes(other2)),
                () -> assertEquals(false, vector.precedes(other3))
        );
    }

    @Test
    void followsTest() {
        Vector2d vector = new Vector2d(3,4);
        Vector2d other = new Vector2d(1,2);
        Vector2d other2 = new Vector2d(3, 4);
        Vector2d other3 = new Vector2d(5, 5);
        assertAll(
                () -> assertEquals(true, vector.follows(other)),
                () -> assertEquals(true, vector.follows(other2)),
                () -> assertEquals(false, vector.follows(other3))
        );
    }

    @Test
    void upperRightTest() {
        Vector2d vector = new Vector2d(3,4);
        Vector2d other = new Vector2d(5,2);
        assertEquals(new Vector2d(5,4), vector.upperRight(other));
    }

    @Test
    void lowerLeftTest() {
        Vector2d vector = new Vector2d(3,4);
        Vector2d other = new Vector2d(5,2);
        assertEquals(new Vector2d(3,2), vector.lowerLeft(other));
    }

    @Test
    void addTest() {
        Vector2d vector = new Vector2d(-3,4);
        Vector2d other = new Vector2d(-5,2);
        assertEquals(new Vector2d(-8,6), vector.add(other));
    }

    @Test
    void subtractTest() {
        Vector2d vector = new Vector2d(-3,4);
        Vector2d other = new Vector2d(-5,2);
        assertEquals(new Vector2d(2,2), vector.subtract(other));
    }

    @Test
    void opposite() {
        Vector2d vector = new Vector2d(-3,4);
        assertEquals(new Vector2d(3,-4), vector.opposite());
    }



}
