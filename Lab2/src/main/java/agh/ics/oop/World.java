package agh.ics.oop;

public class World {

    public static void main(String[] args) {
//        System.out.println("System wystartował");
//        Direction[] directions =new Direction[args.length];
//        directions = modifyStringToEnum(args);
//        run(directions);
//        System.out.println("System zakończył działanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection direction = MapDirection.SOUTH;
        System.out.println("Kierunek: " + direction);
        System.out.println("Nastepny kierunek: " + direction.next() );
        System.out.println("Poprzedni kierunek: " + direction.previous() );
        System.out.println("Wektor kierunku: " + direction.toUnitVector());

    }

    public static void run (MoveDirection[] moveDirections) {

        // pierwsza opcja: WYPISYWANIE TABLICY STRINGOW Z PRZECINKIEM
//        for (int i = 0; i< directions.length; i++) {
//            if (i == directions.length-1 ) {
//                System.out.print(directions[i]);
//                System.out.println();
//            }
//            else {
//                System.out.print(directions[i] + ",");
//            }
//
//        }

        // druga opcja: WYPISYWANIE TABLICY STRINGOW Z PRZECINKIEM
//        String joinedDirections = String.join(", ", directions);
//        System.out.println(joinedDirections);

        // pierwsza wersja: WYPISYWANIE NA KONSOLE RUCHU ZWIERZAKA Z TABLICY STRINGOW
//        System.out.println("Start");
//        for (String direction : directions) {
//            switch (direction) {
//                case "f" -> System.out.println("Zwierzak idzie do przodu");
//                case "b"-> System.out.println("Zwierzak idzie do tyłu");
//                case "r" -> System.out.println("Zwierzak skreca w prawo");
//                case "l" -> System.out.println("Zwierzak skreca w lewo");
//
//            }
//        }
//        System.out.println("Stop");

        // druga wersja: WYPISYWANIE NA KONSOLE RUCHU ZWIERZAKA Z TABLICY ENUMOW
        System.out.println("Start");
        for (MoveDirection moveDirection : moveDirections) {
            switch (moveDirection) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD-> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }
        System.out.println("Stop");
    }


    public static MoveDirection[] modifyStringToEnum(String [] args) {
        MoveDirection[] moveDirections = new MoveDirection[args.length];
        for (int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case "f" -> moveDirections[i] = MoveDirection.FORWARD;
                case "b"-> moveDirections[i] = MoveDirection.BACKWARD;
                case "r" -> moveDirections[i] = MoveDirection.RIGHT;
                case "l" -> moveDirections[i] = MoveDirection.LEFT;
                default -> moveDirections[i] = MoveDirection.WRONGDIRECTION;
            }
        }
        return moveDirections;
    }
}
