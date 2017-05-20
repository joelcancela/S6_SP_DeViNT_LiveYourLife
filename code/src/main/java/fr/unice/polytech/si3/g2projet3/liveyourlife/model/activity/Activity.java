package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
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
public abstract class Activity<A extends Action> extends ModeleDevint {

    protected final String title;
    protected MultiChoiceList<A> correctAnswer;
    protected ObservableList<A> possibleChoices;
    protected ObservableList<A> answers;
    protected int status = 0;

    public Activity(String title, MultiChoiceList<A> possibleChoices) {
        super();
        this.title = title;
        this.correctAnswer = possibleChoices;
        List<A> shuffle = new ArrayList<>(possibleChoices.getIdealChoices());
        Collections.shuffle(shuffle);
        this.possibleChoices = FXCollections.observableArrayList(shuffle);
        answers = FXCollections.observableArrayList();
    }

    public boolean answer(A act) {
        if (correctAnswer.isCorrect(act)) {
            answerCorrect(act);
            return true;
        }
        return false;
    }

    public void answerCorrect(A act){
        System.out.println("correct");
        //MAJ des possibilitées
        possibleChoices.remove(act);
        //MAJ des answers
        answers.set(status++, act);
    }

    public ObservableList<A> getPossibleChoices() {
        return possibleChoices;
    }

    public ObservableList<A> getAnswers() {
        return answers;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }
}