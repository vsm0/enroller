package com.vsm.enroller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a person with basic information.
 */
public abstract class Person {
	/**
	 * Enum representing gender types.
	 */
	public enum Gender {
		Male,
		Female
	}
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	private static final String PHONE_PATTERN = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";

	protected String name;
	protected Gender gender;
	private LocalDate birthDate;
	private String birthday;
	private String address;
	private String email;
	private String phone;
	private static Pattern emailPattern;
	private static Pattern phonePattern;

	/**
	 * Creates a new Person with basic information.
	 * @param name The person's name
	 * @param gender The person's gender
	 * @param birthDay The day of birth
	 * @param birthMonth The month of birth
	 * @param birthYear The year of birth
	 */
	public Person(String name, Gender gender, int birthDay, int birthMonth, int birthYear) {
		this.name = name;
		this.gender = gender;
		this.birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
		var fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.birthday = this.birthDate.format(fmt);
	}

	/**
	 * Creates a new Person with full information.
	 * @param name The person's name
	 * @param gender The person's gender
	 * @param birthDay The day of birth
	 * @param birthMonth The month of birth
	 * @param birthYear The year of birth
	 * @param address The person's address
	 * @param email The person's email address
	 * @param phone The person's phone number
	 */
	public Person(String name, Gender gender, int birthDay, int birthMonth, int birthYear, String address, String email, String phone) {
		this(name, gender, birthDay, birthMonth, birthYear);
		setAddress(address);
		setEmail(email);
		setPhone(phone);
	}

	/**
	 * Gets the person's name.
	 * @return The person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the person's gender as a string.
	 * @return The gender as a string ("Male", "Female", or "Error")
	 */
	public String getGender() {
		return switch (gender) {
		case Male -> "Male";
		case Female -> "Female";
		default -> "Error";
		};
	}

	/**
	 * Gets the person's age.
	 * @return The person's age
	 */
	public int getAge() {
		var age = Period.between(birthDate, LocalDate.now());
		return age.getYears();
	}

	/**
	 * Gets the person's birthday in dd/MM/yyyy format.
	 * @return The birthday string
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Gets the person's address.
	 * @return The address or "Unknown" if not set
	 */
	public String getAddress() {
		return address == null ? "Unknown" : address;
	}

	/**
	 * Gets the person's email address.
	 * @return The email address or "Unknown" if not set
	 */
	public String getEmail() {
		return email == null ? "Unknown" : email;
	}

	/**
	 * Gets the person's phone number.
	 * @return The phone number or "Unknown" if not set
	 */
	public String getPhone() {
		return phone == null ? "Unknown" : phone;
	}

	/**
	 * Sets the person's address.
	 * @param address The address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Prints the person's role
	 */
	public abstract void showRole();

	/**
	 * Sets the person's email address if it matches the valid format.
	 * @param email The email address to set
	 * @return true if the email is valid and set, false otherwise
	 */
	public boolean setEmail(String email) {
		if (emailPattern == null)
			emailPattern = Pattern.compile(EMAIL_PATTERN);
		var m = emailPattern.matcher(email).find();
		if (m)
			this.email = email;
		return m;
	}

	/**
	 * Sets the person's phone number if it matches the valid format.
	 * @param phone The phone number to set
	 * @return true if the phone number is valid and set, false otherwise
	 */
	public boolean setPhone(String phone) {
		if (phonePattern == null)
			phonePattern = Pattern.compile(PHONE_PATTERN);
		var m = phonePattern.matcher(phone).find();
		if (m)
			this.phone = phone;
		return m;
	}
}
