package Conrolers;

import Config.MyStatement;
import Models.Auteur;
import Models.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controler_L {

    public DefaultTableModel mTableModel;
    public DefaultComboBoxModel mComboBox;
    public void remplirComboAuteur_Livre()  {
        try {
            String sql = "SELECT orcid FROM auteur ";
            ResultSet rset = new MyStatement().exeQuery(sql);
            mComboBox = new DefaultComboBoxModel();
            String orcid;
            while (rset.next()) {
                orcid = rset.getString("orcid");
                System.out.println(orcid);
                mComboBox.addElement(orcid);
            }
        } catch (Exception Ex) {
            System.out.println("Erreur  Connection :" + Ex.getMessage());

        }
    }
    public void chargerLivre(){
        try {
            String sql = "SELECT * FROM Livres";
            ResultSet rset = new MyStatement().exeQuery(sql);
            //header of Table
            Object columnNames[] = {"ISBN", "Titre", "Maison", "datepub", "ORCID"};
            mTableModel = new DefaultTableModel(columnNames, 0);
            Object[] row;
            while (rset.next()) {
                row = new Object[]{rset.getString(1), rset.getString(2), rset.getString(3), rset.getDate(4),rset.getString(5)};
                mTableModel.addRow(row);
            }
        } catch (Exception Ex) {
            System.out.println("Erreur  Connection :" + Ex.getMessage());

        }
    }
    /*public String Ajouter(Livre l )  {
        int s =0 ;
        String sql0 = "select count(*) from Auteur where isbn ='"+a.getORCID()+"'";
        ResultSet rset = new MyStatement().exeQuery(sql0);
        try {
            rset.next();
            s = rset.getInt(1);
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
        if(s<=0)
        {
            try {

                //  String sql = "insert into auteur values ('401',33,'ffdfd','cvcv',null ,'1954-03-04')";
                System.out.println("a1 = " +a.getDate_dec() );
                if(null == a.getDate_dec())
                {

                    java.sql.Date dateNai = new java.sql.Date(a.getDate_nai().getTime());
                    String sql = "insert into auteur values ('"+a.getORCID()+"',"+a.getNSS()+",'"+a.getNom()+"','"+a.getPrenom()+"',"+null+",'"+dateNai+"')";
                    new MyStatement().exeUpdate(sql);

                }
                else
                {
                    System.out.println("a3 = " +a.getDate_dec() );
                    java.sql.Date dateDesc = new java.sql.Date( a.getDate_dec().getTime());
                    java.sql.Date dateNai = new java.sql.Date(a.getDate_nai().getTime());
                    String sql = "insert into auteur values ('"+a.getORCID()+"',"+a.getNSS()+",'"+a.getNom()+"','"+a.getPrenom()+"','"+dateDesc+"','"+dateNai+"')";
                    new MyStatement().exeUpdate(sql);

                }




            }catch (Exception ed)
            {
                System.out.println("Exception = " + ed.getMessage());
            }
            return "ok";
        }
        else return "ORCID déja exist";
    }
*/


}
