package one_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni.dto.AadharCard;
import one_to_one_uni.dto.Person;

public class PersonDao {
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void savePerson(Person person)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		AadharCard aadharCard=person.getAadharCard();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	public void updatePerson(int id,String name)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		person.setName(name);
		
		entityTransaction.begin();
		AadharCard aadharCard=person.getAadharCard();
		entityManager.merge(aadharCard);
		entityManager.merge(person);
		entityTransaction.commit();
	}
	public void deletePerson(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		if(person !=null)
		{
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(person.getAadharCard());
			entityTransaction.commit();
			
		}
		
	}
	public Person findPersonById(int id)
	{
		EntityManager entityManager=getEntityManager();
		
		Person person=entityManager.find(Person.class, id);
		
		return person;
			
	}
	public List<Person> findPersonAll()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("SELECT p FROM Person p");
		List<Person> list=query.getResultList();
		return list;
		
		
	}
	
	

}
