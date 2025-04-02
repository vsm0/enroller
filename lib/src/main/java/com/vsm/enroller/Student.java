package com.vsm.enroller;

import static com.vsm.enroller.Course.Courses;
import java.util.UUID;

public class Student extends Person {
	private UUID studentNumber;
	private Courses course;
	private int yearLevel;

	public Student(String name, Gender gender, int birthDay, int birthMonth, int birthYear, Courses course, int yearLevel) {
		super(name, gender, birthDay, birthMonth, birthYear);
		this.studentNumber = UUID.randomUUID();
		this.course = course;
		this.yearLevel = yearLevel;
	}

	public Student(String name, Gender gender, int birthDay, int birthMonth, int birthYear, String address, String email, String phone, Courses course, int yearLevel) {
		super(name, gender, birthDay, birthMonth, birthYear, address, email, phone);
		this.studentNumber = UUID.randomUUID();
		this.course = course;
		this.yearLevel = yearLevel;
	}

	public int getStudentNumber() {
		return studentNumber.hashCode();
	}

	public String getCourseName() {
		return Course.getName(course);
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel < 1 || yearLevel > 4 ? 1 : yearLevel;
	}
}
