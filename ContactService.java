import java.util.HashMap;
import java.util.Map;
 
/**
* Manages a collection of Contact objects.
* Provides functionality to add, delete, and update contacts.
*/
public class ContactService {
    // Map to store contacts with their IDs as keys.
    private Map<String, Contact> contacts;
 
    /**
     * Constructor for ContactService.
     * Initializes the contacts map.
     */
    public ContactService() {
        contacts = new HashMap<>();
    }
 
    /**
     * Adds a new contact to the service.
     * Validates that the contactId is unique before adding.
     *
     * @param contactId Unique identifier for the contact. Cannot be null and must not exceed 10 characters.
     * @param firstName First name of the contact. Cannot be null and must not exceed 10 characters.
     * @param lastName  Last name of the contact. Cannot be null and must not exceed 10 characters.
     * @param phone     Phone number of the contact. Must be exactly 10 digits.
     * @param address   Address of the contact. Cannot be null and must not exceed 30 characters.
     * @throws IllegalArgumentException if the contactId already exists or if any input parameter violates the constraints.
     */
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contactId, new Contact(contactId, firstName, lastName, phone, address));
    }
 
    /**
     * Deletes a contact from the service.
     * Validates that the contactId exists before deleting.
     *
     * @param contactId The ID of the contact to be deleted.
     * @throws IllegalArgumentException if the contactId does not exist.
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }
 
    /**
     * Updates the details of an existing contact.
     * Validates that the contactId exists and that the updated details adhere to constraints.
     *
     * @param contactId Unique identifier for the contact. Cannot be null and must not exceed 10 characters.
     * @param firstName New first name of the contact. Cannot be null and must not exceed 10 characters.
     * @param lastName  New last name of the contact. Cannot be null and must not exceed 10 characters.
     * @param phone     New phone number of the contact. Must be exactly 10 digits.
     * @param address   New address of the contact. Cannot be null and must not exceed 30 characters.
     * @throws IllegalArgumentException if the contactId does not exist or if any input parameter violates the constraints.
     */
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
}