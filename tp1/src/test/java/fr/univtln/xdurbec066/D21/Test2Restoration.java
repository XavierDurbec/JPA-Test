package fr.univtln.xdurbec066.D21;

import fr.univtln.xdurbec066.D21.personne.Personne;
import fr.univtln.xdurbec066.D21.personne.PersonneID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by xdurbec066 on 01/03/17.
 */
public class Test2Restoration {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        transac.begin();

        Personne p1 = em.find(Personne.class,new PersonneID("Buerre","Durand"));
        System.out.println(p1);
        p1.setAge(20);
       // em.refresh(p1);
        em.merge(p1);
        transac.commit();
        System.out.println(p1);



    }
}
