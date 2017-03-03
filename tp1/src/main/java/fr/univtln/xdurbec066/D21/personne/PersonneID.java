package fr.univtln.xdurbec066.D21.personne;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

/**
 * Created by xdurbec066 on 01/03/17.
 */

@Embeddable
public class PersonneID implements Serializable {
    private String nom;
    private String prenom;

    public PersonneID(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public PersonneID() {
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

    @Override
    public String toString() {
        return "PersonneID{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonneID)) return false;

        PersonneID that = (PersonneID) o;

        if (getNom() != null ? !getNom().equals(that.getNom()) : that.getNom() != null) return false;
        return getPrenom() != null ? getPrenom().equals(that.getPrenom()) : that.getPrenom() == null;

    }

    @Override
    public int hashCode() {
        int result = getNom() != null ? getNom().hashCode() : 0;
        result = 31 * result + (getPrenom() != null ? getPrenom().hashCode() : 0);
        return result;
    }
}
