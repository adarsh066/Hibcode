package in.codegram.hibarnate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "emp_name")

	private String name;
	private double salary;

	@Embedded
	private Address homeAddress; // houseno , city , state , zip

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "houseno", column = @Column(name = "office_houseno")),
			@AttributeOverride(name = "city", column = @Column(name = "office_city")),
			@AttributeOverride(name = "state", column = @Column(name = "office_state")),
			@AttributeOverride(name = "zip", column = @Column(name = "office_zip")), })
	
	private Address officeAddress;//office_houseno , office_city , office_state , office_zip

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + "]";
	}

}
