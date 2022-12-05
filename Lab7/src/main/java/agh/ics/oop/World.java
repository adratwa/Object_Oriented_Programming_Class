package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] args)  {

//        String[] arg = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
//        MoveDirection[] directions = new OptionParser().parse2(arg);
//        WorldMap map = new RectangularMap(10,5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        System.out.println(map.toString());
//
//        WorldMap map2 = new GrassField(10);
//        IEngine engine2 = new SimulationEngine(directions, map2, positions);
//        engine2.run();
//        System.out.println(map2.toString());
        Application.launch(App.class, args);



    }

}
