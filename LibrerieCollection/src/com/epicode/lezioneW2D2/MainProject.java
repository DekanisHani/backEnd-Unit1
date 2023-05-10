package com.epicode.lezioneW2D2;


import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
    static Logger log = LoggerFactory.getLogger(MainProject.class);
    
	public static void main(String[] args) {
		
		
		log.info("Test Logger!!");
		log.error("Test Error!!");
		log.warn("Test Warning!!");
		log.debug("Test Debug");
		
		testCollection();

	}
	
	public static void testCollection() {
		Collection<String> c = new ArrayList<String>();
		//Collection<Integer> c = new ArrayList<String>();
		
		c.add("Primo Elemento");
		c.add("Secondo Elemento");
		c.add("Terzo Elemento");
		
		boolean cont = c.contains("Secondo Elemento");
		log.info("Contains 'Secondo elemento': " + cont);
		
		boolean isEmp = c.isEmpty();
		log.info("Collection isEmpty: " + isEmp);
		
		int size = c.size();
		log.info("Collection size: " + size);
		
		c.forEach(e -> log.info(e));
		
		c.remove("Primo Elemento"); //rimuove un elemento
		c.clear(); //rimuove tutti gli elementi dalla collection
	}

}
