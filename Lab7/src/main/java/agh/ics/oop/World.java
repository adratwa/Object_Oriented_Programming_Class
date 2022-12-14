package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {

    public static void main(String[] args)  {

        Application.launch(App.class, args);
        // Obsługa wyjątków
        try {
            GrassField map = new GrassField(10);
            Animal a1 = new Animal(map, new Vector2d(2,8));
            map.place(a1);
            map.place(a1);
            System.out.println("Nie wypisze się na ekranie");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String[] arg = new String[] {"f", "g", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            List<String> al = Arrays.asList(arg);
            ArrayList<MoveDirection> directions = new OptionParser().parse(al);
            WorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println("Nie wypisze się na ekranie");
        } catch (Exception e) {
            System.out.println(e);
        }


//
//        WorldMap map2 = new GrassField(10);
//        IEngine engine2 = new SimulationEngine(directions, map2, positions);
//        engine2.run();
//        System.out.println(map2.toString());


//        a3.move(MoveDirection.RIGHT);
//        a3.move(MoveDirection.FORWARD);
//        a2.move(MoveDirection.FORWARD);
//        a1.move(MoveDirection.BACKWARD);
//
//
//        System.out.println(map.toString());
            //System.out.println(map.getMapBoundary().getSortedElementsX().get(i).toString2());
//        Collections.sort(map.getMapBoundary().getSortedElementsX(), new YPositionComparator());
//        System.out.println("sorted");
//        for (int i = 0; i < map.getMapBoundary().getSortedElementsX().size(); i++)
//            System.out.println(map.getMapBoundary().getSortedElementsX().get(i).toString2());

    }

}
