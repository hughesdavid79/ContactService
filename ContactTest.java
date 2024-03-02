import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        // Setup with valid parameters
        contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void shouldCreateContactWithValidParameters() {
        assertNotNull(contact);
        assertAll("Verify all properties",
            () -> assertEquals("001", contact.getContactId()),
            () -> assertEquals("John", contact.getFirstName()),
            () -> assertEquals("Doe", contact.getLastName()),
            () -> assertEquals("1234567890", contact.getPhone()),
            () -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    @Test
    public void shouldThrowExceptionForNullContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertTrue(exception.getMessage().contains("Contact ID must be non-null"));
    }

    @Test
    public void shouldThrowExceptionForEmptyContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "John", "Doe", "1234567890", "123 Main St");
        }, "Contact ID must be non-empty");
    }

    @Test
    public void shouldThrowExceptionForLongContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        }, "Contact ID cannot exceed 10 characters");
    }

    @Test
    public void shouldThrowExceptionForInvalidPhoneNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("002", "John", "Doe", "12345abcde", "123 Main St");
        }, "Phone number must be exactly 10 digits");
    }

    @Test
    public void shouldThrowExceptionForEmptyFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("");
        }, "First name must be non-empty");
    }

    @Test
    public void shouldUpdateFirstNameWithinValidLength() {
        String validFirstName = "Jane";
        contact.setFirstName(validFirstName);
        assertEquals(validFirstName, contact.getFirstName());
    }

    @Test
    public void shouldThrowExceptionForLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("LongFirstName");
        }, "First name cannot exceed 10 characters");
    }

    @Test
    public void shouldUpdateLastNameWithinValidLength() {
        String validLastName = "Smith";
        contact.setLastName(validLastName);
        assertEquals(validLastName, contact.getLastName());
    }

    @Test
    public void shouldThrowExceptionForLongLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("LongLastName");
        }, "Last name cannot exceed 10 characters");
    }

    @Test
    public void shouldUpdatePhoneWithExactDigits() {
        String newPhone = "0987654321";
        contact.setPhone(newPhone);
        assertEquals(newPhone, contact.getPhone());
    }

    @Test
    public void shouldThrowExceptionForInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        }, "Phone number must be exactly 10 digits");
    }

    @Test
    public void shouldUpdateAddressWithinValidLength() {
        String newAddress = "456 Another St";
        contact.setAddress(newAddress);
        assertEquals(newAddress, contact.getAddress());
    }

    @Test
    public void shouldThrowExceptionForLongAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("Very long address that definitely exceeds the thirty characters limit");
        }, "Address cannot exceed 30 characters");
    }
}
