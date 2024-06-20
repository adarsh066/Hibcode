package in.codegram.hibarnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.codegram.hibarnate.model.Address;
import in.codegram.hibarnate.model.Employee;

public class ApplicationTest {

	public static void main(String[] args) {

		Address address1 = new Address();
		address1.setHouseno("65");
		address1.setCity("Nagpur");
		address1.setState("Maharastra");
		address1.setZip("12345");

		Address address2 = new Address();
		address2.setHouseno("45");
		address2.setCity("Pune");
		address2.setState("Maharastra");
		address2.setZip("1245455");

		Employee employee1;

		employee1 = new Employee();
		employee1.setName("Aniket");
		employee1.setSalary(15000);

		employee1.getListOfAddreses().add(address1);
		employee1.getListOfAddreses().add(address2);

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
