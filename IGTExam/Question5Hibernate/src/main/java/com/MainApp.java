package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory=cfg.buildSessionFactory();

        Session session=factory.openSession();
 
        Transaction tx= session.beginTransaction();
 
        Employee e = new Employee();
        
        Scanner sc= new Scanner(System.in);

            System.out.println("Enter ID : ");
            int cid=sc.nextInt();        

            System.out.println("Enter First Name :");
            String cname=sc.next();

            System.out.println("Enter place  : ");
            String place=sc.next();
            
            System.out.println("Enter pan  : ");
            String pan=sc.next();

            e.setCid(cid);
            e.setCname(cname);
            e.setPlace(place);
            e.setPan(pan);


            session.save(e);
            tx.commit();

            System.out.println("Saved Succcessfully...!");
	}

}
