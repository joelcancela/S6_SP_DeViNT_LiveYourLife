package dvt.tutorial.animeImage;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.animation.ControleAnimationDevint;
import dvt.jeu.animation.JeuAnimationDevint;
import dvt.jeu.animation.ModeleAnimationDevint;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

public class JeuAnimationImage extends JeuAnimationDevint {
    @Override
    public String titre() {
        return "Jeu tutoriel";
    }

    @Override
    protected ModeleAnimationDevint initModel() {
        return new ModeleAnimationImage();
    }

    @Override
    protected ControleAnimationDevint initControlAndScene() {
        Canvas c = new Canvas(ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
        Group root = new Group(c);
        SceneDevint sc = new SceneDevint(root);
        control = new ControleAnimationImage(sc);
        return control;
    }
}
