package com.example.exercise17_2;


public class StudentService {
	private StudentDAO studentdao;

	public StudentService()
	{
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		Student student=studentdao.load(studentid);
		return student;
	}
}
