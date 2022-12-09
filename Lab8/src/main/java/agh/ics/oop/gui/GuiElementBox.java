package agh.ics.oop.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class GuiElementBox {

    Image image = new Image (new FileInputStream("src/main/resources/up.png"));
    ImageView imageView = new ImageView(image);
}
