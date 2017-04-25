package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import t2s.SIVOXDevint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class Activity<A extends Action> extends ModeleDevint{

    protected final String title;
    protected List<A> correctAnswer;
    protected ObservableList<A> possibleChoices;
    protected int status = 0;
    protected SIVOXDevint sivoxDevint;
    protected int currentChoice = 0;

    public Activity(String title, List<A> possibleChoices) {
        super();
        this.title = title;
        this.correctAnswer = possibleChoices;
        List<A> shuffle = new ArrayList<>(possibleChoices);
        Collections.shuffle(shuffle);
        this.possibleChoices = FXCollections.observableArrayList(shuffle);

    }

    public abstract boolean answer(A act);

    public ObservableList<A> getPossibleChoices(){
        return possibleChoices;
    }

    public String getTitle() {
        return title;
    }

    public int answerSelectedAction() {
        if(possibleChoices.size()>0){
            boolean wasCorrect = answer(possibleChoices.get(currentChoice));
            if(wasCorrect){
                currentChoice = Math.max(currentChoice-1,0);
                sivoxDevint.playText("Bonne réponse !");
            }
            else{
                sivoxDevint.playText("Mauvaise réponse !");
            }
        }
        return currentChoice;
    }

    public int chooseRight() {
        if (currentChoice < possibleChoices.size() - 1)
            currentChoice++;
        return currentChoice;
    }

    public int chooseLeft() {
        if (currentChoice > 0)
            currentChoice--;
        return currentChoice;
    }

    public void setSIVOXInstance(SIVOXDevint sivoxDevint){
        this.sivoxDevint = sivoxDevint;
    }
}
