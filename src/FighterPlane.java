import java.awt.*;

public class FighterPlane extends WarPlane {

    // Форма бомб
    private IMissilesForm missilesForm;
    // Дополнительный цвет
    private Color DopColor;
    // Признак наличия переднего оперения
    private boolean FrontPlane;
    // Признак наличия боковых бомб
    private boolean SideBombs;
    // Признак наличия дополнительных бомб
    private boolean BigBombs;
    // Признак наличия маленьких бомб
    private boolean MiniBombs;

    public FighterPlane(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean frontPlane,
                        boolean sideBombs, boolean bigBombs, boolean miniBombs, int missiles, String missilesForm) {
        super(maxSpeed, weight, mainColor, 110, 103);
        this.DopColor = dopColor;
        this.FrontPlane = frontPlane;
        this.SideBombs = sideBombs;
        this.BigBombs = bigBombs;
        this.MiniBombs = miniBombs;
        switch (missilesForm) {
            case "Прямоугольные":
                this.missilesForm = new squareMissiles(missiles, dopColor);
                break;
            case "Овальные":
                this.missilesForm = new ovalMissiles(missiles, dopColor);
                break;
            case "Комбинированые":
                this.missilesForm = new combinedMissiles(missiles, dopColor);
                break;
        }
    }

    public Color getDopColor() {
        return DopColor;
    }

    private void setDopColor(Color dopColor) {
        this.DopColor = dopColor;
    }

    public boolean isFrontPlane() {
        return FrontPlane;
    }

    private void setFrontPlane(boolean frontPlane) {
        this.FrontPlane = frontPlane;
    }

    public boolean isSideBombs() {
        return SideBombs;
    }

    private void setSideBombs(boolean sideBombs) {
        this.SideBombs = sideBombs;
    }

    public boolean isBigBombs() {
        return BigBombs;
    }

    private void setBigBombs(boolean bigBombs) {
        this.BigBombs = bigBombs;
    }

    public boolean isMiniBombs() {
        return MiniBombs;
    }

    private void setMiniBombs(boolean miniBombs) {
        this.MiniBombs = miniBombs;
    }

    // Перегрузка метода отрисовки самолёта
    @Override
    public void DrawAir(Graphics g) {
        //переднее оперение
        if (FrontPlane)
        {
            g.setColor(DopColor);
            g.fillPolygon (
                    new int[] {_startPosX + 38, _startPosX + 38, _startPosX + 25, _startPosX + 25},
                    new int[] {_startPosY + 38, _startPosY + 65, _startPosY + 58, _startPosY + 45}, 4);
            g.setColor(Color.BLACK);
            g.drawPolygon ( //обведём
                    new int[] {_startPosX + 38, _startPosX + 38, _startPosX + 25, _startPosX + 25},
                    new int[] {_startPosY + 38, _startPosY + 65, _startPosY + 58, _startPosY + 45}, 4);
        }

        //боковые бомбы
        if (SideBombs)
        {
            g.setColor(DopColor);
            g.fillPolygon (
                    new int[] {_startPosX + 40, _startPosX + 37, _startPosX + 40, _startPosX + 56,
                            _startPosX + 60, _startPosX + 60, _startPosX + 56},
                    new int[] {_startPosY - 2, _startPosY, _startPosY + 2, _startPosY + 2,
                            _startPosY + 4, _startPosY - 4, _startPosY - 2}, 7);
            g.setColor(Color.BLACK);
            g.drawPolygon ( //обведём
                    new int[] {_startPosX + 40, _startPosX + 37, _startPosX + 40, _startPosX + 56,
                            _startPosX + 60, _startPosX + 60, _startPosX + 56},
                    new int[] {_startPosY - 2, _startPosY, _startPosY + 2, _startPosY + 2,
                            _startPosY + 4, _startPosY - 4, _startPosY - 2}, 7);
            g.setColor(DopColor);
            g.fillPolygon (
                    new int[] {_startPosX + 40, _startPosX + 37, _startPosX + 40, _startPosX + 56,
                            _startPosX + 60, _startPosX + 60, _startPosX + 56},
                    new int[] {_startPosY + 101, _startPosY + 103, _startPosY + 105, _startPosY + 105,
                            _startPosY + 107, _startPosY + 99, _startPosY + 101}, 7);
            g.setColor(Color.BLACK);
            g.drawPolygon ( //обведём
                    new int[] {_startPosX + 40, _startPosX + 37, _startPosX + 40, _startPosX + 56,
                            _startPosX + 60, _startPosX + 60, _startPosX + 56},
                    new int[] {_startPosY + 101, _startPosY + 103, _startPosY + 105, _startPosY + 105,
                            _startPosY + 107, _startPosY + 99, _startPosY + 101}, 7);
        }
        if (BigBombs)
        {
            g.setColor(DopColor);
            g.fillPolygon (
                    new int[] {_startPosX + 38, _startPosX + 33, _startPosX + 38, _startPosX + 50, _startPosX + 50},
                    new int[] {_startPosY + 21, _startPosY + 25, _startPosY + 29, _startPosY + 29, _startPosY + 21}, 5);
            g.setColor(Color.BLACK);
            g.drawPolygon ( //обведём
                    new int[] {_startPosX + 38, _startPosX + 33, _startPosX + 38, _startPosX + 50, _startPosX + 50},
                    new int[] {_startPosY + 21, _startPosY + 25, _startPosY + 29, _startPosY + 29, _startPosY + 21}, 5);
            g.setColor(DopColor);
            g.fillPolygon (
                    new int[] {_startPosX + 38, _startPosX + 33, _startPosX + 38, _startPosX + 50, _startPosX + 50},
                    new int[] {_startPosY + 76, _startPosY + 80, _startPosY + 84, _startPosY + 84, _startPosY + 76}, 5);
            g.setColor(Color.BLACK);
            g.drawPolygon ( //обведём
                    new int[] {_startPosX + 38, _startPosX + 33, _startPosX + 38, _startPosX + 50, _startPosX + 50},
                    new int[] {_startPosY + 76, _startPosY + 80, _startPosY + 84, _startPosY + 84, _startPosY + 76}, 5);
        }
        if (MiniBombs)
        {
            missilesForm.draw(g, _startPosX, _startPosY);
        }

        super.DrawAir(g);
    }
}
