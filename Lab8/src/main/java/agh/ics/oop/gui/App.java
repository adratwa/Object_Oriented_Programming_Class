package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {
        private WorldMap map;
        private static final String EMPTY_CELL = " ";
        private final int HEIGHT = 18;

        @Override
        public void init(){
                //String[] arg = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
                //List<String> al = Arrays.asList(arg);
                ArrayList<MoveDirection> directions = new OptionParser().parse(getParameters().getRaw());
                this.map = new GrassField(10);
                Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
                IEngine engine = new SimulationEngine(directions, map, positions);
                engine.run();
                System.out.println(map.toString());

        }

        @Override
        public void start (Stage primaryStage) {
                Label label = new Label("y/x");

                GridPane grid = new GridPane();
                grid.setGridLinesVisible(true);
                grid.add(label,0,0);
                GridPane.setHalignment(label, HPos.CENTER);
                Vector2d upperRight = this.map.calculateUpperBound();
                Vector2d lowerLeft = this.map.calculateLowerBound();
                int w = 1;

                for (int i = upperRight.y ; i >= lowerLeft.y; i--) {

                        grid.getRowConstraints().add(new RowConstraints(HEIGHT));
                        Label labelX = new Label(Integer.toString(i));
                        labelX.setMinHeight(HEIGHT);
                        labelX.setMinWidth(HEIGHT);
                        grid.add(labelX,0,w);
                        GridPane.setHalignment(labelX, HPos.CENTER);

                        int k =1;

                        for (int j = lowerLeft.x; j <= upperRight.x ; j++) {
                                if (i == upperRight.y) {
                                        grid.getColumnConstraints().add(new ColumnConstraints(HEIGHT));
                                        Label labelY = new Label(Integer.toString(j));
                                        labelY.setMinHeight(HEIGHT);
                                        labelY.setMinWidth(HEIGHT);
                                        grid.add(labelY,k,0);
                                        GridPane.setHalignment(labelY, HPos.CENTER);

                                }

                                Label labelObject = new Label(drawObject(new Vector2d(j, i)));
                                grid.add(labelObject,k,w);
                                GridPane.setHalignment(labelObject, HPos.CENTER);
                                k++;
                        }
                        w++;

                }


                Scene scene = new Scene(grid);
                primaryStage.setScene(scene);

                primaryStage.show();


        }

        private String drawObject(Vector2d currentPosition) {
                String result = null;
                if (this.map.isOccupied(currentPosition)) {
                        Object object = this.map.objectAt(currentPosition);
                        if (object != null) {
                                result = object.toString();
                        } else {
                                result = EMPTY_CELL;
                        }
                } else {
                        result = EMPTY_CELL;
                }
                return result;
        }
}
