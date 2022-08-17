package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Mobile;
import com.ty.dto.Sim;

public class TestMobileSave {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setImrc("987EDFN");
		
		Sim sim2 = new Sim();
		sim2.setProvider("JIO");
		sim2.setImrc("48ABCT");
		
		List<Sim> all = new ArrayList<Sim>();
		all.add(sim1);
		all.add(sim2);
		
		
		Mobile mobile = new Mobile();
		mobile.setName("Pixel");
		mobile.setCost(63000);
		mobile.setSims(all);
		
		
		transaction.begin();
		
		manager.persist(mobile);
		manager.persist(sim1);
		manager.persist(sim2);
		transaction.commit();
	}

}
