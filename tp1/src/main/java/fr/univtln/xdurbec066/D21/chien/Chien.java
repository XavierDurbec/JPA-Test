package fr.univtln.xdurbec066.D21.chien;

import fr.univtln.xdurbec066.D21.personne.Personne;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xdurbec066 on 01/03/17.
 */

 @Entity
public class Chien implements Serializable{
    @Id
   private int id;

    private String nom;

    @OneToOne
    private Personne personne;

    public Chien() {
    }

    public Chien(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Personne getPersonne() {return personne;}

    public void setPersonne(Personne personne) {this.personne = personne;}

    @Override
    public String toString() {
        return "Chien{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chien)) return false;

        Chien chien = (Chien) o;

        return getId() == chien.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }
}
