package Views;

import Config.calendar;
import Conrolers.Controler_A;
import Models.Auteur;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuteurUI extends JFrame{
    private JPanel MainPanel;
    private JTextField txt_orcid;
    private JButton AJOUTERButton;
    private JButton button1;
    private JTextField txt_datedec;
    private JButton bnt_date_nai;
    private JTextField Txt_date_nai;
    private JTextField txt_nss;
    private JTextField txt_nom;
    private JTextField txt_prenom;

    public AuteurUI(){
Txt_date_nai.setFocusable(false);
txt_datedec.setFocusable(false);
    setContentPane(MainPanel);
    setVisible(true);
    setSize(new Dimension(500,620));
    setResizable(false);
    setLocationRelativeTo(null);


        button1.addActionListener(new ActionListener() {
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
        AJOUTERButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {


                String orcid = txt_orcid.getText();
                String nom = txt_nom.getText();
                String prenom = txt_prenom.getText();
                String nss =txt_nss.getText();
                String dn = Txt_date_nai.getText();
                String dd = txt_datedec.getText();
                boolean in;
                try {
                    Integer.parseInt(nss);
                    in = true;
                } catch (Exception ex) {
                    in = false;
                }
                DateFormat formatter;
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date  dd_date = null;
                Date dn_date = null;
                try {
                        dn_date = formatter.parse(dn);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "type de date est incorrect ", "Verification of Data", JOptionPane.WARNING_MESSAGE);

                }
                try {
                    dd_date = formatter.parse(dd);

                }
                catch(Exception ex){
                    System.out.println("erreur au niveau de parsing date");
                }

                if(orcid.isEmpty()||nom.isEmpty()||prenom.isEmpty()||in==false||dn.isEmpty())
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Empty Value Or incorrect type of data ", "Verification of Data", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Auteur a = new Auteur();
                a.setORCID(orcid);
                a.setNSS(Integer.parseInt(nss));
                a.setNom(nom);
                a.setPrenom(prenom);
                if (!dd.isEmpty())
                {
                    a.setDate_dec(dd_date);
                }
                else
                    {
                        a.setDate_dec(null);
                    }
                a.setDate_nai(dn_date);
                Controler_A ca = new Controler_A();
                ca.Ajouter(a);
                dispose();
            }
        });
    }

}
