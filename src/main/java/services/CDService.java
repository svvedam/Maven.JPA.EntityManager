package services;

import entities.Artist;
import entities.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CDService {
    EntityManager em = null;
    EntityTransaction tx = null;

    public CDService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public CD createCD(String title, String description, int year, Set<Artist> artists, float price){

        CD cd = new CD();
        cd.setTitle(title);
        cd.setDesc(description);
        cd.setYear(year);
        cd.setArtists(artists);
        cd.setPrice(price);
        tx.begin();
        em.persist(cd);
        tx.commit();

        return cd;
    }
    public CD create(CD cd){
        tx.begin();
        em.persist(cd);
        tx.commit();
        return cd;
    }
    public CD findById(Long id){
        int i = Math.toIntExact(id);
        tx.begin();
        CD newCD = em.find(CD.class,i);
        tx.commit();
        return newCD;
    }
    public List<CD> findAll(){
        Query query = em.createQuery("SELECT e FROM CD e");

        List<CD> returnValue = query.getResultList();

        return returnValue;
    }
    public CD update(CD cd,int year){

        CD cdToBeUpdated = em.merge(cd);

        tx.begin();
        cdToBeUpdated.setYear(year);
        tx.commit();
        return cd;
    }
    public void delete(CD cd){
        CD cdToBeDeleted = em.merge(cd);
        tx.begin();
        em.remove(cdToBeDeleted);
        tx.commit();
    }
}
