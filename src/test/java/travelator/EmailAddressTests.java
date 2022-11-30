package travelator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailAddressTests {

    @Test
    void parsing() {
        assertEquals(
            new EmailAddress("fred", "example.com"), EmailAddress.parse("fred@example.com")
        );
    }

    @Test
    void parsingFailures() {
        assertThrows(
            IllegalArgumentException.class, () -> EmailAddress.parse("@")
        );
        assertThrows(
            IllegalArgumentException.class, () -> EmailAddress.parse("fred@")
        );
        assertThrows(
            IllegalArgumentException.class, () -> EmailAddress.parse("@example.com")
        );
        assertThrows(
            IllegalArgumentException.class, () -> EmailAddress.parse("fred_at_example.com")
        );
    }

    @Test
    void parsingWithAtInLocalPart() {
        assertEquals(
            new EmailAddress("\"b@t\"", "example.com"), EmailAddress.parse("\"b@t\"@example.com")
        );
    }
}
