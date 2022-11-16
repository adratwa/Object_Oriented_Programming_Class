package agh.ics.oop;

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
    }

    @Override
    public void run() {
        int i = 0;
        int j = 0;
        while (i < directions.length) {
            for (Animal animal : this.map.getListOfAnimals()) {
                animal.move(directions[i]);
                j++;
                i++;
                if (i == directions.length) { break;}
            }
            j = 0;
        }


    }
}
