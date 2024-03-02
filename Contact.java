public class Contact {
    private final String contactId; // Unique and immutable identifier for the contact
    private String firstName;       // First name of the contact
    private String lastName;        // Last name of the contact
    private String phone;           // Phone number of the contact
    private String address;         // Address of the contact

    /**
     * Constructor for creating a new Contact instance.
     * Validates and initializes contact details according to the specified constraints.
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be non-null, non-empty and cannot exceed 10 characters");
        }
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be non-null, non-empty and cannot exceed 10 characters");
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be non-null, non-empty and cannot exceed 10 characters");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be non-null and exactly 10 digits");
        }
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null, non-empty and cannot exceed 30 characters");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
 
    // Getter methods for each field
 
    public String getContactId() {
        return contactId;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public String getAddress() {
        return address;
    }
 
    // Setter methods for fields that can be modified
 
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be non-null, non-empty and cannot exceed 10 characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be non-null, non-empty and cannot exceed 10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be non-null and exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null, non-empty and cannot exceed 30 characters");
        }
        this.address = address;
    }
}