package com.csi.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {

		saveProductData();
		updateProductData(1);
		deleteProductData(1);
		getProductData();
	}

	public static void saveProductData() {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product p1 = new Product();
		p1.setProductName("MI SMART TV");
		p1.setProductPrice(456546.89);
		session.save(p1);
		transaction.commit();
	}

	public static void getProductData() {

		Session session = factory.openSession();
		List<Product> productList = session.createQuery("from Product").list();
		productList.forEach(System.out::println);
	}

	public static void updateProductData(int productId) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Product> pList = session.createQuery("from Product").list();
		for (Product product : pList) {
			if (product.getProductId() == productId) {
				product.setProductName("LENOVO LAPTOP");
				product.setProductPrice(1111.99);
				session.update(product);
				transaction.commit();
			}
		}
	}

	public static void deleteProductData(int productId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Product> pList = session.createQuery("from Product").list();
		for (Product product : pList) {
			if (product.getProductId() == productId) {

				session.delete(product);
				transaction.commit();
			}
		}
	}
	
	public static void deleteAllData()
	{
		
	}
}
