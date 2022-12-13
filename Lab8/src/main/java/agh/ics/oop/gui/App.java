package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends Application implements IAppObserver {
        private WorldMap map;
        private final GridPane gridPane = new GridPane();
        private final static int moveDelay = 300;
        private SimulationEngine engine;
        private final static int SQUARESIZE = 40;

        @Override
        public void init(){
                this.map = new GrassField(10);
                Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
                this.engine = new SimulationEngine(this.map, positions);
                engine.setMoveDelay(moveDelay);
                engine.addObserver(this);
        }



        public void start(Stage primaryStage) throws FileNotFoundException {
                System.out.println("la");
                Button startButton = new Button("Start");
                TextField movesTxtField = new TextField();
                VBox topVBox = new VBox(movesTxtField, startButton);
                VBox mainVBox = new VBox(topVBox, this.gridPane);
                HBox bodyHBox = new HBox(mainVBox);

                startButton.setOnAction(click -> {
                        String[] args = movesTxtField.getText().split(" ");
                        MoveDirection[] directions = new OptionParser().parse(args);
                        engine.setMoveDirections(directions);
                        Thread thread = new Thread(engine);
                        thread.start();
                });

                this.drawGridPane();
                Scene scene = new Scene(bodyHBox, 600, 600);
                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private void drawGridPane() throws FileNotFoundException {
                this.gridPane.setGridLinesVisible(false);
                this.gridPane.getColumnConstraints().clear();
                this.gridPane.getRowConstraints().clear();

                Vector2d upperRight = this.map.calculateUpperBound();
                Vector2d lowerLeft = this.map.calculateLowerBound();

                this.gridPane.setGridLinesVisible(true);


                // rysowanie Y/X
                Label label = new Label("y/x");
                this.gridPane.add(label,0,0);
                GridPane.setHalignment(label, HPos.CENTER);

                // numer wiersza
                int w = 1;
                for (int i = upperRight.y ; i >= lowerLeft.y; i--) {

                        // rysowanie osi X
                        this.gridPane.getRowConstraints().add(new RowConstraints(SQUARESIZE));
                        Label labelX = new Label(Integer.toString(i));
                        labelX.setMinHeight(SQUARESIZE);
                        labelX.setMinWidth(SQUARESIZE);
                        this.gridPane.add(labelX,0,w);
                        GridPane.setHalignment(labelX, HPos.CENTER);

                        // numer kolumny
                        int k =1;
                        for (int j = lowerLeft.x; j <= upperRight.x ; j++) {
                                // rysowanie osi Y
                                if (i == upperRight.y) {
                                        this.gridPane.getColumnConstraints().add(new ColumnConstraints(SQUARESIZE));
                                        Label labelY = new Label(Integer.toString(j));
                                        labelY.setMinHeight(SQUARESIZE);
                                        labelY.setMinWidth(SQUARESIZE);
                                        this.gridPane.add(labelY,k,0);
                                        GridPane.setHalignment(labelY, HPos.CENTER);

                                }
                                // rysowanie obiektów na mapie
                                Vector2d currentPosition = new Vector2d(j,i);
                                if (this.map.isOccupied(currentPosition)) {
                                        Object object = this.map.objectAt(currentPosition);
                                        if (object != null) {
                                                GuiElementBox elementBox = new GuiElementBox((IElement) object);
                                                this.gridPane.add(elementBox.getVBoxElement(),k,w);
                                                GridPane.setHalignment(elementBox.getVBoxElement(), HPos.CENTER);
                                                GridPane.setHalignment(elementBox.getVBoxElement(), HPos.CENTER);
                                        }
                                }
                                k++;
                        }
                        w++;

                }
        }
        public void positionChangedApp() {
                Platform.runLater(() -> {
                        this.gridPane.getChildren().clear();
                        try {
                                this.drawGridPane();
                        } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                        }
                });
        }



}
