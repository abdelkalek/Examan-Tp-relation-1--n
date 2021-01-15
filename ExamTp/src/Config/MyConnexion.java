/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnexion {
    
    private String url="jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String login="root";
    private String pwd="";
    
    private static Connection connection;
    
    
    private static MyConnexion instance;

        

    private MyConnexion() {
          try {
            /**
             * Le constructeur étant privé pour 
             * Le constructeur se charge de :
             *  1 - Charger le Driver (pilote) en mémoire
             *  2 - Créer l'objet de connexion à la base avec les variables déclarées ci-dessus
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,login,pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Serveur n'est pas démarrer !\n Merci de lancer le serveur", "Erreur de connection au serveur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Serveur n'est pas démarrer !\n Merci de lancer le serveur", "Erreur de connection au serveur", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    
    
    public static MyConnexion getInstance(){
        if(instance == null){
            instance = new MyConnexion();
        }
        return instance;
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }  
    
    
    
    
    
    
}
