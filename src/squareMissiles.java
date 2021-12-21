import java.awt.*;

public class squareMissiles implements IMissilesForm {

    private EnumerationOfMissiles missiles;
    private Color dopColor;

    public squareMissiles(int number, Color dopColor) {
        setDigit(number);
        this.dopColor = dopColor;
    }

    public void setDigit(int number) {
        this.missiles = EnumerationOfMissiles.getChosenNumber(number);
    }

    public void draw(Graphics g, int _startPosX, int _startPosY) {

        if(missiles == EnumerationOfMissiles.Two || missiles == EnumerationOfMissiles.Four || missiles == EnumerationOfMissiles.Six){
            g.setColor(dopColor);
            g.fillRect(_startPosX + 41, _startPosY + 5, 15, 3);
            g.fillRect(_startPosX + 41, _startPosY + 95, 15, 3);

            g.setColor(Color.BLACK);
            g.drawRect(_startPosX + 41, _startPosY + 5, 15, 3);
            g.drawRect(_startPosX + 41, _startPosY + 95, 15, 3);

            if(missiles == EnumerationOfMissiles.Four || missiles == EnumerationOfMissiles.Six){
                g.setColor(dopColor);
                g.fillRect(_startPosX + 41, _startPosY + 9, 15, 3);
                g.fillRect(_startPosX + 41, _startPosY + 91, 15, 3);

                g.setColor(Color.BLACK);
                g.drawRect(_startPosX + 41, _startPosY + 9, 15, 3);
                g.drawRect(_startPosX + 41, _startPosY + 91, 15, 3);

                if(missiles == EnumerationOfMissiles.Six) {
                    g.setColor(dopColor);
                    g.fillRect(_startPosX + 41, _startPosY + 13, 15, 3);
                    g.fillRect(_startPosX + 41, _startPosY + 87, 15, 3);

                    g.setColor(Color.BLACK);
                    g.drawRect(_startPosX + 41, _startPosY + 13, 15, 3);
                    g.drawRect(_startPosX + 41, _startPosY + 87, 15, 3);
                }
            }
        }
    }
}