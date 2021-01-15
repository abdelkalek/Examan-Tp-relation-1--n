package Views;

import Config.calendar;
import Conrolers.Controler_A;
import Conrolers.Controler_L;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Livre extends JFrame {
    private JButton AJOUTERButton;
    private JTextField nomTextField;
    private JPanel MainPanel;
    private JComboBox comboBox1;
    private JButton bnt_datePub;
    private JTextField Txt_datePub;
   Controler_L cl = new Controler_L();

    public Livre() {
        cl.remplirComboAuteur_Livre();
        comboBox1.setModel(cl.mComboBox);
        Txt_datePub.setFocusable(false);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(comboBox1);
        }
        catch
        (Exception e)
        {
            System.out.println("args = " + e.getMessage());
        }
        setContentPane(MainPanel);
        setVisible(true);
        setSize(new Dimension(500,620));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        bnt_datePub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar c = new calendar();
                c.setTxtdate(Txt_datePub);
                c.setAlwaysOnTop(true);
                c.setLocationRelativeTo(null);
                c.setSize(250, 250);
                c.setResizable(false);
                c.setVisible(true);
            }
        });


        AJOUTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        Livre a = new Livre();

    }

}
