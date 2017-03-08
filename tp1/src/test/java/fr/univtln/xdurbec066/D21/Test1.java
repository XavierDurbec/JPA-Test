package fr.univtln.xdurbec066.D21;
import fr.univtln.xdurbec066.D21.chien.Chien;

import fr.univtln.xdurbec066.D21.personne.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by xdurbec066 on 01/03/17.
 */
public class Test1 {
    public static void main(String[] args) {


        Chien chien1 = new Chien(1,"Medore");
        Chien chien2 = new Chien(2,"Iasi");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();

        Personne p1 = new Personne("Buerre","Durand",chien1);
        Personne p2 = new Personne("Albert","Wersker",chien2);


        EntityTransaction transac = em.getTransaction();

        transac.begin();
        em.persist(p1);
        em.persist(p2);
        transac.commit();
    }

}
