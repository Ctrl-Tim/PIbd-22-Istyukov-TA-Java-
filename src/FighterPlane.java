import java.awt.*;

public class FighterPlane {

    // Левая координата отрисовки истребителя
    private int _startPosX;
    // Правая кооридната отрисовки истребителя
    private int _startPosY;

    // Ширина окна отрисовки
    private int _frameWidth;
    // Высота окна отрисовки
    private int _frameHeight;

    // Ширина отрисовки истребителя
    private final int planeWidth = 110;
    // Высота отрисовки истребителя
    private final int planeHeight = 103;

    // Максимальная скорость
    private int MaxSpeed;
    // Вес истребителя
    private float Weight;
    // Основной цвет кузова
    private Color MainColor;
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
    // Количество бомб
    private PlaneMissiles missiles;

    public FighterPlane(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean frontPlane,
                        boolean sideBombs, boolean bigBombs, boolean miniBombs, int digit) {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
        this.DopColor = dopColor;
        this.FrontPlane = frontPlane;
        this.SideBombs = sideBombs;
        this.BigBombs = bigBombs;
        this.MiniBombs = miniBombs;
        this.missiles = new PlaneMissiles(digit);
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    private void MaxSpeed(int maxSpeed) {
        this.MaxSpeed = maxSpeed;
    }

    public float getWeight() {
        return Weight;
    }

    private void setWeight(float weight) {
        this.Weight = weight;
    }

    public Color getMainColor() {
        return MainColor;
    }

    private void setMainColor(Color mainColor) {
        this.MainColor = mainColor;
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

    public void setPosition(int posX, int posY, int frameWidth, int frameHeight) {
        this._frameHeight = frameHeight;
        this._frameWidth = frameWidth;
        if (posX >= 0 && posX + planeWidth < frameWidth &&
                posY >= 0 && posY + planeHeight < frameHeight) {
            this._startPosX = posX;
            this._startPosY = posY;
        }
    }

    // Изменение направления перемещения
    public void movePlane(Direction direction) {
        int boarderNumber = 10;
        int step = (int) (MaxSpeed * 1000 / Weight);
        switch (direction) {
            case Up:
                if (_startPosY - step > boarderNumber) {
                    _startPosY -= step;
                }
                break;
            case Right:
                if (_startPosX + step < _frameWidth - planeWidth - boarderNumber) {
                    _startPosX += step;
                }
                break;
            case Down:
                if (_startPosY + step < _frameHeight - planeHeight - boarderNumber) {
                    _startPosY += step;
                }
                break;
            case Left:
                if (_startPosX - step > boarderNumber) {
                    _startPosX -= step;
                }
                break;
        }
    }

    // Отрисовка самолёта
    public void draw(Graphics g) {
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
            missiles.draw(g, DopColor, _startPosX, _startPosY);
        }

        g.setColor(MainColor);

        //турбина
        g.setColor(Color.CYAN);
        g.fillPolygon (
                new int[] {_startPosX + 51, _startPosX + 105, _startPosX + 110, _startPosX + 110,
                        _startPosX + 107, _startPosX + 110, _startPosX + 110, _startPosX + 105, _startPosX + 51},
                new int[] {_startPosY + 42, _startPosY + 42, _startPosY + 44, _startPosY + 49,
                        _startPosY + 51, _startPosY + 53, _startPosY + 58, _startPosY + 61,_startPosY + 61}, 9);
        g.setColor(Color.BLACK);
        g.drawPolygon ( //обведём
                new int[] {_startPosX + 51, _startPosX + 105, _startPosX + 110, _startPosX + 110,
                        _startPosX + 107, _startPosX + 110, _startPosX + 110, _startPosX + 105, _startPosX + 51},
                new int[] {_startPosY + 42, _startPosY + 42, _startPosY + 44, _startPosY + 49,
                        _startPosY + 51, _startPosY + 53, _startPosY + 58, _startPosY + 61,_startPosY + 61}, 9);

        //крылья
        g.setColor(MainColor);
        g.fillPolygon (
                new int[] {_startPosX + 45, _startPosX + 45, _startPosX + 51, _startPosX + 58,
                        _startPosX + 58, _startPosX + 51, _startPosX + 45},
                new int[] {_startPosY + 45, _startPosY, _startPosY, _startPosY + 45,
                        _startPosY + 58, _startPosY + 103,_startPosY + 103}, 7);
        g.setColor(Color.BLACK);
        g.drawPolygon ( //обведём
                new int[] {_startPosX + 45, _startPosX + 45, _startPosX + 51, _startPosX + 58,
                        _startPosX + 58, _startPosX + 51, _startPosX + 45},
                new int[] {_startPosY + 45, _startPosY, _startPosY, _startPosY + 45,
                        _startPosY + 58, _startPosY + 103,_startPosY + 103}, 7);

        //хвостовое оперение
        g.setColor(MainColor);
        g.fillPolygon (
                new int[] {_startPosX + 105, _startPosX + 105, _startPosX + 92, _startPosX + 92},
                new int[] {_startPosY + 28, _startPosY + 75, _startPosY + 65, _startPosY + 38}, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon ( //обведём
                new int[] {_startPosX + 105, _startPosX + 105, _startPosX + 92, _startPosX + 92},
                new int[] {_startPosY + 28, _startPosY + 75, _startPosY + 65, _startPosY + 38}, 4);

        //кузов
        g.setColor(MainColor);
        g.fillRect(_startPosX + 15, _startPosY + 45, 90, 13);
        g.setColor(Color.BLACK); //обведём
        g.drawRect(_startPosX + 15, _startPosY + 45, 90, 13); //обведём

        //нос
        g.setColor(Color.BLACK);
        g.fillPolygon (
                new int[] {_startPosX + 15, _startPosX, _startPosX + 15},
                new int[] {_startPosY + 45, _startPosY + 51, _startPosY + 58}, 3);
        g.drawPolygon ( //обведём
                new int[] {_startPosX + 15, _startPosX, _startPosX + 15},
                new int[] {_startPosY + 45, _startPosY + 51, _startPosY + 58}, 3);
    }
}