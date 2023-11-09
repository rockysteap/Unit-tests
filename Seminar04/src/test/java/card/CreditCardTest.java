package card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {
    CreditCard creditCard;

    @BeforeEach
    void setUp() {
        creditCard = new CreditCard("123456789", "John Silver", "31.12.2023", "777");
    }

    @Test
    void testGetCardNumber() {
        assertEquals("123456789", creditCard.getCardNumber());
    }

    @Test
    void testGetCardHolder() {
        assertEquals("John Silver", creditCard.getCardHolder());
    }

    @Test
    void testGetCardExpiryDate() {
        assertEquals("31.12.2023", creditCard.getExpiryDate());
    }

    @Test
    void testGetCardCVV() {
        assertEquals("777", creditCard.getCvv());
    }

    @Test
    void testCharge() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));
        creditCard.charge(1200.00);

        assertEquals("Charged amount 1200.0 from the card: 123456789", outputStream.toString().trim());

        System.setOut(null);
    }

}
