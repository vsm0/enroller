package com.vsm.enroller;

public class Course {
	enum Courses {
		BSIT,
		BSCE,
		BSEE,
	}

	public static String getName(Courses course) {
		return switch (course) {
		case BSIT -> "Information Technology";
		case BSCE -> "Civil Engineering";
		case BSEE -> "Electrical Engineering";
		default -> "Unknown";
		};
	}
}
