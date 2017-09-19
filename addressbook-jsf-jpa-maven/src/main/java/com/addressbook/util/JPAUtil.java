package com.addressbook.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory emf;
	
	private JPAUtil() {
		// Konstrüktöru private olan bir sınıftan,
		// başka bir sınıf new operatörü ile nesne oluşturamaz.
	}
	
	public static EntityManagerFactory geEntityManagerFactory() {
		
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return emf;
	}

	public static void shutdown() {
		if (emf != null) {
			emf.close();
		}
	}
	
}
