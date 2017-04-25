package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    protected ObservableList<A> answers;
    protected int status = 0;

    public Activity(String title, List<A> possibleChoices) {
        super();
        this.title = title;
        this.correctAnswer = possibleChoices;
        List<A> shuffle = new ArrayList<A>(possibleChoices);
        Collections.shuffle(shuffle);
        this.possibleChoices = FXCollections.observableArrayList(shuffle);
        this.answers = FXCollections.observableArrayList();
    }

    public boolean answer(A act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        if(correctAnswer.get(status).equals(act)){
            System.out.println("correct");
            //MAJ des possibilitées
            possibleChoices.remove(act);
            //MAJ des answers
            answers.set(status++,act);
            return true;
        }else return false;

    }

    public ObservableList<A> getPossibleChoices(){
        return possibleChoices;
    }

    public ObservableList<A> getAnswers(){
        return answers;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }
}
