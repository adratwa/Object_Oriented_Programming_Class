package agh.ics.oop;

import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine{

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
//        LinkedHashMap<Vector2d, Animal> sortedMap = this.map.getMapOfAnimals().entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, LinkedHashMap::new));

        while (i < directions.size()) {
            for (Map.Entry<Vector2d, Animal> set : this.map.getMapOfAnimals().entrySet()) {
                set.getValue().move(directions.get(i));
                i++;
                if (i == directions.size()) { break;}
            }

        }



    }
}
