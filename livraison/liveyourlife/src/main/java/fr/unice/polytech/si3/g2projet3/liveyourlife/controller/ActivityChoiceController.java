package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class ActivityChoiceController {
    private int SIZE_OF_ELEMENT = 200;
    private int MARGIN_OF_ELEMENT = 30;
    public ImageView image;
    public BorderPane borderPane;


    public void init(Action choice) {
        image.setImage(choice.getImage());
        image.setFitWidth(SIZE_OF_ELEMENT);
        image.setFitHeight(SIZE_OF_ELEMENT);
        BorderPane.setMargin(image,new Insets(MARGIN_OF_ELEMENT,MARGIN_OF_ELEMENT,MARGIN_OF_ELEMENT,MARGIN_OF_ELEMENT));
    }

    public int getSizeOfElement() {
        return SIZE_OF_ELEMENT;
    }

    public void setMarginOfElement(int value){
        MARGIN_OF_ELEMENT = value;
    }

    public int getMarginOfElement(){
        return MARGIN_OF_ELEMENT;
    }

    public void setSizeOfElement(int sizeOfElement) {
        this.SIZE_OF_ELEMENT = sizeOfElement;
    }
}
