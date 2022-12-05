package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SimulationEngine implements IEngine{

    private  IWorldMap map;
    private MoveDirection[] directions;
    private Vector2d[] vectors;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] vectors ) {
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
        LinkedHashMap<Vector2d, Animal> sortedMap = this.map.getMapOfAnimals().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, LinkedHashMap::new));

        while (i < directions.length) {
            for (Map.Entry<Vector2d, Animal> set : sortedMap.entrySet()) {
                set.getValue().move(directions[i]);
                i++;
                if (i == directions.length) { break;}
            }

        }



    }
}
