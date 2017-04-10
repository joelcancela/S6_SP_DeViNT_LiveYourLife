package fr.unice.polytech.si3.g2projet3.liveyourlife.model;

import dvt.jeu.simple.ModeleDevint;

import java.util.LinkedList;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class Activity<A extends Action> extends ModeleDevint{

    protected final String title;
    protected List<A> possibleChoices;
    protected List<A> answer;

    public Activity(String title, List<A> possibleChoices) {
        super();
        this.title = title;
        this.possibleChoices = possibleChoices;
        answer = new LinkedList<>();
    }

    public void answer(A act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        possibleChoices.remove(act);
        answer.add(act);
    }

    public List<A> getPossibleChoices(){
        return possibleChoices;
    }
}
