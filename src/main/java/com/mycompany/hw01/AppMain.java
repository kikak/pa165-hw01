/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw01;

import com.mycompany.hw01.Entity.Person;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author kika
 */
public class AppMain {
    public static void main(String[] args) throws SQLException {
		//The following line is here just to start up a in-memory database 
		//new AnnotationConfigApplicationContext(DaoContext.class);
		
		System.out.println(" ****** STARTING APPLICATOIN ****** ");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");
                EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Person person = new Person();
                person.setLastName("Smith");
                person.setFirstName("Paul");
                person.setAddress("Botanicka 68a, Brno");
                em.persist(person);
                em.getTransaction().commit();
                
                em.getTransaction().begin();
                person.setLastName("Brown");
                em.getTransaction().commit();
                
                em.getTransaction().begin();
                person.setAddress("Chvalovice 12");
                em.detach(person);
                em.getTransaction().commit();
                //printAllPersons(emf);
                /*em.getTransaction().begin();
                em.remove(person);
                em.getTransaction().commit();*/
                
                em.close();
		printAllPersons(emf);
                
                EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
               
                //person.setAddress("Masarykova 2, Brno");
                em2.refresh(person);
                em2.getTransaction().commit();
                printAllPersons(emf);
                em2.getTransaction().begin();
                em2.remove(person);
                em2.getTransaction().commit();
                em2.close();
                printAllPersons(emf);
                emf.close();
    }
    
    public static void printAllPersons(EntityManagerFactory emf){
        System.out.println(" ********************************");
		System.out.println("        PERSON LIST      ");
		EntityManager em = emf.createEntityManager();
		List<Person> persons = em.createQuery("SELECT p from SimplePerson p",Person.class).getResultList();
		
		for (Person p : persons) {
			System.out.println(p);
		}
		
		em.close();
    }
}
