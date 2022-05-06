package com.example.exercise16_2;

import com.example.exercise16_2.utils.HibernateUtils;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StudentDAO {


	public StudentDAO() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.setCourses(Arrays.asList(course1,course2));
		HibernateUtils.getSessionFactory().getCurrentSession().save(student);

	}

	public Student load(long studentid) {
		List<Student> studentList=	HibernateUtils.getSessionFactory()
				.getCurrentSession().createQuery("SELECT a FROM Student a ").getResultList();

		for (Student student : studentList) {
			if (student.getStudentid() == studentid) {
				return student;
			}
		}
		return null;
	}
}
