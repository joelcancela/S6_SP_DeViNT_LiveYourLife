package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivityController extends ActivityController {

    @FXML
    public Text activityName;
    @FXML
    public ListView availableActions;
    @FXML
    public ListView pickedActions;


    @Override
    protected void init() {
    }

    @Override
    protected void reset() {

    }

    @Override
    public void mapTouchToActions() {

    }
}
