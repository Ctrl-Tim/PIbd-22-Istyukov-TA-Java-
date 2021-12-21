import java.awt.*;

public class ovalMissiles implements IMissilesForm {

    private EnumerationOfMissiles missiles;
    private Color dopColor;

    public ovalMissiles(int number, Color dopColor) {
        setDigit(number);
        this.dopColor = dopColor;
    }

    public void setDigit(int number) {
        this.missiles = EnumerationOfMissiles.getChosenNumber(number);
    }

    public void draw(Graphics g, int _startPosX, int _startPosY) {
        g.setColor(Color.BLACK);
        if (missiles == EnumerationOfMissiles.Two || missiles == EnumerationOfMissiles.Four || missiles == EnumerationOfMissiles.Six) {
            g.setColor(dopColor);
            g.fillOval(_startPosX + 42, _startPosY + 4, 15, 5);
            g.fillOval(_startPosX + 42, _startPosY + 94, 15, 5);

            g.setColor(Color.BLACK);
            g.drawOval(_startPosX + 42, _startPosY + 4, 15, 5);
            g.drawOval(_startPosX + 42, _startPosY + 94, 15, 5);

            if (missiles == EnumerationOfMissiles.Four || missiles == EnumerationOfMissiles.Six) {
                g.setColor(dopColor);
                g.fillOval(_startPosX + 42, _startPosY + 9, 15, 5);
                g.fillOval(_startPosX + 42, _startPosY + 89, 15, 5);

                g.setColor(Color.BLACK);
                g.drawOval(_startPosX + 42, _startPosY + 9, 15, 5);
                g.drawOval(_startPosX + 42, _startPosY + 89, 15, 5);

                if (missiles == EnumerationOfMissiles.Six) {
                    g.setColor(dopColor);
                    g.fillOval(_startPosX + 42, _startPosY + 13, 15, 4);
                    g.fillOval(_startPosX + 42, _startPosY + 85, 15, 4);

                    g.setColor(Color.BLACK);
                    g.drawOval(_startPosX + 42, _startPosY + 13, 15, 4);
                    g.drawOval(_startPosX + 42, _startPosY + 85, 15, 4);
                }
            }
        }
    }
}