package one_to_one_uni.controller;

import java.util.List;
import java.util.Scanner;

import one_to_one_uni.dao.PersonDao;
import one_to_one_uni.dto.AadharCard;
import one_to_one_uni.dto.Person;

public class PersonMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		do {

			System.out.println("Enter your choice");
			System.out.println("1.Save Person Details");
			System.out.println("2.Update Person Details");
			System.out.println("3.Delete Person Details");
			System.out.println("4.Fetch Person Details by ID ");
			System.out.println("5.Fetch All Person Details");
			System.out.println("6.Exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1: {

				System.out.println("Enter your id");
				int id = sc.nextInt();
				System.out.println("Enter your Name");
				String name = sc.next();
				System.out.println("Enter your Phone number");
				long number = sc.nextLong();
				System.out.println("Enter your Address");
				String address = sc.next();
				Person person = new Person();
				AadharCard aadharCard = new AadharCard();
				person.setUserId(id);
				person.setName(name);
				person.setPhone(number);
				person.setAddress(address);
				person.setAadharCard(aadharCard);

				System.out.println("Enter your AadharId");
				int aid = sc.nextInt();
				System.out.println("Enter your Aadhar name");
				String aname = sc.next();
				System.out.println("Enter your Address");
				String address1 = sc.next();

				aadharCard.setAadharId(aid);
				aadharCard.setName(aname);
				aadharCard.setAddress(address1);
				PersonDao personDao = new PersonDao();
				personDao.savePerson(person);

			}
				break;
			case 2: {
				Person person = new Person();
				AadharCard aadharCard = new AadharCard();
				PersonDao personDao = new PersonDao();

				System.out.println("Enter your id");
				int id = sc.nextInt();
				System.out.println("Enter your Name");
				String name = sc.next();
				person.setUserId(id);
				person.setName(name);
				personDao.updatePerson(id, name);
				aadharCard.setAadharId(id);

			}
				break;
			case 3: {
				Person person = new Person();
				AadharCard aadharCard = person.getAadharCard();
				PersonDao personDao = new PersonDao();
				

				System.out.println("Enter your id to be Deleted");
				int id = sc.nextInt();

				person.setUserId(id);
				personDao.deletePerson(id);
				 

			}
				break;
			case 4: {
				Person person = new Person();
				AadharCard aadharCard = new AadharCard();
				PersonDao personDao = new PersonDao();

				System.out.println("Enter the id to be fetched");
				int id = sc.nextInt();

				person.setUserId(id);
				Person person1=personDao.findPersonById(id);
				System.out.println(person1);

			}
				break;
			case 5: {

				PersonDao personDao = new PersonDao();

				List<Person> list = personDao.findPersonAll();
				System.out.println(list);

			}
				break;
			case 6: {
				System.out.println("*****Thank You*****");
				repeat = false;
			}

			}

		} while (repeat );
	}
}
