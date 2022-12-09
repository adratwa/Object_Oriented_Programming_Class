package agh.ics.oop;

import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine, Runnable{

    private  IWorldMap map;
    private List<MoveDirection> directions;
    private Vector2d[] vectors;

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] vectors ) {
        this.directions = directions;
        this.map = map;
        this.vectors = vectors;
        for (Vector2d vector : vectors ) {
            this.map.place(new Animal(this.map, vector));

        }
        //System.out.printlsn( map.getMapOfAnimals());

    }

    @Override
    public void run() {
        int i = 0;

        while (i < directions.size()) {
            for (Map.Entry<Vector2d, Animal> set : this.map.getMapOfAnimals().entrySet()) {
                set.getValue().move(directions.get(i));
                i++;
                System.out.println(i);
                System.out.println(directions.size());
                if (i == directions.size()) { break;}
            }

        }



    }
}
