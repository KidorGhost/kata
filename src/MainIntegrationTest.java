import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainIntegrationTest {
    @Test
    public void testCalcWithValidInput() {
        try {
            String result = Main.calc("5+3");
            assertEquals("8", result);
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }

    @Test
    public void testCalcWithInvalidInput() {
        try {
            Main.calc("invalid input");
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Вы ввели не коректное выражение", e.getMessage());
        }
    }

    @Test
    public void testCalcWithUnsupportedOperation() {
        try {
            Main.calc("5^3");
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Вы ввели не коректное выражение", e.getMessage());
        }
    }

    @Test
    public void testCalcWithRomanNumbers() {
        try {
            String result = Main.calc("V+III");
            assertEquals("VIII", result);
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }

    @Test
    public void testCalcWithOutOfRangeNumbers() {
        try {
            Main.calc("11+2");
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Числа должны быть от 1 до 10", e.getMessage());
        }
    }

    @Test
    public void testCalcArabianNumWithRoman() {
        try {
            Main.calc("V+2");
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Числа должны быть в одном формате", e.getMessage());
        }
    }
}
