package com.school.portal.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.portal.pojo.Batch;
import com.school.portal.pojo.Course;
//import com.school.portal.pojo.Student;
import com.school.portal.pojo.Teacher;
import com.school.portal.utils.HibernateConfigurations;


public class TestingClient {
	public static void main(String[] args) {
		
		Transaction tx = null;
		try {
			
			SessionFactory sf= HibernateConfigurations.getSessionFactory();
			Session session= sf.openSession();
			tx = session.beginTransaction();
			
						
			Batch b1 = new Batch("Batch-C");
			session.save(b1);
			
//			Batch b2 = new Batch("Batch-B");
//			session.save(b2);
//			
//			
//			Set<Batch> batches = new HashSet<Batch>();
//			batches.add(b1);
//			batches.add(b2);
//			
//			
//			Teacher teacher1 = new Teacher("Sandra");
//			session.save(teacher1);
//			
//			Teacher teacher2 = new Teacher("Ahmad");
//			session.save(teacher2);
//			
//			Course c1 = new Course("HRM112", "Introduction to Human Resources", batches, teacher1 );
//			session.save(c1);

			

			

			
			tx.commit();
			session.close();
			
			
		} catch (Exception e) {

			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}
}
	
}

