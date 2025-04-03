package com.vsm.enroller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
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

	public Person(String name, Gender gender, int birthDay, int birthMonth, int birthYear) {
		this.name = name;
		this.gender = gender;
		this.birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
		var fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.birthday = this.birthDate.format(fmt);
	}

	public Person(String name, Gender gender, int birthDay, int birthMonth, int birthYear, String address, String email, String phone) {
		this(name, gender, birthDay, birthMonth, birthYear);
		setAddress(address);
		setEmail(email);
		setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return switch (gender) {
		case Male -> "Male";
		case Female -> "Female";
		default -> "Error";
		};
	}

	public int getAge() {
		var age = Period.between(birthDate, LocalDate.now());
		return age.getYears();
	}

	public String getBirthday() {
		return birthday;
	}

	public String getAddress() {
		return address == null ? "Unknown" : address;
	}

	public String getEmail() {
		return email == null ? "Unknown" : email;
	}

	public String getPhone() {
		return phone == null ? "Unknown" : phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean setEmail(String email) {
		if (emailPattern == null)
			emailPattern = Pattern.compile(EMAIL_PATTERN);
		var m = emailPattern.matcher(email).find();
		if (m)
			this.email = email;
		return m;
	}

	public boolean setPhone(String phone) {
		if (phonePattern == null)
			phonePattern = Pattern.compile(PHONE_PATTERN);
		var m = phonePattern.matcher(phone).find();
		if (m)
			this.phone = phone;
		return m;
	}
}
