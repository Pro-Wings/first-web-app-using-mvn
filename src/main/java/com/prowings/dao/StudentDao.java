package com.prowings.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prowings.entity.Student;
import com.prowings.util.HibernateUtil;

public class StudentDao {
	
	public Student saveStudent(Student s)
	{
		Session session = HibernateUtil.getSession();
		Transaction txn = session.beginTransaction();
		session.save(s);
		txn.commit();
		session.close();

		return s;
	}

}
