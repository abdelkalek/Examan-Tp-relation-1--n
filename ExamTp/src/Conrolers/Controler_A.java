package Conrolers;

import Config.MyStatement;
import Models.Auteur;
import jdk.nashorn.internal.runtime.ECMAException;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controler_A {

    public DefaultTableModel mTableModel;

    public void chargerAuteur(){
        try {
            String sql = "SELECT * FROM Auteur";
            ResultSet rset = new MyStatement().exeQuery(sql);
            //header of Table
            Object columnNames[] = {"ORCID", "NSS", "nom", "prenom", "date_dec", "date_nai"};
            mTableModel = new DefaultTableModel(columnNames, 0);
            Object[] row;
            while (rset.next()) {
                row = new Object[]{rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4),rset.getDate(5),rset.getDate(6)};
                mTableModel.addRow(row);
            }
        } catch (Exception Ex) {
            System.out.println("Erreur  Connection :" + Ex.getMessage());

        }
    }
    public String Ajouter(Auteur a)  {
        int s =0 ;
       String sql0 = "select count(*) from Auteur where ORCID ='"+a.getORCID()+"'";
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
    public void Supprimer(String s) {
        // Create DataSource and connect to the local database
        try {
            // modifier  un Article avec update
            new MyStatement().exeUpdate("DELETE FROM `auteur` WHERE ORCID='"+s+"'");
        }catch (Exception Ex )
        {
            System.out.println("Erreur  Connection :"+Ex.getMessage());
        }
        // Close the result set, statement, and the connection
        System.out.println("Auteur Supprimer Ok" );
    }
public void modifier(Auteur A , String Orcid)
{
    System.out.println("B = " + A + ", Orcid = " + Orcid);
try {

    new MyStatement().exeUpdate("UPDATE auteur SET  NSS = "+A.getNSS()+", nom = '"+A.getNom()+"',prenom = '"+A.getPrenom()+"',date_dec = '"+A.getDate_dec()+"',date_nai ='"+A.getDate_nai()+" WHERE ORCID = '"+Orcid+"'");

}
catch(Exception ec)
{
    System.out.println("A = " + A + ", Orcid = " + Orcid);
}
}

    public void ChercherAuteur(String chaine) {
        try {
            ResultSet rset=  new MyStatement().exeQuery("SELECT * FROM auteur where prenom like '%"+chaine+"%' or nom like '%"+chaine+"%'");
            Object columnNames[] = {"ORCID", "NSS", "nom", "prenom", "date_dec", "date_nai"};
            mTableModel = new DefaultTableModel(columnNames, 0);
            Object[] row;
            while (rset.next()) {
                row = new Object[]{rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4),rset.getDate(5),rset.getDate(6)};
                mTableModel.addRow(row);
            }
        }catch (Exception Ex )
        {
            System.out.println("Erreur  Connection :"+Ex.getMessage());
        }
    }
}
