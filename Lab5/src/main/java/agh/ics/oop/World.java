package agh.ics.oop;

public class World {

    public static void main(String[] args)  {
        String[] arg = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse2(arg);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
        for (Animal animal : map.getListOfAnimals()) {
            System.out.println(animal.toString2());
        }

    }

}
