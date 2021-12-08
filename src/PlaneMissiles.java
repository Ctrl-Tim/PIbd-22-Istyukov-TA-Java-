import java.awt.*;

public class PlaneMissiles {
    private EnumerationOfMissiles missiles;

    public PlaneMissiles(int number) {
        setDigit(number);
    }

    public void setDigit(int number) {
        this.missiles = EnumerationOfMissiles.getChosenNumber(number);
    }

    private void Bombs(Graphics g, Color DopColor, int _startPosX, int _startPosY) {
        g.setColor(DopColor);
        g.fillPolygon (
                new int[] {_startPosX + 42, _startPosX + 38, _startPosX + 42, _startPosX + 53,
                        _startPosX + 58, _startPosX + 58, _startPosX + 53},
                new int[] {_startPosY + 9, _startPosY + 10, _startPosY + 11, _startPosY + 11,
                        _startPosY + 12, _startPosY + 8, _startPosY + 9}, 7);
        g.setColor(Color.BLACK);
        g.drawPolygon ( //обведём
                new int[] {_startPosX + 42, _startPosX + 38, _startPosX + 42, _startPosX + 53,
                        _startPosX + 58, _startPosX + 58, _startPosX + 53},
                new int[] {_startPosY + 9, _startPosY + 10, _startPosY + 11, _startPosY + 11,
                        _startPosY + 12, _startPosY + 8, _startPosY + 9}, 7);
    }

    public void draw(Graphics g, Color DopColor, int _startPosX, int _startPosY) {
        if(missiles == EnumerationOfMissiles.Two || missiles == EnumerationOfMissiles.Four || missiles == EnumerationOfMissiles.Six){
            Bombs(g, DopColor, _startPosX, _startPosY - 3);
            Bombs(g, DopColor, _startPosX, _startPosY + 86);
            if(missiles == EnumerationOfMissiles.Four || missiles == EnumerationOfMissiles.Six)
            {
                Bombs(g, DopColor, _startPosX, _startPosY);
                Bombs(g, DopColor, _startPosX, _startPosY + 83);
                if(missiles == EnumerationOfMissiles.Six)
                {
                    Bombs(g, DopColor, _startPosX, _startPosY + 3);
                    Bombs(g, DopColor, _startPosX, _startPosY + 80);
                }
            }
        }
    }

}