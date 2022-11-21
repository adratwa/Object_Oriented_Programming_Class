package agh.ics.oop;

public class World {

    public static void main(String[] args)  {
        String[] arg = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse2(arg);
        WorldMap grassField = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, grassField, positions);
        engine.run();
        System.out.println(grassField.toString());

//        WorldMap grassField = new GrassField(10);
//        Animal animal = new Animal(grassField,new Vector2d(2,2) );
//        Animal animal2 = new Animal(grassField, new Vector2d(4,5));
//        Animal animal3 = new Animal(grassField,new Vector2d(1,2) );
//        Animal animal4 = new Animal(grassField, new Vector2d(2,5));
//        Animal animal5 = new Animal(grassField,new Vector2d(3,2) );
//        Animal animal6 = new Animal(grassField, new Vector2d(8,5));
//        grassField.place(animal);
//        grassField.place(animal2);
//        grassField.place(animal3);
//        grassField.place(animal4);
//        grassField.place(animal5);
//        grassField.place(animal6);
//        animal.move(MoveDirection.RIGHT);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        animal2.move(MoveDirection.FORWARD);
//        animal2.move(MoveDirection.FORWARD);
//        animal2.move(MoveDirection.FORWARD);
//        animal2.move(MoveDirection.FORWARD);
//        System.out.println(grassField.toString());




    }

}
