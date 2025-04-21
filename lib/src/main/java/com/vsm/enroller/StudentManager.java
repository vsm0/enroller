package com.vsm.enroller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Extends EnrolleeManager to add printing of students
 */
public class StudentManager extends EnrolleeManager {
	/**
	 * Prints all students' information to the console.
	 */
	public void printStudents() {
		for (Enrollee enrollee : enrollees) {
			Student s = (Student)enrollee;
			System.out.println("Name: " + s.getName());
			System.out.println("Student Number: " + s.getStudentNumber());
			System.out.println("Course: " + s.getCourseName());
			System.out.println("Year Level: " + s.getYearLevel());
			System.out.println();
		}
	}
}
