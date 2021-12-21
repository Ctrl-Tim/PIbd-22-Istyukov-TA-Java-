import java.awt.*;

public interface ITransport {
    void SetPosition(int x, int y, int width, int height);

    void MoveAir(Direction direction);

    void DrawAir(Graphics g);
}