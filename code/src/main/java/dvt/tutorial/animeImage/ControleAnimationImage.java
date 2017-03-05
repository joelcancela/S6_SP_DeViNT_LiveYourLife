package dvt.tutorial.animeImage;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.animation.ControleAnimationDevint;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class ControleAnimationImage extends ControleAnimationDevint {
    // les éléments graphiques
    private ImageView image;

    // informations sur le déplacement
    private boolean left;
    private boolean right;

    // taille du déplacement
    private static int MOVE=10;

    public ControleAnimationImage(SceneDevint scene){
        this.scene = scene;
        image = new ImageView();
        Group r = (Group)scene.getRoot();
        r.getChildren().add(image);
    }

    @Override
    public void init() {
        String imagePath = ((ModeleAnimationImage)model).pathImage();
        image.setImage(new Image(ConstantesDevint.ressourcesFileName(imagePath)));
        image.setLayoutX(100);
        image.setLayoutY(100);
    }

    @Override
    protected void reset() {
        init();
        ((ModeleAnimationImage)model).count=0;
    }

    @Override
    protected void render() {
        double courant = image.getLayoutX();
        if (left) {
            image.setLayoutX(courant-MOVE);
        } if (right) {
            image.setLayoutX(courant+MOVE);
        } System.out.println(((ModeleAnimationImage)model).count);
    }

    private void left() {
        left=true;
    }

    private void unleft() {
        left=false;
    }

    private void right() {
        right=true;
    }

    private void unright() {
        right=false;
    }

    @Override
    protected void mapTouchToActions() {
        scene.mapKeyPressedToConsumer(KeyCode.LEFT, (x) -> left());
        scene.mapKeyPressedToConsumer(KeyCode.RIGHT, (x) -> right());
        scene.mapKeyReleasedToConsumer(KeyCode.LEFT, (x) -> unleft());
        scene.mapKeyReleasedToConsumer(KeyCode.RIGHT, (x) -> unright());
        scene.mapKeyPressedToConsumer(KeyCode.SPACE, (x) -> reset());
    }
}
