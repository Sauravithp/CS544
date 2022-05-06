package com.example.exercise16_2;

import com.example.exercise16_2.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;

public class StudentService {
	private StudentDAO studentdao;
	private SessionFactory sessionFactory= HibernateUtils.getSessionFactory();

	public StudentService()
	{
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		studentdao = new StudentDAO();
		tx.commit();
	}

	public Student getStudent(long studentid) {
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		Student student=studentdao.load(studentid);
		tx.commit();
		return student;
	}
}
