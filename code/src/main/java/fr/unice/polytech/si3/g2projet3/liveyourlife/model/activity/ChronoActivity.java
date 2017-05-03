package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import t2s.SIVOXDevint;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction> {

    private SIVOXDevint sivoxDevint;

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new ChronoAction());
        }
    }

    public ChronoActivity(String titre, MultiChoiceList allWays) {
        super(titre,null);//TODO pb multiChoices
    }

    public void setSIVOXInstance(SIVOXDevint sivoxDevint){
        this.sivoxDevint = sivoxDevint;
    }

    public void answerAction(ChronoAction action) {
        boolean wasCorrect = answer(action);
        if(wasCorrect){
            sivoxDevint.playText("Bonne réponse !");
//            sivoxDevint.playText(action.getDescription());
        }
        else{
            sivoxDevint.playText("Mauvaise réponse !");
        }
    }
}
