package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine{

    private  final WorldMap map;
    private MoveDirection[] moveDirections;
    private int moveDelay;
    private final List<IAppObserver> observerList;

    public SimulationEngine(MoveDirection[] moveDirections , WorldMap map, Vector2d[] firstPositions ) {
        this.moveDirections = moveDirections;
        this.map = map;
        this.observerList = new ArrayList<>();
        for (Vector2d position : firstPositions ) {
            this.map.place(new Animal(this.map, position));

        }

    }

    public SimulationEngine(WorldMap map, Vector2d[] firstPositions ) {
        this.map = map;
        this.observerList = new ArrayList<>();
        for (Vector2d position : firstPositions ) {
            this.map.place(new Animal(this.map, position));

        }

    }

    public void setMoveDirections(MoveDirection[] moveDirections) {
        this.moveDirections = moveDirections;
    }

    public void setMoveDelay(int moveDelay) {
        this.moveDelay = moveDelay;
    }

    @Override
    public void run() {

        int i = 0;
        while (i < moveDirections.length) {
            for (Map.Entry<Vector2d, Animal> set : this.map.getMapOfAnimals().entrySet()) {
                set.getValue().move(moveDirections[i]);
                this.informObservers();
                i++;
                try {
                    Thread.sleep(this.moveDelay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (i == moveDirections.length) { break;}
            }

        }
    }

    public void addObserver(IAppObserver observer) {
        this.observerList.add(observer);
    }

    public void informObservers() {
        for (IAppObserver observer: this.observerList){
            observer.positionChangedApp();
        }
    }


}
