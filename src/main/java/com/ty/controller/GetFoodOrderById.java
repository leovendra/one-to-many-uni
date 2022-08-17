package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.FoodOrder;
import com.ty.dto.Item;

public class GetFoodOrderById {

	public static void main(String[] args) throws InterruptedException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Food Order Id : ");
		int id = sc.nextInt();

		FoodOrder fod = manager.find(FoodOrder.class, id);
		if (fod != null) {
			System.out.println(fod.getId());
			System.out.println(fod.getCustomerName());
			System.out.println(fod.getPhone());
			System.out.println(fod.getAddress());

			System.out.println("-------------------------------------");
			Thread.sleep(2000);

			List<Item> li = fod.getItems();
			for (Item i : li) {
				System.out.println(i);
			}
		}
	}
}
