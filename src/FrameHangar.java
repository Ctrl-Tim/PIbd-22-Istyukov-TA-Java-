import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Stack;

public class FrameHangar {

    private final JFrame frame;
    private final HangarPanel hangarPanel;
    private final Stack<Plane> planeStack;
    private final HangarCollection hangarCollection;
    private final DefaultListModel<String> hangarList;
    private final JList<String> listBoxHangars;
    private final JTextField fieldHangarName;
    private final JTextField textFieldTakePlane;

    public FrameHangar() {
        planeStack = new Stack<>();

        frame = new JFrame("Ангар");
        frame.setSize(1000, 515);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        hangarCollection = new HangarCollection(700, 450);
        hangarPanel = new HangarPanel(hangarCollection);

        JButton buttonCreateAir = new JButton("Создать самолёт");
        JLabel labelPlace = new JLabel("Место:");
        JLabel labelTakePlane = new JLabel("Забрать самолёт:");
        textFieldTakePlane = new JTextField();
        JButton buttonMoveToStack = new JButton("Поместить");
        JButton buttonGetFromStack = new JButton("Получить");

        JLabel labelHangarName = new JLabel("Имя ангара");
        hangarList = new DefaultListModel<>();
        listBoxHangars = new JList<>(hangarList);
        fieldHangarName = new JTextField();
        JButton buttonAddHangar = new JButton("Добавить ангар");
        JButton buttonDelHangar = new JButton("Удалить ангар");

        frame.getContentPane().add(hangarPanel);
        frame.getContentPane().add(buttonCreateAir);
        frame.getContentPane().add(labelPlace);
        frame.getContentPane().add(labelTakePlane);
        frame.getContentPane().add(textFieldTakePlane);

        frame.getContentPane().add(buttonMoveToStack);
        frame.getContentPane().add(buttonGetFromStack);
        frame.getContentPane().add(labelHangarName);
        frame.getContentPane().add(fieldHangarName);
        frame.getContentPane().add(buttonAddHangar);
        frame.getContentPane().add(buttonDelHangar);
        frame.getContentPane().add(listBoxHangars);

        labelHangarName.setBounds(710, 10, 270, 30);
        fieldHangarName.setBounds(710, 40, 270, 30);
        buttonAddHangar.setBounds(710, 70, 270, 30);
        listBoxHangars.setBounds(710, 130, 270, 60);
        buttonDelHangar.setBounds(710, 200, 270, 30);

        hangarPanel.setBounds(0, 0, 650, 470);
        buttonCreateAir.setBounds(710, 240, 270, 30);
        labelPlace.setBounds(710, 110, 270, 20);
        labelTakePlane.setBounds(710, 360, 270, 20);
        textFieldTakePlane.setBounds(710, 390, 270, 20);
        buttonGetFromStack.setBounds(710, 420, 130, 30);
        buttonMoveToStack.setBounds(850, 420, 130, 30);

        buttonCreateAir.addActionListener(e -> createAir());

        buttonMoveToStack.addActionListener(e -> takePlane());
        buttonGetFromStack.addActionListener(e -> moveToFrame());
        buttonAddHangar.addActionListener(e -> addHangar());
        buttonDelHangar.addActionListener(e -> delHangar());
        listBoxHangars.addListSelectionListener(e -> listListener());

        frame.repaint();
    }

    private void createAir() {
        FrameAirConfig frameAirConfig = new FrameAirConfig(this);
    }

    public void addAir(Plane air) {
        if (air != null && listBoxHangars.getSelectedIndex() >= 0) {
            if (((hangarCollection.get(listBoxHangars.getSelectedValue()).plus(air)))) {
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Самолет не удалось поставить");
            }
        }
    }

    private void takePlane() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            if (!textFieldTakePlane.getText().equals("")) {
                try {
                    Plane air = hangarCollection.get(listBoxHangars.getSelectedValue()).minus(Integer.parseInt(textFieldTakePlane.getText()));
                    if (air != null) {
                        planeStack.add(air);
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Самолёта с таким индексом нет!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Самолёта с таким индексом нет!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ангар не выбран");
        }
    }

    private void moveToFrame() {
        if (!planeStack.isEmpty()) {
            FrameFighterPlane framePlane = new FrameFighterPlane();
            framePlane.setPlane(Objects.requireNonNull(planeStack.pop()));
            frame.repaint();
        }
    }

    private void addHangar() {
        if (!fieldHangarName.getText().equals("")) {
            hangarCollection.AddHangar(fieldHangarName.getText());
            reloadLevels();
            frame.repaint();
        } else {
            JOptionPane.showMessageDialog(frame, "Введите название ангара");
        }
    }

    private void delHangar() {
        if (listBoxHangars.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(frame, "Удалить ангар " + listBoxHangars.getSelectedValue() + "?");
            if (result == JOptionPane.YES_OPTION) {
                hangarCollection.DelHangar(listBoxHangars.getSelectedValue());
                reloadLevels();
                frame.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Ангар не выбран");
        }
    }

    private void reloadLevels() {
        int index = listBoxHangars.getSelectedIndex();

        hangarList.removeAllElements();
        int i = 0;
        for (String name : hangarCollection.keySet()) {
            hangarList.add(i, name);
            i++;
        }

        int itemsCount = hangarList.size();
        if (itemsCount > 0 && (index < 0 || index >= itemsCount)) {
            listBoxHangars.setSelectedIndex(0);
        } else if (index >= 0 && index < itemsCount) {
            listBoxHangars.setSelectedIndex(index);
        }
    }

    private void listListener() {
        hangarPanel.setSelectedItem(listBoxHangars.getSelectedValue());
        frame.repaint();
    }
}