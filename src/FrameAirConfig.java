import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public class FrameAirConfig {
    Plane air;
    FrameHangar frameHangar;

    private final JFrame frame;

    private final AirConfigPanel airConfigPanel;

    private final JSpinner spinnerWeight;
    private final JSpinner spinnerMaxSpeed;
    private final JCheckBox checkBoxFrontPlane;
    private final JCheckBox checkBoxSideBombs;
    private final JCheckBox checkBoxBigBombs;
    private final JCheckBox checkBoxMiniBombs;

    private final JSpinner spinnerMissilesCount;

    private final JLabel labelPictureBox;

    public FrameAirConfig(FrameHangar frameHangar) {

        this.frameHangar = frameHangar;

        frame = new JFrame("Конфигурация самолета");
        frame.setSize(690, 470);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        JButton buttonAddPlane = new JButton("Добавить");
        buttonAddPlane.setBounds(230, 240, 200, 80);
        buttonAddPlane.addActionListener(e -> addPlane());
        frame.getContentPane().add(buttonAddPlane);

        JButton buttonCancel = new JButton("Отменить");
        buttonCancel.setBounds(230, 330, 200, 80);
        buttonAddPlane.addActionListener(e -> cancel());
        frame.getContentPane().add(buttonCancel);

        JPanel groupMissilesForm = new JPanel();
        groupMissilesForm.setBorder(BorderFactory.createTitledBorder("Форма бомб"));
        groupMissilesForm.setBounds(450, 180, 210, 230);
        groupMissilesForm.setLayout(null);
        frame.getContentPane().add(groupMissilesForm);

        JLabel labelSquareForm = new JLabel("Квадратная форма");
        labelSquareForm.setHorizontalAlignment(SwingConstants.CENTER);
        labelSquareForm.setBorder(BorderFactory.createLineBorder(Color.black));
        labelSquareForm.setBounds(10, 20, 190, 40);
        groupMissilesForm.add(labelSquareForm);

        JLabel labelOvalForm = new JLabel("Овальная форма");
        labelOvalForm.setHorizontalAlignment(SwingConstants.CENTER);
        labelOvalForm.setBorder(BorderFactory.createLineBorder(Color.black));
        labelOvalForm.setBounds(10, 70, 190, 40);
        groupMissilesForm.add(labelOvalForm);

        JLabel labelCombinedForm = new JLabel("Комбинорованная форма");
        labelCombinedForm.setHorizontalAlignment(SwingConstants.CENTER);
        labelCombinedForm.setBorder(BorderFactory.createLineBorder(Color.black));
        labelCombinedForm.setBounds(10, 120, 190, 40);
        groupMissilesForm.add(labelCombinedForm);

        JLabel labelMissilesCount = new JLabel("Количество бомб:");
        labelMissilesCount.setBounds(10, 170, 190, 20);
        groupMissilesForm.add(labelMissilesCount);
        spinnerMissilesCount = new JSpinner(new SpinnerNumberModel(2, 2, 6, 2));
        spinnerMissilesCount.setBounds(10, 190, 190, 20);
        groupMissilesForm.add(spinnerMissilesCount);

        var listenerForMissiles = new DragMouseAdapter();

        labelCombinedForm.addMouseListener(listenerForMissiles);
        labelOvalForm.addMouseListener(listenerForMissiles);
        labelSquareForm.addMouseListener(listenerForMissiles);

        labelCombinedForm.setTransferHandler(new TransferHandler("text"));
        labelOvalForm.setTransferHandler(new TransferHandler("text"));
        labelSquareForm.setTransferHandler(new TransferHandler("text"));

        JPanel groupColor = new JPanel();
        groupColor.setBorder(BorderFactory.createTitledBorder("Цвет самолета"));
        groupColor.setBounds(450, 10, 210, 160);
        groupColor.setLayout(null);
        frame.getContentPane().add(groupColor);

        JLabel labelMainColor = new JLabel("Основной цвет");
        PropertyChangeListener propertyChangeListenerMainColor = propertyChangeEvent -> {
            if (air != null) {
                air.setNewMainColor(labelMainColor.getBackground());
                frame.repaint();
            }
        };
        labelMainColor.setBorder(BorderFactory.createLineBorder(Color.black));
        labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainColor.addPropertyChangeListener("background", propertyChangeListenerMainColor);
        labelMainColor.setBounds(10, 20, 90, 30);
        groupColor.add(labelMainColor);

        JLabel labelDopColor = new JLabel("Доп. цвет");
        PropertyChangeListener propertyChangeListenerDopColor = propertyChangeEvent -> {
            if (air instanceof FighterPlane) {
                FighterPlane newAir = (FighterPlane) air;
                newAir.setNewDopColor(labelDopColor.getBackground());
                air = newAir;
                frame.repaint();
            }
        };
        labelDopColor.setBorder(BorderFactory.createLineBorder(Color.black));
        labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelDopColor.addPropertyChangeListener("background", propertyChangeListenerDopColor);
        labelDopColor.setBounds(110, 20, 90, 30);
        groupColor.add(labelDopColor);

        JLabel labelRed = new JLabel();
        labelRed.setBackground(Color.RED);
        labelRed.setOpaque(true);
        labelRed.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRed.setBounds(10, 60, 40, 40);
        groupColor.add(labelRed);

        JLabel labelBlue = new JLabel();
        labelBlue.setBackground(Color.BLUE);
        labelBlue.setOpaque(true);
        labelBlue.setBorder(BorderFactory.createLineBorder(Color.black));
        labelBlue.setBounds(60, 60, 40, 40);
        groupColor.add(labelBlue);

        JLabel labelYellow = new JLabel();
        labelYellow.setBackground(Color.YELLOW);
        labelYellow.setOpaque(true);
        labelYellow.setBorder(BorderFactory.createLineBorder(Color.black));
        labelYellow.setBounds(110, 60, 40, 40);
        groupColor.add(labelYellow);

        JLabel labelGreen = new JLabel();
        labelGreen.setBackground(Color.GREEN);
        labelGreen.setOpaque(true);
        labelGreen.setBorder(BorderFactory.createLineBorder(Color.black));
        labelGreen.setBounds(160, 60, 40, 40);
        groupColor.add(labelGreen);

        JLabel labelWhite = new JLabel();
        labelWhite.setBackground(Color.WHITE);
        labelWhite.setOpaque(true);
        labelWhite.setBorder(BorderFactory.createLineBorder(Color.black));
        labelWhite.setBounds(10, 110, 40, 40);
        groupColor.add(labelWhite);

        JLabel labelBlack = new JLabel();
        labelBlack.setBackground(Color.BLACK);
        labelBlack.setOpaque(true);
        labelBlack.setBorder(BorderFactory.createLineBorder(Color.black));
        labelBlack.setBounds(60, 110, 40, 40);
        groupColor.add(labelBlack);

        JLabel labelOrange = new JLabel();
        labelOrange.setBackground(Color.ORANGE);
        labelOrange.setOpaque(true);
        labelOrange.setBorder(BorderFactory.createLineBorder(Color.black));
        labelOrange.setBounds(110, 110, 40, 40);
        groupColor.add(labelOrange);

        JLabel labelGray = new JLabel();
        labelGray.setBackground(Color.GRAY);
        labelGray.setOpaque(true);
        labelGray.setBorder(BorderFactory.createLineBorder(Color.black));
        labelGray.setBounds(160, 110, 40, 40);
        groupColor.add(labelGray);

        var listenerForColor = new DragMouseAdapter();

        labelGray.addMouseListener(listenerForColor);
        labelBlack.addMouseListener(listenerForColor);
        labelOrange.addMouseListener(listenerForColor);
        labelBlue.addMouseListener(listenerForColor);
        labelGreen.addMouseListener(listenerForColor);
        labelRed.addMouseListener(listenerForColor);
        labelWhite.addMouseListener(listenerForColor);
        labelYellow.addMouseListener(listenerForColor);
        labelDopColor.addMouseListener(listenerForColor);
        labelMainColor.addMouseListener(listenerForColor);

        labelGray.setTransferHandler(new TransferHandler("background"));
        labelBlack.setTransferHandler(new TransferHandler("background"));
        labelOrange.setTransferHandler(new TransferHandler("background"));
        labelBlue.setTransferHandler(new TransferHandler("background"));
        labelGreen.setTransferHandler(new TransferHandler("background"));
        labelRed.setTransferHandler(new TransferHandler("background"));
        labelWhite.setTransferHandler(new TransferHandler("background"));
        labelYellow.setTransferHandler(new TransferHandler("background"));
        labelDopColor.setTransferHandler(new TransferHandler("background"));
        labelMainColor.setTransferHandler(new TransferHandler("background"));

        JPanel groupPlaneConfigPanel = new JPanel();
        groupPlaneConfigPanel.setBorder(BorderFactory.createTitledBorder("Параметры самолета"));
        groupPlaneConfigPanel.setBounds(10, 10, 200, 400);
        groupPlaneConfigPanel.setLayout(null);
        frame.getContentPane().add(groupPlaneConfigPanel);

        JLabel labelPlane = new JLabel("Военный самолёт");
        labelPlane.setBorder(BorderFactory.createLineBorder(Color.black));
        labelPlane.setHorizontalAlignment(SwingConstants.CENTER);
        labelPlane.setBounds(10, 30, 180, 60);
        groupPlaneConfigPanel.add(labelPlane);

        JLabel labelSeaPlane = new JLabel("Истребитель");
        labelSeaPlane.setBorder(BorderFactory.createLineBorder(Color.black));
        labelSeaPlane.setHorizontalAlignment(SwingConstants.CENTER);
        labelSeaPlane.setBounds(10, 110, 180, 60);
        groupPlaneConfigPanel.add(labelSeaPlane);

        JLabel labelWeight = new JLabel("Вес:");
        labelWeight.setBounds(10, 180, 180, 20);
        groupPlaneConfigPanel.add(labelWeight);
        spinnerWeight = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 10));
        spinnerWeight.setBounds(10, 200, 180, 20);
        groupPlaneConfigPanel.add(spinnerWeight);

        JLabel labelMaxSpeed = new JLabel("Максимальная скорость:");
        labelMaxSpeed.setBounds(10, 230, 180, 20);
        groupPlaneConfigPanel.add(labelMaxSpeed);
        spinnerMaxSpeed = new JSpinner(new SpinnerNumberModel(10, 10, 100, 10));
        spinnerMaxSpeed.setBounds(10, 250, 180, 20);
        groupPlaneConfigPanel.add(spinnerMaxSpeed);

        checkBoxFrontPlane = new JCheckBox("Переднее оперение");
        checkBoxFrontPlane.setBounds(10, 280, 180, 20);
        groupPlaneConfigPanel.add(checkBoxFrontPlane);

        checkBoxSideBombs = new JCheckBox("Боковые бомбы");
        checkBoxSideBombs.setBounds(10, 300, 180, 20);
        groupPlaneConfigPanel.add(checkBoxSideBombs);

        checkBoxBigBombs = new JCheckBox("Большие бомбы");
        checkBoxBigBombs.setBounds(10, 320, 180, 20);
        groupPlaneConfigPanel.add(checkBoxBigBombs);

        checkBoxMiniBombs = new JCheckBox("Маленькие крыло");
        checkBoxMiniBombs.setBounds(10, 340, 180, 20);
        groupPlaneConfigPanel.add(checkBoxMiniBombs);

        airConfigPanel = new AirConfigPanel();
        airConfigPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        airConfigPanel.setBounds(230, 20, 200, 200);
        frame.getContentPane().add(airConfigPanel);

        labelPictureBox = new JLabel("");
        PropertyChangeListener propertyChangeListenerPlane = propertyChangeEvent -> {
            if (labelPictureBox.getText().equals("Военный самолёт")) {
                setWarPlane();
            }
            if (labelPictureBox.getText().equals("Истребитель")) {
                setFighterPlane();
            }
            if (labelPictureBox.getText().equals("Квадратная форма")) {
                if (air instanceof FighterPlane) {
                    FighterPlane newPlane = (FighterPlane) air;
                    newPlane.setFloatForm(new squareMissiles((int) spinnerMissilesCount.getValue()));
                    air = newPlane;
                    frame.repaint();
                }
            }
            if (labelPictureBox.getText().equals("Овальная форма")) {
                if (air instanceof FighterPlane) {
                    FighterPlane newPlane = (FighterPlane) air;
                    newPlane.setFloatForm(new ovalMissiles((int) spinnerMissilesCount.getValue()));
                    air = newPlane;
                    frame.repaint();
                }
            }
            if (labelPictureBox.getText().equals("Комбинорованная форма")) {
                if (air instanceof FighterPlane) {
                    FighterPlane newPlane = (FighterPlane) air;
                    newPlane.setFloatForm(new combinedMissiles((int) spinnerMissilesCount.getValue()));
                    air = newPlane;
                    frame.repaint();
                }
            }
            labelPictureBox.setText("");
        };
        labelPictureBox.addPropertyChangeListener("text", propertyChangeListenerPlane);
        labelPictureBox.setBounds(230, 20, 200, 200);
        frame.getContentPane().add(labelPictureBox);

        var listenerForConfig = new DragMouseAdapter();

        labelPlane.addMouseListener(listenerForConfig);
        labelSeaPlane.addMouseListener(listenerForConfig);
        labelPictureBox.addMouseListener(listenerForConfig);

        labelPlane.setTransferHandler(new TransferHandler("text"));
        labelSeaPlane.setTransferHandler(new TransferHandler("text"));
        labelPictureBox.setTransferHandler(new TransferHandler("text"));

        frame.repaint();
    }


    private void setWarPlane() {
        air = new WarPlane((int) spinnerMaxSpeed.getValue(), (int) spinnerWeight.getValue(), Color.RED);
        airConfigPanel.setPlane(air);
        airConfigPanel.getPlane().SetPosition(40, 50, 200, 200);
        frame.repaint();
    }

    private void setFighterPlane() {
        air = new FighterPlane((int) spinnerMaxSpeed.getValue(), (int) spinnerWeight.getValue(), Color.RED, Color.GREEN, checkBoxFrontPlane.isSelected(), checkBoxSideBombs.isSelected(), checkBoxBigBombs.isSelected(), checkBoxMiniBombs.isSelected(), (int) spinnerMissilesCount.getValue(), "Комбинированые");
        airConfigPanel.setPlane(air);
        airConfigPanel.getPlane().SetPosition(40, 50, 200, 200);
        frame.repaint();
    }

    private void cancel() {
        frame.dispose();
    }

    private void addPlane() {
        if (air == null) {
            frameHangar.addAir(null);
        } else if (air instanceof FighterPlane) {
            FighterPlane newAir = (FighterPlane) air;
            frameHangar.addAir(newAir);
        } else {
            WarPlane newAir = (WarPlane) air;
            frameHangar.addAir(newAir);
        }
        frame.dispose();
    }
}
