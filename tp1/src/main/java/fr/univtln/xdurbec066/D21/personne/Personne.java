package fr.univtln.xdurbec066.D21.personne;

import fr.univtln.xdurbec066.D21.chien.Chien;

import javax.persistence.*;

/**
 * Created by xdurbec066 on 01/03/17.
 */


@Entity
public class Personne {

        @EmbeddedId
        private PersonneID personneID;
        private int age;

        @OneToOne(cascade = {CascadeType.PERSIST})
        private Chien chien;


    public Personne(String nom,String prenom, int age, Chien chien) {
        this.personneID = new PersonneID(nom,prenom);
        this.age = age;
        this.chien = chien;
      //  chien.setPersonne(this);
    }

    public Personne(String nom,String prenom, Chien chien) {
        this(nom,prenom,0,chien);
    }

    public Personne() {
    }

    public PersonneID getPersonneID() {
        return personneID;
    }

    public void setPersonneID(PersonneID personneID) {
        this.personneID = personneID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Chien getChien() {
        return chien;
    }

    public void setChien(Chien chien) {
        this.chien = chien;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "personneID=" + personneID +
                ", age=" + age +", "+ chien +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne)) return false;

        Personne personne = (Personne) o;

        return getPersonneID() != null ? getPersonneID().equals(personne.getPersonneID()) : personne.getPersonneID() == null;

    }

    @Override
    public int hashCode() {
        return getPersonneID() != null ? getPersonneID().hashCode() : 0;
    }
}
