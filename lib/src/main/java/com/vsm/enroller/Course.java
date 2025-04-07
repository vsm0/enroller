package com.vsm.enroller;

/**
 * Represents the Course class which holds course constants and related methods.
 */
public class Course {
	/**
   * Enum representing available courses.
	 */
	public enum Courses {
		BSIT,
		BSCE,
		BSEE,
	}

	/**
	 * Gets the full name of a course.
	 * @param course The course enum value
	 * @return The full name of the course or "Unknown" if not found
	 */
	public static String getName(Courses course) {
		return switch (course) {
		case BSIT -> "Information Technology";
		case BSCE -> "Civil Engineering";
		case BSEE -> "Electrical Engineering";
		default -> "Unknown";
		};
	}
}
