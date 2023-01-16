package one_to_one_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import one_to_one_uni.dto.*;

public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager  entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		AadharCard aadharCard=new AadharCard();
		aadharCard.setAadharId(201);
		aadharCard.setName("Rakesh");
		aadharCard.setAddress("Bangalore");
		
		Person person=new Person();
		person.setUserId(10);
		person.setName("Rakesh.h");
		person.setPhone(98765432);
		person.setAddress("Ramnagar");
		person.setAadharCard(aadharCard);
		
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		

	}

}
