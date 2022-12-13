package agh.ics.oop.gui;

import agh.ics.oop.Grass;
import agh.ics.oop.IElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    public static final int ELEMENTSIZE = 20;
    private VBox vBoxElement;

    public VBox getVBoxElement() {
        return vBoxElement;
    }


    public GuiElementBox(IElement element) throws FileNotFoundException {
        Image image = new Image (new FileInputStream(element.getNameOfPathElement()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(ELEMENTSIZE);
        imageView.setFitHeight(ELEMENTSIZE);
        Label label = new Label(element.getLocation().toString());
        if (element instanceof Grass) {
            label.setText("Trawa");
        }
        vBoxElement = new VBox();
        vBoxElement.getChildren().add(imageView);
        vBoxElement.getChildren().add(label);
        vBoxElement.setAlignment(Pos.CENTER);
    }

}
