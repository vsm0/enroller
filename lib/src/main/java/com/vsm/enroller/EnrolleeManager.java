package com.vsm.enroller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Manages a list of enrollees and provides methods to add, retrieve, print, and remove enrollees.
 */
public class EnrolleeManager {
	protected List<Enrollee> enrollees;

	/**
	 * Creates a new EnrolleeManager with an empty list of enrollee.
	 */
	public EnrolleeManager() {
		this.enrollees = new ArrayList<>();
	}

	/**
	 * Adds a new enrollee to the list.
	 * @param enrollee The enrollee to add
	 */
	public void addEnrollee(Enrollee enrollee) {
		enrollees.add(enrollee);
	}

	/**
	 * Retrieves a enrollee by their enrollee ID.
	 * @param enrolleeID The enrollee ID to search for
	 * @return The found enrollee or null if not found
	 */
	public Enrollee getEnrollee(int enrolleeID) {
		for (Enrollee enrollee : enrollees)
			if (enrollee.getEnrollmentID() == enrolleeID)
				return enrollee;
		  
		return null;
	}

	/**
	 * Removes a enrollee from the list by their enrollee number.
	 * @param enrolleeID The enrollee ID to remove
	 */
	public void removeEnrollee(int enrolleeID) {
		enrollees.removeIf(enrollee -> enrollee.getEnrollmentID() == enrolleeID);
	}
}
