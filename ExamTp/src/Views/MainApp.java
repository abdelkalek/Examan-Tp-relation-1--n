package Views;

import Conrolers.Controler_A;
import Conrolers.Controler_L;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainApp extends JFrame {
    private JPanel mainpane;
    private JTabbedPane tabbedPane1;
    private JTable Table_L;
    private JButton ajouterButton;
    private JTextField textField1;
    private JScrollPane Table_Au;
    private JTable Table_A;
    private JButton Bnt_addAut;
    private JButton Bnt_modAut;
    private JButton Bnt_delAut;
    private JTextField txt_recherche;
    Controler_L cl = new Controler_L();
    Controler_A ca = new Controler_A();

    public void onLoad()
{

    setContentPane(mainpane);
    setVisible(true);
    setSize(new Dimension(650,400));
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(MainApp.EXIT_ON_CLOSE);
    cl.chargerLivre();
    Table_L.setModel(cl.mTableModel);
    ca.chargerAuteur();
    Table_A.setModel(ca.mTableModel);

}
    public MainApp(){
    onLoad();

        Bnt_addAut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AuteurUI au = new AuteurUI();
                au.setVisible(true);
                au.addWindowListener(new java.awt.event.WindowAdapter() {
                    @SneakyThrows
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        ca.chargerAuteur();
                        Table_A.setModel(ca.mTableModel);

                    }
                });





            }
        });
        Bnt_delAut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Table_A.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Sélectionner  un enregistrement :)", "Verification", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String ref = Table_A.getModel().getValueAt(row, 0).toString();
                try {
                    ca.Supprimer(ref);
                    ca.chargerAuteur();
                    Table_A.setModel(ca.mTableModel);
                } catch (Exception ex) {
                    System.out.println(" Erreur delete ");
                }
            }
        });

        /*----------------------------*/
        Bnt_modAut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Table_A.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Sélectionner  un enregistrement :)", "Verification", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String orcid = Table_A.getModel().getValueAt(row, 0).toString();
                String nss = Table_A.getModel().getValueAt(row, 1).toString();
                String nom = Table_A.getModel().getValueAt(row, 2).toString();
                String prenom = Table_A.getModel().getValueAt(row, 3).toString();
                String date_dec ="" ;
                try {
                    date_dec= Table_A.getModel().getValueAt(row, 4).toString();
                 }
                catch(Exception ec)
                {
                    date_dec=null;
                }
                String date_nai = Table_A.getModel().getValueAt(row, 5).toString();

                Mod_A mo = new Mod_A();
                mo.txtORCID.setText(orcid);
                mo.txtNSS.setText(nss);
                mo.txtNom.setText(nom);
                mo.txtPRENOM.setText(prenom);
               mo.txt_datedec.setText(date_dec);
                mo.Txt_date_nai.setText(date_nai);
                mo.setVisible(true);
                mo.addWindowListener(new java.awt.event.WindowAdapter() {
                    @SneakyThrows
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        ca.chargerAuteur();
                        Table_A.setModel(ca.mTableModel);
                    }
                });

            }
        });

        txt_recherche.addKeyListener(new KeyAdapter() {
            @SneakyThrows
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                ca.ChercherAuteur(txt_recherche.getText().toString());
                Table_A.setModel(ca.mTableModel);
            }
        });
    }
    public static void main(String[] args) {
        MainApp m = new MainApp();
    }}

