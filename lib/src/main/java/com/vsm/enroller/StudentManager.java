package com.vsm.enroller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Manages a list of students and provides methods to add, retrieve, print, and remove students.
 */
public class StudentManager {
	private List<Student> students;

	/**
	 * Creates a new StudentManager with an empty list of students.
	 */
	public StudentManager() {
		this.students = new ArrayList<>();
	}

	/**
	 * Adds a new student to the list.
	 * @param student The student to add
	 */
	public void addStudent(Student student) {
		students.add(student);
	}

	/**
	 * Retrieves a student by their student number.
	 * @param studentNumber The student number to search for
	 * @return The found student or null if not found
	 */
	public Student getStudent(int studentNumber) {
		for (Student student : students)
			if (student.getStudentNumber() == studentNumber)
				return student;
		  
		return null;
	}

	/**
	 * Prints all students' information to the console.
	 */
	public void printStudents() {
		for (Student student : students) {
			System.out.println("Name: " + student.getName());
			System.out.println("Student Number: " + student.getStudentNumber());
			System.out.println("Course: " + student.getCourseName());
			System.out.println("Year Level: " + student.getYearLevel());
			System.out.println();
		}
	}

	/**
	 * Removes a student from the list by their student number.
	 * @param studentNumber The student number to remove
	 */
	public void removeStudent(int studentNumber) {
		students.removeIf(student -> student.getStudentNumber() == studentNumber);
	}
}
