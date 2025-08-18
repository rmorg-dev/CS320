package edu.snhu.rmorgan.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class ContactServiceTest {
	
	 @Test
	 void test_AddContact() {
		 ContactService contactService = new ContactService();
		 Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		 contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		 Assertions.assertEquals(contact, contactService.getContact("1"));
	 }
	
	@Test void test_AddContact_MultipleElements() {
		 ContactService contactService = new ContactService();
		 Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		 Contact contact2 = new Contact("2", "John", "Doe", "1234567890", "123 Street St.");
		 Contact contact3 = new Contact("3", "John", "Doe", "1234567890", "123 Street St.");
		 contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		 contactService.addContact("2", "John", "Doe", "1234567890", "123 Street St.");
		 contactService.addContact("3", "John", "Doe", "1234567890", "123 Street St.");
		 Assertions.assertAll( 
				 () ->  Assertions.assertEquals(contact1, contactService.getContact("1")),
				 () ->  Assertions.assertEquals(contact2, contactService.getContact("2")),
				 () ->  Assertions.assertEquals(contact3, contactService.getContact("3"))
				 );
	}
	
	@Test void test_AddContact_DuplicateID() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		});
	}
	@Test
	void test_DeleteContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.deleteContact("1");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContact("1");
		});
	}
	
	@Test
	void test_DeleteContact_InvalidID() {
		ContactService contactService = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("1"));
	}
	
	@Test
	void test_UpdateFirstName() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updateFirstName("1", "Jane");
		Assertions.assertEquals("Jane", contactService.getContact("1").getFirstName());
	}
	
	@Test
	void test_UpdateFirstName_InvalidID() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updateFirstName("1", "Jane");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("2", "Jane");
		});
	}
	
	@Test
	void test_UpdateLastName() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updateLastName("1", "Dough");
		Assertions.assertEquals("Dough", contactService.getContact("1").getLastName());
	}
	
	@Test
	void test_UpdateLastName_InvalidID() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updateLastName("1", "Jane");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName("2", "Jane");
		});
	}
	
	@Test
	void test_UpdatePhone() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updatePhone("1", "5554441111");
		Assertions.assertEquals("5554441111", contactService.getContact("1").getPhone());
	}
	
	@Test
	void test_UpdatePhone_InvalidID() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updatePhone("1", "1234567891");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("2", "1234567891");
		});
	}

	@Test
	void test_UpdateAddress() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updateAddress("1", "321 Street St.");
		Assertions.assertEquals("321 Street St.", contactService.getContact("1").getAddress());
	}
	
	@Test
	void test_UpdateAddress_InvalidID() {
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Doe", "1234567890", "123 Street St.");
		contactService.updateAddress("1", "456 Street St.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress("2", "456 Street St.");
		});
	}
}
