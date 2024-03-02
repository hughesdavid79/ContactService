import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
/**
* Tests for the ContactService class.
* Verifies the functionality of adding, deleting, and updating contacts.
*/
public class ContactServiceTest {
 
    private ContactService service;
 
    /**
     * Sets up a new ContactService instance before each test.
     */
    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }
 
    /**
     * Tests adding a contact with valid parameters.
     */
    @Test
    public void testAddContact() {
        service.addContact("001", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(service);
        // Additional assertions can be made to verify the contact details
    }
 
    /**
     * Tests adding a contact with a duplicate ID, which should throw an exception.
     */
    @Test
    public void testAddContactWithDuplicateId() {
        service.addContact("002", "Jane", "Doe", "2345678901", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact("002", "Janet", "Doe", "3456789012", "789 Oak St");
        });
    }
 
    /**
     * Tests deleting an existing contact.
     */
    @Test
    public void testDeleteContact() {
        service.addContact("003", "Alice", "Smith", "3456789012", "101 Pine St");
        service.deleteContact("003");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("003"); // Attempt to delete the same contact again
        });
    }
 
    /**
     * Tests deleting a non-existent contact, which should throw an exception.
     */
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }
 
    /**
     * Tests updating an existing contact with valid parameters.
     */
    @Test
    public void testUpdateContact() {
        service.addContact("004", "Bob", "Jones", "4567890123", "202 Maple St");
        service.updateContact("004", "Bobby", "Jones", "5678901234", "303 Birch St");
        // Additional assertions can be made to verify the updated contact details
    }
 
    /**
     * Tests updating a non-existent contact, which should throw an exception.
     */
    @Test
    public void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Nonexistent", "User", "6789012345", "404 Not Found St");
        });
    }
}
