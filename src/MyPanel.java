import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private FighterPlane fighterPlane;

    public void paintComponent(Graphics g) {
        if (fighterPlane != null){
            fighterPlane.draw(g);
        }
    }

    public FighterPlane getFighterPlane() {
        return fighterPlane;
    }

    public void setFighterPlane(FighterPlane fighterPlane) {
        this.fighterPlane = fighterPlane;
    }
}