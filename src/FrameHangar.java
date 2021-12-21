import javax.swing.*;
import java.awt.*;

public class FrameHangar {

    private final JFrame frame;
    private final Hangar<Plane, IMissilesForm> hangar;
    private final JTextField textFieldTakePlane;

    public FrameHangar() {
        frame = new JFrame("Ангар");
        frame.setSize(900, 515);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        hangar = new Hangar<>(700, 470);

        HangarPanel hangarPanel = new HangarPanel(hangar);
        JButton buttonCreateWarPlane = new JButton("Создать военный самолёт");
        JButton buttonCreateFighterPlane = new JButton("Создать истребитель");
        JButton buttonTakePlane = new JButton("Забрать");
        JLabel labelPlace = new JLabel("Место:");
        JLabel labelTakePlane = new JLabel("Забрать самолёт:");
        textFieldTakePlane = new JTextField();

        frame.getContentPane().add(hangarPanel);
        frame.getContentPane().add(buttonCreateWarPlane);
        frame.getContentPane().add(buttonCreateFighterPlane);
        frame.getContentPane().add(buttonTakePlane);
        frame.getContentPane().add(labelPlace);
        frame.getContentPane().add(labelTakePlane);
        frame.getContentPane().add(textFieldTakePlane);

        hangarPanel.setBounds(0, 0, 650, 470);
        buttonCreateWarPlane.setBounds(710, 10, 170, 30);
        buttonCreateFighterPlane.setBounds(710, 50, 170, 30);
        labelPlace.setBounds(710, 130, 170, 20);
        labelTakePlane.setBounds(710, 100, 170, 20);
        textFieldTakePlane.setBounds(710, 160, 170, 20);
        buttonTakePlane.setBounds(710, 190, 170, 30);

        buttonCreateWarPlane.addActionListener(e -> createWarPlane());
        buttonCreateFighterPlane.addActionListener(e -> createFighterPlane());
        buttonTakePlane.addActionListener(e -> takePlane());

        frame.repaint();
    }

    private void createWarPlane() {
        JColorChooser colorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(frame, colorDialog);
        if (colorDialog.getColor() != null) {
            WarPlane air = new WarPlane((int) (Math.random() * 100 + 50), (int) (Math.random() * 1000 + 1500), colorDialog.getColor());
            if (hangar.plus(air)) {
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Аэродром переполнен");
            }
        }
    }

    private void createFighterPlane() {
        JColorChooser mainСolorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(frame, mainСolorDialog);
        if (mainСolorDialog.getColor() != null) {
            JColorChooser dopColorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(frame, dopColorDialog);
            if (dopColorDialog.getColor() != null) {
                FighterPlane air = new FighterPlane((int) (Math.random() * 100 + 50), (int) (Math.random() * 1000 + 1500), mainСolorDialog.getColor(), dopColorDialog.getColor(), true, true, true, true, 0, "Комбинированые");
                if (hangar.plus(air)) {
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Аэродром переполнен");
                }
            }
        }
    }

    private void takePlane() {
        if (!textFieldTakePlane.getText().equals("")) {
            Plane air = hangar.minus(Integer.parseInt(textFieldTakePlane.getText()));
            if (air == null) {
                JOptionPane.showMessageDialog(frame, "Это место пусто");
            } else {
                FrameFighterPlane frameFighterPlane = new FrameFighterPlane();
                frameFighterPlane.setPlane(air);
                frame.repaint();
            }
        }
    }
}