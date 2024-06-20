package in.codegram.hibarnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.codegram.hibarnate.model.Address;
import in.codegram.hibarnate.model.Employee;

public class ApplicationTest {

	public static void main(String[] args) {

		Address address = new Address();
		address.setHouseno("65");
		address.setCity("Nagpur");
		address.setState("Maharastra");
		address.setZip("12345");

		Employee employee1;

		employee1 = new Employee();
		employee1.setName("Aniket");
		employee1.setSalary(15000);
		employee1.setAddress(address);

//		1.Session Factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		2.get a session object form factory
		Session session = sessionFactory.openSession();
//		3.begin the transaction
		session.beginTransaction();
//		4.perform transaction
		session.save(employee1);
//		5.Complete transaction
		session.getTransaction().commit();
//		6.Close session
		session.close();

	}

}
