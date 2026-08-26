package module3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    void toString_formatIsCorrect() {
        assertEquals("Ada Lovelace | +1 617 555 0101", contact.toString());
    }

    @Test
    void changingOneContactPhone_doesNotAffectAnotherWithSameName() {
        Contact firstContact = new Contact("Ada Lovelace", "+1 617 555 0101");
        Contact secondContact = new Contact("Ada Lovelace", "+1 123 456 7890");
        firstContact.setPhone("+1 952 111 0007");

        assertEquals("+1 952 111 0007", firstContact.getPhone());
        assertEquals("+1 123 456 7890", secondContact.getPhone());
    }

}
