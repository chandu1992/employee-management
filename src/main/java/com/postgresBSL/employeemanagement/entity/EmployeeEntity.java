package com.postgresBSL.employeemanagement.entity;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mt_employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "date_of_birth")
	private Date birthdate;
	
	@Column(name = "adddress")
	private String address;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "salary")
	private float salary;
	
	private ZonedDateTime lefton;
	
	private boolean leftjob;
	
	private String department;
	
	public EmployeeEntity() {
		
	}

	public EmployeeEntity(Long id, String name, String gender, Date birthdate, String address, Date joiningDate,
			int age, float salary, ZonedDateTime lefton, boolean leftjob, String department) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.address = address;
		this.joiningDate = joiningDate;
		this.age = age;
		this.salary = salary;
		this.lefton = lefton;
		this.leftjob = leftjob;
		this.department = department;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public ZonedDateTime getLefton() {
		return lefton;
	}

	public void setLefton(ZonedDateTime lefton) {
		this.lefton = lefton;
	}

	public boolean isLeftjob() {
		return leftjob;
	}

	public void setLeftjob(boolean leftjob) {
		this.leftjob = leftjob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
