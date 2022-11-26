package agh.ics.oop;

import java.util.ArrayList;
import java.util.stream.Stream;

public class OptionParser {

    public ArrayList<MoveDirection> parse (String[] directionsArray) {
        ArrayList<MoveDirection> convertedDirections = new ArrayList<MoveDirection>();
        for (String direction : directionsArray)
        {
            switch (direction) {
                case "f", "forward" -> convertedDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> convertedDirections.add(MoveDirection.BACKWARD);
                case "r", "right" -> convertedDirections.add(MoveDirection.RIGHT);
                case "l", "left" -> convertedDirections.add(MoveDirection.LEFT);
                }
        }
        return convertedDirections;
        }
        // NAUCZYC SIE STREAMOW
        public static MoveDirection[] parse2(String[] input) {
            return Stream.of(input)
                    .map(instruction -> switch(instruction) {
                                case "f", "forward" -> MoveDirection.FORWARD;
                                case "b", "backward" -> MoveDirection.BACKWARD;
                                case "r", "right" -> MoveDirection.RIGHT;
                                case "l", "left" -> MoveDirection.LEFT;
                                default -> null;
                            }).filter(moveDirection -> moveDirection != null)
                                .toArray(MoveDirection[]::new);// dla argumentu instruciton zrob cos

        }

}

