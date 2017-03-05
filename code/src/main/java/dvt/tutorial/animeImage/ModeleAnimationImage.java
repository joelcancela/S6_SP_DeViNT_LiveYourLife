package dvt.tutorial.animeImage;

import dvt.jeu.animation.ModeleAnimationDevint;

import java.util.Random;

public class ModeleAnimationImage extends ModeleAnimationDevint{
    private boolean fille;
    int count;
    public ModeleAnimationImage() {
        Random r = new Random(System.currentTimeMillis());
        fille = r.nextBoolean();
    }
    public String pathImage() {
        if (fille) {
            return "images/lea.jpg";
        }
        return "images/theo.jpg";
    }
    @Override
    public void update() {
        count++;
    }
}
