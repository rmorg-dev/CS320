package edu.snhu.rmorgan.project;

import java.util.ArrayList;

public class ContactService {
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	
public void addContact(String ID, String firstName, String lastName, String phone, String address) {
	Contact contact = new Contact(ID, firstName, lastName, phone, address);
	boolean idAlreadyInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String idInList = contacts.get(i).getID();
		if (ID.equals(idInList)) {
			idAlreadyInList = true;
			throw new IllegalArgumentException("ID already in List");
		}
	}
	if (!idAlreadyInList) {
		contacts.add(contact);
	}
}

public void deleteContact(String ID) {
	boolean idInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String id = contacts.get(i).getID();
		if (ID.equals(id)) {
			idInList = true;
			contacts.remove(i);
			break;
		}
		else {
			continue;
		}
	}
	if (!idInList) {
		throw new IllegalArgumentException("ID not found in list.");
	}
}

public Contact getContact(String ID) {
	boolean idInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String id = contacts.get(i).getID();
		if (ID.equals(id)) {
			idInList = true;
			return contacts.get(i);
		}
		else {
			continue;
		}
	}
	throw new IllegalArgumentException("ID not found in list.");
}
public void updateFirstName(String ID, String newName) {
	boolean idInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String id = contacts.get(i).getID();
		if (ID.equals(id)) {
			idInList = true;
			contacts.get(i).setFirstName(newName);
			break;
		}
		else {
			continue;
		}
	}
	if (!idInList) {
		throw new IllegalArgumentException("ID not found in list.");
	}
}

public void updateLastName(String ID, String newLastName) {
	boolean idInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String id = contacts.get(i).getID();
		if (ID.equals(id)) {
			idInList = true;
			contacts.get(i).setLastName(newLastName);
			break;
		}
		else {
			continue;
		}
	}
	if (!idInList) {
		throw new IllegalArgumentException("ID not found in list.");
	}
}

public void updatePhone(String ID, String newPhone) {
	boolean idInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String id = contacts.get(i).getID();
		if (ID.equals(id)) {
			idInList = true;
			contacts.get(i).setPhone(newPhone);
			break;
		}
		else {
			continue;
		}
	}
	if (!idInList) {
		throw new IllegalArgumentException("ID not found in list.");
	}
}

public void updateAddress(String ID, String newAddress) {
	boolean idInList = false;
	for (int i = 0; i < contacts.size(); i++) {
		String id = contacts.get(i).getID();
		if (ID.equals(id)) {
			idInList = true;
			contacts.get(i).setAddress(newAddress);
			break;
		}
		else {
			continue;
		}
	}
	if (!idInList) {
		throw new IllegalArgumentException("ID not found in list.");
	}
}
}
