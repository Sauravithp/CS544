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
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		Student student=studentdao.load(studentid);
		return student;
	}
}
