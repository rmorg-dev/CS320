package edu.snhu.rmorgan.project;

import java.util.Objects;

public class Contact {
	private final String ID; //getter only.
	private String firstName; //getter & setter.
	private String lastName; //getter & setter.
	private String phone; //getter & setter.
	private String address; //getter & setter.
	
public Contact(String ID, String firstName, String lastName, String phone, String address) {
	if (ID == null || ID.length() > 10) {
		throw new IllegalArgumentException("ID capacity reached or ID value is null.");
	}
	else {
	this.ID = ID;
	}
	setFirstName(firstName);
	setLastName(lastName);
	setPhone(phone);
	setAddress(address);
}
	
public String getID() {
	return this.ID;
}
	
public String getFirstName() {
	return this.firstName;
}
	
public void setFirstName(String firstName) {
	if (firstName == null || firstName.length() > 10 ) {
		throw new IllegalArgumentException("first Name cannot be over 10 characters and must have a value.");
	}
	else {
		this.firstName = firstName;
	}
}
	
public String getLastName() {
	return this.lastName;
}
	
public void setLastName(String lastName) {
	if (lastName == null || lastName.length() > 10) {
		throw new IllegalArgumentException("last Name cannot be over 10 characters and must have a value.");
	}
	else {
		this.lastName = lastName;
	}
}
	
public String getPhone() {
	return this.phone;
}
	
public void setPhone(String phone) {
	if (phone == null || phone.length() != 10 || phone.matches("^[0-9]+$") == false) {
		throw new IllegalArgumentException("the phone number must be exactly 10 digits with no alphabetical characters and must have a value.");
	}
	else {
		this.phone = phone;
	}
}
	
public String getAddress() {
	return this.address;
}
	
public void setAddress(String address) {
	if (address == null || address.length() > 30) {
		throw new IllegalArgumentException("the address cannot be over 30 characters and must have a value.");
	}
	else {
	this.address = address;
	}
}

@Override
public boolean equals(Object o) { //need to override the equals method for objects in order for it to compare against the fields, not the memory reference.
	if (this == o) {
		return true;
	}
	if (o == null || getClass() != o.getClass()) {
		return false;
	}
	Contact contact = (Contact) o;
	return Objects.equals(ID, contact.ID) && Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phone, contact.phone) && Objects.equals(address, contact.address);
}

@Override
public int hashCode() { //even though it isn't used because I am using an ArrayList data structure in TaskService, it is good practice to override the hashCode as well since equals and hashCode go hand in hand.
	return Objects.hash(ID, firstName, lastName, phone, address);
}
	
}


