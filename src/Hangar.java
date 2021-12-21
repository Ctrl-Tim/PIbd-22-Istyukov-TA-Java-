import java.awt.*;

public class Hangar<T extends ITransport, K extends IMissilesForm> {
    private final Object[] _places;

    private final int pictureWidth;

    private final int pictureHeight;

    private final int _placeSizeWidth = 210;

    private final int _placeSizeHeight = 116;


    public Hangar(int picWidth, int picHeight) {
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _places = new Object[width * height];
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public boolean plus(T plane) {
        for (int i = 0; i < _places.length; i++) {
            if (_places[i] == null) {
                plane.SetPosition(3 + i % 3 * _placeSizeWidth, i / 3 * _placeSizeHeight + 6, pictureWidth, pictureHeight);
                _places[i] = plane;
                return true;
            }
        }
        return false;
    }

    public T minus(int index) {
        if (_places[index] != null && index >= 0 && index < _places.length) {
            Object temp = _places[index];
            _places[index] = null;
            return (T) (temp);
        } else {
            return null;
        }
    }

    public boolean bolshe(Hangar<Plane, IMissilesForm> h, Plane plane) {
        int count = 0;
        for (int i = 0; h._places[i] != null; i++) {
            if (h._places[i].getClass() == plane.getClass()){
                count++;
            }
        }

        return (count > _places.length);
    }

    public boolean menshe(Hangar<Plane, IMissilesForm> h, Plane plane) {
        int count = 0;
        for (int i = 0; h._places[i] != null; i++) {
            if (h._places[i].getClass() == plane.getClass()){
                count++;
            }
        }

        return (count < h._places.length);
    }

    public void Draw(Graphics g) {
        DrawMarking(g);
        for (int i = 0; i < _places.length; i++) {
            while (_places[i] == null) {
                i++;
                if (i == _places.length) {
                    return;
                }
            }
            ((T) _places[i]).DrawAir(g);
        }
    }

    private void DrawMarking(Graphics g) {
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++) {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j) {
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }
}