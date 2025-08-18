package edu.snhu.rmorgan.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testVariables_withValidInput_areSuccessful() { 
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		
		Assertions.assertAll( 
				() -> Assertions.assertTrue(contact.getID() != null && contact.getID().length() <= 10),
				() -> Assertions.assertEquals("John", contact.getFirstName()),
				() -> Assertions.assertEquals("Doe", contact.getLastName()),
				() -> Assertions.assertEquals("1234567890", contact.getPhone()),
				() -> Assertions.assertEquals("123 Street St.", contact.getAddress())
				);
	}
	
	@Test
	void testVariables_withNullValues_throwsIllegalArgumentException() {
		Assertions.assertAll( 
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact(null, "John", "Doe", "1234567890", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", null, "Doe", "1234567890", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "John", null, "1234567890", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "John", "Doe", null, "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "John", "Doe", "1234567890", null))
				);
	}
	
	@Test
	void testVariables_withLongValues_throwsIllegalArgumentException() {
		Assertions.assertAll( 
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("12345678901", "John", "Doe", "1234567890", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "JohnnyJohnJohn", "Doe", "1234567890", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "John", "DoeyDoeDoeDoe", "1234567890", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "John", "Doe", "12345678901", "123 Street St.")),
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> 
				new Contact("1", "John", "Doe", "1234567890", "1234567890 StreetStreetStreet St.St.St."))				
				);
	}
	
	@Test
	void testPhone_withNonDigits_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		new Contact("1", "John", "Doe", "aB%$!*#&)", "123 Street St."));
	}

	@Test
	void test_equalsOverride_comparesFields_sameObject() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Assertions.assertEquals(contact, contact);
	}

	@Test
	void test_equalsOverride_comparesFields_differentObject() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Assertions.assertEquals(contact1, contact2);
	}
	@Test
	void test_equalsOverride_nullValues_fails() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Assertions.assertNotEquals(contact, null);
	}

	@Test
	void test_equalsOverride_differentID_fails() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("2", "John", "Doe", "1234567890", "123 Street St.");
		Assertions.assertNotEquals(contact1, contact2);
	}

	@Test
	void test_equalsOVerride_differentFirstNames_fails() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("1", "Jane", "Doe", "1234567890", "123 Street St.");
		Assertions.assertNotEquals(contact1, contact2);
	}

	@Test
	void test_equalsOverride_differentLastNames_fails() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("1", "John", "Dough", "1234567890", "123 Street St.");
		Assertions.assertNotEquals(contact1, contact2);
	}
	
	@Test
	void test_equalsOverride_differentPhones_fails() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("1", "John", "Doe", "1234567891", "123 Street St.");
		Assertions.assertNotEquals(contact1, contact2);
	}
	
	@Test
	void test_equalsOverride_differentAddresses_fails() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("1", "John", "Doe", "1234567890", "456 Street St.");
		Assertions.assertNotEquals(contact1, contact2);
	}

	@Test
	void test_hashcodeOverride_areEqual() {
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Contact contact2 = new Contact("1", "John", "Doe", "1234567890", "123 Street St.");
		Assertions.assertEquals(contact1.hashCode(), contact2.hashCode());
	}
}
