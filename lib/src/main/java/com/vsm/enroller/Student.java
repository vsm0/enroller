package com.vsm.enroller;

import static com.vsm.enroller.Course.Courses;
import java.util.UUID;

/**
 * Represents a student with course and academic information.
 */
public class Student extends Person implements Enrollee {
	private UUID studentNumber;
	private Courses course;
	private int yearLevel;

	/**
	 * Creates a new Student with basic information.
	 * @param name The student's name
	 * @param gender The student's gender
	 * @param birthDay The day of birth
	 * @param birthMonth The month of birth
	 * @param birthYear The year of birth
	 * @param course The student's course
	 * @param yearLevel The student's year level
	 */
	public Student(String name, Gender gender, int birthDay, int birthMonth, int birthYear, Courses course, int yearLevel) {
		super(name, gender, birthDay, birthMonth, birthYear);
		this.studentNumber = UUID.randomUUID();
		this.course = course;
		this.yearLevel = yearLevel;
	}

	/**
	 * Creates a new Student with full information.
	 * @param name The student's name
	 * @param gender The student's gender
	 * @param birthDay The day of birth
	 * @param birthMonth The month of birth
	 * @param birthYear The year of birth
	 * @param address The student's address
	 * @param email The student's email address
	 * @param phone The student's phone number
	 * @param course The student's course
	 * @param yearLevel The student's year level
	 */
	public Student(String name, Gender gender, int birthDay, int birthMonth, int birthYear, String address, String email, String phone, Courses course, int yearLevel) {
		super(name, gender, birthDay, birthMonth, birthYear, address, email, phone);
		this.studentNumber = UUID.randomUUID();
		this.course = course;
		this.yearLevel = yearLevel;
	}

	/**
	 * Prints the students course and year
	 */
	public void showRole() {
		System.out.printf("I am a student in %s, year %d\n", getCourseName(), getYearLevel());
	}

	/**
	 * Gets the student course and year
	 * @return The course and year as enrollment status
	 */
	public String getEnrollmentStatus() {
		return String.format("Student #%d; %s, YR %d", getStudentNumber(), getCourseName(), getYearLevel());
	}

	/**
	 * Gets the enrollee's unique id
	 * @return The student number
	 */
	public int getEnrollmentID() {
		return getStudentNumber();
	}

	/**
	 * Gets the student's unique identifier.
	 * @return The student number as an integer
	 */
	public int getStudentNumber() {
		return studentNumber.hashCode();
	}

	/**
	 * Gets the student's course name.
	 * @return The full course name
	 */
	public String getCourseName() {
		return Course.getName(course);
	}

	/**
	 * Gets the student's year level.
	 * @return The year level (1-4)
	 */
	public int getYearLevel() {
		return yearLevel;
	}

	/**
	 * Sets the student's course.
	 * @param course The course to set
	 */
	public void setCourse(Courses course) {
		this.course = course;
	}

	/**
	 * Sets the student's year level with validation.
	 * @param yearLevel The year level to set (1-4)
	 */
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel < 1 || yearLevel > 4 ? 1 : yearLevel;
	}
}
