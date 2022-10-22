package agh.ics.oop;

import java.util.ArrayList;

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

}

