package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * @author Coconut team.
 */
public class ActivityChoiceController {
    private double SIZE_OF_ELEMENT = 325;
    private double MARGIN_OF_ELEMENT = 30;
    public ImageView image;


    public void init(Action choice) {
        image.setImage(choice.getImage());
        image.setFitWidth(SIZE_OF_ELEMENT);
        image.setFitHeight(SIZE_OF_ELEMENT);
        BorderPane.setMargin(image,new Insets(MARGIN_OF_ELEMENT));
    }

    public double getSizeOfElement() {
        return SIZE_OF_ELEMENT;
    }

    public void setMarginOfElement(double value){
        MARGIN_OF_ELEMENT = value;
    }

    public double getMarginOfElement(){
        return MARGIN_OF_ELEMENT;
    }

    public void setSizeOfElement(double sizeOfElement) {
        this.SIZE_OF_ELEMENT = sizeOfElement;
    }
}
