package com;

import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.hsqldb.lib.HashMap;
import org.hsqldb.lib.HashSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e = (Employee)context.getBean("emp");
		e.display();
		String[] hb = e.getProgramming();
		
		System.out.println("===================");
		for (String s : hb) {
			System.out.println("   " +s);

		}
	}

}
