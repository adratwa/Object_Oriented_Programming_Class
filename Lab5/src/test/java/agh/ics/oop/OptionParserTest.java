package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionParserTest {

    @Test
    void optionParserTest() {
        OptionParser parser = new OptionParser();
        ArrayList<MoveDirection> convertedDirections = new ArrayList<MoveDirection>();
        convertedDirections.add(MoveDirection.FORWARD);
        convertedDirections.add(MoveDirection.BACKWARD);
        convertedDirections.add(MoveDirection.RIGHT);
        convertedDirections.add(MoveDirection.LEFT);
        convertedDirections.add(MoveDirection.FORWARD);
        convertedDirections.add(MoveDirection.BACKWARD);
        convertedDirections.add(MoveDirection.RIGHT);
        convertedDirections.add(MoveDirection.LEFT);
        assertEquals(convertedDirections, parser.parse(new String[] {"f","g", "b","r","l","wrong" ,"forward","backward","right","left"}));

    }
}
