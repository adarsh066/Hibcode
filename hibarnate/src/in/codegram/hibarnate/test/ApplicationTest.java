package in.codegram.hibarnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.codegram.hibarnate.model.Employee;

public class ApplicationTest {

	public static void main(String[] args) {

//		Employee employee1;
//
//		employee1 = new Employee();
//		employee1.setName("Aniket");
//		employee1.setSalary(15000);
//		employee1.setCtc(employee1.getSalary()+100);

//		1.Session Factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		2.get a session object form factory
		Session session = sessionFactory.openSession();
//		3.begin the transaction
		session.beginTransaction();
//		4.perform transaction
		Employee employee = (Employee) session.get(Employee.class, 3);
//		5.Complete transaction
		session.getTransaction().commit();
//		6.Close session
		session.close();

		System.out.println("Employee details as below");
		System.out.println(employee);

	}

}
