package com.mahesh.model;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class).buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		Laptop laptop1 = new Laptop("Dell", 190000);
		Laptop laptop2 = new Laptop("Hp Compaq", 220000);
		Laptop laptop3 = new Laptop("Samsung", 520000);
		Laptop laptop4 = new Laptop("Macbook Pro", 220000);

		List<Laptop> lstlaptops1 = new ArrayList<Laptop>();
		List<Laptop> lstlaptops2 = new ArrayList<Laptop>();
		List<Laptop> lstlaptops3 = new ArrayList<Laptop>();

		lstlaptops1.add(laptop2);// hp compaq
		lstlaptops1.add(laptop4);// macbook pro
		lstlaptops1.add(laptop1);// dell

		lstlaptops2.add(laptop3);// samsung
		lstlaptops2.add(laptop4);// hp compaq

		lstlaptops3.add(laptop1);// dell
		lstlaptops3.add(laptop4);// macbook pro

		Student student1 = new Student();
		student1.setSname("John");
		student1.setLaptop(lstlaptops1);
		
		List<Student> listOfStudents1=new ArrayList<Student>();
		listOfStudents1.add(student1);
		laptop1.setStudent(listOfStudents1);
		
		Student student2 = new Student();
		student2.setSname("Ron");
		student2.setLaptop(lstlaptops2);
		
		List<Student> listOfStudents2=new ArrayList<Student>();
		listOfStudents2.add(student2);
		laptop2.setStudent(listOfStudents2);
		
		Student student3 = new Student();
		student3.setSname("Andrew");
		student3.setLaptop(lstlaptops3);

		session.save(student1);
		session.save(student2);
		session.save(student3);

		session.save(laptop1);
		session.save(laptop2);
		session.save(laptop3);
		session.save(laptop4);

		session.getTransaction().commit();

		session.evict(student1);
		session.evict(student2);
		session.evict(student3);

		session.evict(laptop1);
		session.evict(laptop2);
		session.evict(laptop3);
		session.evict(laptop4);

		System.out.println("one to many Inserted Successfully.");
	}
}
