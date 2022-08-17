package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.FoodOrder;
import com.ty.dto.Item;

public class TestSaveFoodOrder {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Item i1 = new Item();
		i1.setName("Paneer");
		i1.setQty(2);
		i1.setCost(250);

		Item i2 = new Item();
		i2.setName("Mushrooms");
		i2.setQty(3);
		i2.setCost(500);

		Item i3 = new Item();
		i3.setName("Chicken Kabab");
		i3.setCost(750);
		i3.setQty(5);

		List<Item> list = new ArrayList<Item>();
		list.add(i1);
		list.add(i2);
		list.add(i3);

		FoodOrder fod = new FoodOrder();
		fod.setCustomerName("Khumbakaran");
		fod.setAddress("Lanka");
		fod.setPhone(7894561230l);
		fod.setItems(list);

		transaction.begin();
		manager.persist(fod);
		manager.persist(i1);
		manager.persist(i2);
		manager.persist(i3);

		transaction.commit();
	}
}
