import java.awt.*;

public abstract class Plane implements ITransport {

    // Левая координата отрисовки истребителя
    protected int _startPosX;
    // Правая кооридната отрисовки истребителя
    protected int _startPosY;

    // Ширина окна отрисовки
    protected int _frameWidth;
    // Высота окна отрисовки
    protected int _frameHeight;

    // Максимальная скорость
    public int MaxSpeed;

    protected void setMaxSpeed(int MaxSpeed) {
        this.MaxSpeed = MaxSpeed;
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    // Вес истребителя
    public float Weight;

    protected void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public float getWeight() {
        return Weight;
    }

    // Основной цвет кузова
    public Color MainColor;

    protected void setMainColor(Color MainColor) {
        this.MainColor = MainColor;
    }

    public Color getMainColor() {
        return MainColor;
    }

    public void SetPosition(int x, int y, int width, int height) {
        _startPosX = x;
        _startPosY = y;
        _frameWidth = width;
        _frameHeight = height;
    }

    public abstract void DrawAir(Graphics g);

    public abstract void MoveAir(Direction direction);

    public abstract void setNewMainColor(Color MainColor);
}