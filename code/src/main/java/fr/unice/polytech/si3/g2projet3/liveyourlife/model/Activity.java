package fr.unice.polytech.si3.g2projet3.liveyourlife.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class Activity<A extends Action> {

    protected final String title;
    protected List<A> choices;
    protected List<A> answer;

    public Activity(String title, List<A> choices) {
        this.title = title;
        this.choices = choices;
        answer = new LinkedList<>();
    }

    public void answer(A act) {
        if (!choices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        choices.remove(act);
        answer.add(act);
    }
}
