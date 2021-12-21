import java.awt.*;

public class WarPlane extends Plane {

    // Ширина отрисовки истребителя
    private int planeWidth = 110;
    // Высота отрисовки истребителя
    private int planeHeight = 103;

    public WarPlane(int maxSpeed, float weight, Color mainColor) {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    protected WarPlane(int maxSpeed, float weight, Color mainColor, int planeWidth, int planeHeight) {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.planeWidth = planeWidth;
        this.planeHeight = planeHeight;
    }

    // Перегрузка метода изменения направления перемещения
    @Override
    public void MoveAir(Direction direction) {
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

    // Перегрузка метода отрисовки самолёта
    @Override
    public void DrawAir(Graphics g) {
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

    @Override
    public void setNewMainColor(Color MainColor){
        this.MainColor = MainColor;
    }
}