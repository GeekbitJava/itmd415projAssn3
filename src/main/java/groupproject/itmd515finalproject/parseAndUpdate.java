package groupproject.itmd515finalproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/*
Deborah Barndt
	 Thomas Boller
	 2-23-18
	 parseAndUpdage.java
	 Project Assignment 1
	This is a class used to act as main for testing our project assignment 1 files
*/


public class parseAndUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XmlParser parse = new XmlParser();
		//DAO daoO = new DAO();
		
		parse.parseDTXML();
		//daoO.createTables();
		//daoO.insertDtRecords(parse.getDtArray());
		
		parse.parseTTXML();
		//daoO.insertTaxRecords(parse.gettTaxArray());
		
		parse.parseUserXML();
		//daoO.insertUsers(parse.getUsrArray());
		
		parse.parsePaymentXML();
		//daoO.insertPayment(parse.getPayArray());
		
		parse.parseVehiclesXML();
		//daoO.insertVehicles(parse.getVArray());
		
		parse.parseDriversXML();
		//daoO.insertDrivers(parse.getDriverArray());
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("iitDB");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		Payment [] pmA = parse.getPayArray();
		Payment pm = pmA[1];

		em.find(Payment.class, pm);
		tx.begin();
		

		em.persist(pm);
		tx.commit();	
		em.close();
		emf.close();

	}


}
