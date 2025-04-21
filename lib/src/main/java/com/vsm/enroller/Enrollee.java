package com.vsm.enroller;

/**
 * Defines an interface for a generic enrollee in an institution and methods to uniquely describe and identify these enrollees
 */
public interface Enrollee {
	/** Get the enrollment status that describes the enrollee
	 * @return The enrollment status
	 */
	String getEnrollmentStatus();

	/** Gets the unique identifier of the enrollee
	 * @return The enrollment ID
	 */
	int getEnrollmentID();
}
