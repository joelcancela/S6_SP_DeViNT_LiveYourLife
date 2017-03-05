package dvt.tutorial.run;

import dvt.devint.menu.MenuDevint;
import dvt.tutorial.animeImage.JeuAnimationImage;
import dvt.tutorial.hello.HelloWorld;
import javafx.application.Application;

public class Menu extends MenuDevint{
    @Override
    public String titre() {
        return "TITRE DU TUTORIAL";
    }

    @Override
    public void initMenu() {
        control.addMenuItem("Image", (x) -> new JeuAnimationImage());
        control.addMenuItem("Hello", (x) -> new HelloWorld());
    }
}
