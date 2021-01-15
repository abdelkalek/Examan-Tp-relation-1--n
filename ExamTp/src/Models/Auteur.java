package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auteur {
    private String ORCID ;
    private int NSS;
    private String nom;
    private String prenom;
    private Date date_dec;
    private Date date_nai;

    public String getORCID() {
        return ORCID;
    }

    public void setORCID(String ORCID) {
        this.ORCID = ORCID;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_dec() {
        return date_dec;
    }

    public void setDate_dec(Date date_dec) {
        this.date_dec = date_dec;
    }

    public Date getDate_nai() {
        return date_nai;
    }

    public void setDate_nai(Date date_nai) {
        this.date_nai = date_nai;
    }
}
