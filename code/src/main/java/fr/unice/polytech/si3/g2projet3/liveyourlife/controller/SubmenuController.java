package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.devint.menu.CstMenu;
import dvt.jeu.simple.ControleDevint;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @author Coconut team.
 */
public class SubmenuController extends ControleDevint {

    private Label menuTitle;
    private HashMap<Integer,Button> menuItems;
    private GridPane menuLayout;
    private int colIndex;
    private int lineIndex;
    private int selected;
    private HashMap<Integer,Consumer<Void>> actionMap;

    public SubmenuController(){
        super();
        selected=0;
        menuItems = new HashMap<>();
        menuTitle = new Label("jeu");
        menuTitle.setPrefWidth(ConstantesDevint.MAX_SCREEN_WIDTH);
        menuLayout = new GridPane();
        menuLayout.setGridLinesVisible(true);
        menuLayout.getStyleClass().add("grid-pane");
        colIndex=0;
        lineIndex=0;
        BorderPane layout = new BorderPane();
        layout.setTop(menuTitle);
        layout.setCenter(menuLayout);
        scene= new SceneDevint(layout,ConstantesDevint.MAX_SCREEN_WIDTH,ConstantesDevint.MAX_SCREEN_HEIGHT);
        actionMap = new HashMap<>();
    }


    public void setTitre(String t) {
        menuTitle.setText(t);
        menuTitle.setStyle("");
    }

    @Override
    protected void init() {
    }

    @Override
    protected void reset() {
    }

    public void mapTouchToActions() {
        scene.mapKeyPressedToConsumer(KeyCode.DOWN, (x) -> down());
        scene.mapKeyPressedToConsumer(KeyCode.UP, (x) -> up());
        scene.mapKeyPressedToConsumer(KeyCode.SPACE, (x) -> action());
        scene.mapKeyPressedToConsumer(KeyCode.ENTER, (x) -> action());
    }

    public void addMenuItem(String label, Consumer<Void> action) {
        Button button = new Button(label.toUpperCase());
        button.setPrefWidth(CstMenu.PREF_BUTTON_WIDTH);
        button.setPrefHeight(CstMenu.PREF_BUTTON_HEIGHT);
        unSelectButton(button);
        menuLayout.add(button, colIndex, lineIndex);
        actionMap.put(lineIndex, action);
        button.setOnMouseClicked(x -> action.accept(null));
        menuItems.put(lineIndex, button);
        lineIndex++;
    }

    private void down() {
        selected = selected ==  (menuItems.size() - 1) ? 0
                : selected + 1;
        render();
    }

    private void up() {
        selected = selected == 0 ? (menuItems.size() - 1)
                : selected - 1;
        render();
    }

    public void render() {
        for (int i = 0; i < menuItems.size(); i++) {
            if (i == selected ) {
                selectButton(menuItems.get(i));
            } else {
                unSelectButton(menuItems.get(i));
            }
        }
        scene.getSIVox().stop();
        scene.getSIVox().playText(menuItems.get(selected).getText(), ConstantesDevint.SYNTHESE_MAXIMALE);
        scene.getSIVox().playText("CETTE OPTION EST "+menuItems.get(selected % menuItems.size()).getText(),
                ConstantesDevint.SYNTHESE_MINIMALE);
    }

    private void action() {
        if (actionMap.containsKey(selected)) {
            actionMap.get(selected).accept(null);
        }
    }

    private void selectButton(Button b){
        b.getStyleClass().clear();
        b.getStyleClass().add("selectedbutton");
    }

    private void unSelectButton(Button b){
        b.getStyleClass().clear();
        b.getStyleClass().add("unselectedbutton");
    }
}
