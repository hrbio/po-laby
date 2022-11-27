package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    public VBox getCell(IMapElement element) throws FileNotFoundException {
        try {
            Image image = new Image(new FileInputStream(element.getImagePath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label label = new Label(element.getPosition().toString());
            VBox vBox = new VBox();
            vBox.getChildren().addAll(imageView, label);
            vBox.setAlignment(Pos.CENTER);
            return vBox;
        } catch (FileNotFoundException e){
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
