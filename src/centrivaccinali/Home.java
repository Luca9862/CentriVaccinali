package centrivaccinali;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    private JPanel panelHome;
    private JTextField textField1;
    private JButton button1;

    public Home() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button1,textField1.getText()+" Hello World");
            }
        });
    }

    public static void main(String[] args){
        Home h = new Home();
        h.setLocation(500,200);
        h.setContentPane(h.panelHome);
        h.setTitle("Centri Vaccinali");
        h.setSize(800, 500);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
