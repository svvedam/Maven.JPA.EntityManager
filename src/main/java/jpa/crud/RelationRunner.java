package jpa.crud;

import entities.Artist;
import entities.CD;
import services.CDService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RelationRunner {
    public static void main(String ...args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testdb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        /*Create */
        Set<Artist> tcq = new HashSet<>();
        tcq.add(new Artist(" Q-", "Tip","Guitar"));
        tcq.add(new Artist("Phife", "Dawg","Violin"));
        tcq.add(new Artist("Shaheed", "Muhammad","Veena"));
        tcq.add(new Artist("Jarobi", "White","Sitar"));
        Set<Artist> tcq1 = new HashSet<>();
        tcq1.add(new Artist(" Q-", "Tip","Guitar"));
        tcq1.add(new Artist("Phife", "Dawg","Violin"));
        tcq1.add(new Artist("Shaheed", "Muhammad","Veena"));
        tcq1.add(new Artist("Jarobi", "White","Sitar"));
        Set<Artist> tcq2 = new HashSet<>();
        tcq2.add(new Artist(" Q-", "Tip","Guitar"));
        tcq2.add(new Artist("Phife", "Dawg","Violin"));
        tcq2.add(new Artist("Shaheed", "Muhammad","Veena"));
        tcq2.add(new Artist("Jarobi", "White","Sitar"));

        CDService cdService= new CDService(em);

        CD cd = new CD("Toy","story",2000,tcq,21);

        CD cd1= new CD("Harry","Potter",2000,tcq1,21);

        CD cd2= new CD("Tinker","Bell",2000,tcq2,21);

        CD newCd= cdService.create(cd);
        CD newCd1= cdService.create(cd1);
        CD newCd2= cdService.create(cd2);


        System.out.println("CD Persistend : " + newCd);
        System.out.println("CD Persistend : " + newCd1);
        System.out.println("CD Persistend : " + newCd2);
        CDService cdService1= new CDService(em);

        CD myCD  = cdService1.findById((long) newCd.getCdId());

        System.out.println("Found CD : " + " title : "+ myCD.getTitle()+ " Artist " + myCD.getArtists());
        //delete
        //cdService1.delete(cd);

       // Update
        CD myCD1 = cdService1.update(newCd,2010);
        System.out.println("Updated Year : " + myCD1.getYear());

        //FindAll
        CDService cdService2= new CDService(em);

        System.out.println("Finding all CD's");
        List<CD>myCDList = cdService2.findAll();
        for(CD returnCD: myCDList){
            System.out.println(" ID: "+returnCD.getCdId());
            System.out.println(" Description: "+returnCD.getDesc());
            System.out.println(" Title: "+returnCD.getTitle());
        }
    }
}
