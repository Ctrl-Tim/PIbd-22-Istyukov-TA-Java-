import javax.swing.*;
import java.awt.*;

public class AirConfigPanel extends JPanel {
    private ITransport air;

    public void paint(Graphics g) {
        super.paint(g);
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
