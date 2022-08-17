package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Bus;
import com.ty.dto.Organization;

public class TestSaveOrganization {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Organization org = new Organization();
		org.setName("KSRTC");
		org.setAddress("Karnataka");
		
		Bus b1 = new Bus();
		b1.setCapacity(80);
		b1.setType("AC");
		
		Bus b2 = new Bus();
		b2.setCapacity(120);
		b2.setType("Ordinary");
		
		Bus b3 = new Bus();
		b3.setCapacity(50);
		b3.setType("Deluxe");
		
		List<Bus> list = new ArrayList<Bus>(); 
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		org.setBus(list);
		
		
		transaction.begin();
		manager.persist(org);
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		System.out.println("Done !!!");
		transaction.commit();
		
	}

}
