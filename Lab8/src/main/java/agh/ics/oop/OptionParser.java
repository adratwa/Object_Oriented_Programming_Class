package agh.ics.oop;

import java.util.stream.Stream;

public class OptionParser {

//    public ArrayList<MoveDirection> parse (List<String> directionsArray) {
//        ArrayList<MoveDirection> convertedDirections = new ArrayList<>();
//        for (String direction : directionsArray)
//        {
//
//                switch (direction) {
//                    case "f", "forward" -> convertedDirections.add(MoveDirection.FORWARD);
//                    case "b", "backward" -> convertedDirections.add(MoveDirection.BACKWARD);
//                    case "r", "right" -> convertedDirections.add(MoveDirection.RIGHT);
//                    case "l", "left" -> convertedDirections.add(MoveDirection.LEFT);
//                    default -> throw new IllegalArgumentException(direction + " is not legal move specification");
//                }
//        }
//
//        return convertedDirections;
//        }

        public static MoveDirection[] parse(String[] input) throws IllegalArgumentException {
            return Stream.of(input)
                    .map(instruction -> switch(instruction) {
                                case "f", "forward" -> MoveDirection.FORWARD;
                                case "b", "backward" -> MoveDirection.BACKWARD;
                                case "r", "right" -> MoveDirection.RIGHT;
                                case "l", "left" -> MoveDirection.LEFT;
                                default -> throw new IllegalArgumentException(instruction + " is not legal move specification");
                            }).toArray(MoveDirection[]::new);

        }



}

