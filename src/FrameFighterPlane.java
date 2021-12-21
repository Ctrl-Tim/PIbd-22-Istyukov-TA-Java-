import javax.swing.*;
import java.awt.*;

public class FrameFighterPlane {
    private final JFrame frame;
    private MyPanel myPanel;
    private JComboBox missiles;
    private JComboBox missilesForm;

    public FrameFighterPlane() {
        frame = new JFrame("Истребитель");
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        Icon left = new ImageIcon("resources\\arrowLeft.png");
        Icon right = new ImageIcon("resources\\arrowRight.png");
        Icon up = new ImageIcon("resources\\arrowUp.png");
        Icon down = new ImageIcon("resources\\arrowDown.png");

        JButton btnCreateWarPlane = new JButton("Создать военный самолёт");
        JButton btnCreateFighterPlane = new JButton("Создать истребитель");


        JButton btnUp = new JButton(up);
        btnUp.setName("up");
        JButton btnDown = new JButton(down);
        btnDown.setName("down");
        JButton btnLeft = new JButton(left);
        btnLeft.setName("left");
        JButton btnRight = new JButton(right);
        btnRight.setName("right");

        frame.getContentPane().add(btnCreateWarPlane);
        frame.getContentPane().add(btnCreateFighterPlane);
        frame.getContentPane().add(btnUp);
        frame.getContentPane().add(btnDown);
        frame.getContentPane().add(btnLeft);
        frame.getContentPane().add(btnRight);

        btnCreateWarPlane.setBounds(10, 10, 190, 30);
        btnCreateFighterPlane.setBounds(210, 10, 180, 30);
        btnUp.setBounds(803, 375, 30, 30);
        btnDown.setBounds(803, 410, 30, 30);
        btnLeft.setBounds(768, 410, 30, 30);
        btnRight.setBounds(838, 410, 30, 30);

        btnCreateWarPlane.addActionListener(e -> setWarPlane());
        btnCreateFighterPlane.addActionListener(e -> setFighterPlane());
        btnUp.addActionListener(e -> setDirection(btnUp));
        btnDown.addActionListener(e -> setDirection(btnDown));
        btnLeft.addActionListener(e -> setDirection(btnLeft));
        btnRight.addActionListener(e -> setDirection(btnRight));

        missilesForm = new JComboBox(new String[]{"Прямоугольные", "Овальные", "Комбинированые"});
        frame.getContentPane().add(missilesForm);
        missilesForm.setBounds(200, 45, 180, 30);

        missiles = new JComboBox(new String[]{"2 ракеты", "4 ракеты", "6 ракет"});
        frame.getContentPane().add(missiles);
        missiles.setBounds(10, 45, 90, 30);

    }

    public void addMyPanel(MyPanel panel) {
        myPanel = panel;
        frame.getContentPane().add(myPanel);
        myPanel.setBounds(0, 0, 900, 500);
        frame.repaint();
    }

    private void setDirection(JButton button) {
        String name = button.getName();
        switch (name) {
            case "up":
                myPanel.getPlane().MoveAir(Direction.Up);
                break;
            case "down":
                myPanel.getPlane().MoveAir(Direction.Down);
                break;
            case "left":
                myPanel.getPlane().MoveAir(Direction.Left);
                break;
            case "right":
                myPanel.getPlane().MoveAir(Direction.Right);
                break;
        }
        frame.repaint();
    }

    private void setWarPlane() {
        myPanel.setPlane(new WarPlane((int) (Math.random() * 100 + 50), (int)(Math.random() * 1000 + 500), Color.RED));
        myPanel.getPlane().SetPosition((int) (Math.random() * 100 + 10), (int) (Math.random() * 100 + 10), 850, 450);
        frame.repaint();
    }

    private void setFighterPlane() {
        myPanel.setPlane(new FighterPlane((int) (Math.random() * 100 + 50), (int)(Math.random() * 1000 + 500), Color.RED, Color.GREEN, true, true, true, true, missiles.getSelectedIndex(), missilesForm.getSelectedItem().toString()));
        myPanel.getPlane().SetPosition((int) (Math.random() * 100 + 10), (int) (Math.random() * 100 + 10), 850, 450);
        frame.repaint();
    }
}