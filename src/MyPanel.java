import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private ITransport air;

    public void paint(Graphics g) {
        if (air != null) {
            air.DrawAir(g);
        }
    }

    public ITransport getPlane() {
        return air;
    }

    public void setPlane(ITransport air) {
        this.air = air;
    }
}