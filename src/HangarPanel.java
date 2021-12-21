import javax.swing.*;
import java.awt.*;

public class HangarPanel extends JPanel {
    private final Hangar<Plane, IMissilesForm> hangar;

    public void paint(Graphics g) {
        if (hangar != null) {
            hangar.Draw(g);
        }
    }

    public HangarPanel(Hangar<Plane, IMissilesForm> hangar) {
        this.hangar = hangar;
    }
}