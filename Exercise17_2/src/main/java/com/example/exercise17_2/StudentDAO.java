package com.example.exercise17_2;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

public class StudentDAO {

	private SessionFactory sf;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
	}

	public StudentDAO(){
		save();
	}

	@Transactional(propagation= Propagation.REQUIRES_NEW)
	public void save() {
		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.setCourselist(Arrays.asList(course1,course2));
		sf.getCurrentSession().save(student);
	}

	public Student load(long studentid) {
		List<Student> studentList=	sf.getCurrentSession().createQuery("SELECT DISTINCT a FROM Student a")
				.getResultList();
		for (Student student : studentList) {
			if (student.getStudentid() == studentid) {
				return student;
			}
		}
		return null;
	}
}
