package com.vsm.enroller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentManager {
	private List<Student> students;

	public StudentManager() {
		this.students = new ArrayList<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public Student getStudent(int studentNumber) {
		for (Student student : students)
			if (student.getStudentNumber() == studentNumber)
				return student;
		  
		return null;
	}

	public void printStudents() {
		for (Student student : students) {
			System.out.println("Name: " + student.getName());
			System.out.println("Student Number: " + student.getStudentNumber());
			System.out.println("Course: " + student.getCourseName());
			System.out.println("Year Level: " + student.getYearLevel());
			System.out.println();
		}
	}

	public void removeStudent(int studentNumber) {
		students.removeIf(student -> student.getStudentNumber() == studentNumber);
	}
}
