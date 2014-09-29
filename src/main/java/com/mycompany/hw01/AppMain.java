/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw01;

import java.sql.SQLException;
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
                emf.close();
    }
}
