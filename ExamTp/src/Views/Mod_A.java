package Views;

import Config.calendar;
import Conrolers.Controler_A;
import Models.Auteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mod_A extends JFrame {
    private JPanel MainPanel;
    public JTextField txtORCID;
    private JButton Modier_button;
    public JTextField txt_datedec;
    public JTextField Txt_date_nai;
    private JButton dateDecBNT;
    private JButton bnt_date_nai;
    public JTextField txtNSS;
    public JTextField txtNom;
    public JTextField txtPRENOM;

    public Mod_A()  {
        setContentPane(MainPanel);
        setVisible(true);
        setSize(new Dimension(500,620));
        setResizable(false);
        setLocationRelativeTo(null);

        Modier_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        dateDecBNT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar c = new calendar();
                c.setTxtdate(txt_datedec);
                c.setAlwaysOnTop(true);
                c.setLocationRelativeTo(null);
                c.setSize(250, 250);
                c.setResizable(false);
                c.setVisible(true);
            }
        });
        bnt_date_nai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar c = new calendar();
                c.setTxtdate(Txt_date_nai);
                c.setAlwaysOnTop(true);
                c.setLocationRelativeTo(null);
                c.setSize(250, 250);
                c.setResizable(false);
                c.setVisible(true);
            }
        });
        Modier_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    boolean in ;
                    try
                    {
                        Integer.parseInt(txtNSS.getText());
                        in = true;
                    }catch(Exception ex)
                    {
                        in= false;
                    }
                    if(txtORCID.getText().isEmpty()|| txtNom.getText().isEmpty() || in== false  ){
                        JOptionPane.showMessageDialog( new  JFrame() ,"Empty Value Or incorrect type ","Verification of Data",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                Auteur Ma = new Auteur();
                Ma.setORCID(txtORCID.getText());
                Ma.setNSS(Integer.parseInt(txtNSS.getText()));
                Ma.setNom(txtNom.getText());
                Ma.setNom(txtPRENOM.getText());

                DateFormat formatter;
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date dd_date = null;
                Date dn_date = null;
                try {
                    dn_date = formatter.parse(txt_datedec.getText());
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "type de date est incorrect ", "Verification of Data", JOptionPane.WARNING_MESSAGE);

                }
                try {
                    dd_date = formatter.parse(txt_datedec.getText());

                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "type de date est incorrect ", "Verification of Data", JOptionPane.WARNING_MESSAGE);

                }

                Ma.setDate_dec(dd_date);
                Ma.setDate_nai(dn_date);

                Controler_A a = new Controler_A();
                    a.modifier(Ma,txtORCID.getText());
                JOptionPane.showMessageDialog( new  JFrame() ,"Article Modifier avec  succès ","Modification Notice",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Form Modifier Ok" );


                dispose();
            }
        });
    }
}
