package q2.test;

import ir.maktab.q5.InvalidStringException;
import ir.maktab.q5.StringToInt;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringToIntTest {
    @ParameterizedTest
    @CsvSource({"-30", "350", "32767", "-3", "0"})
    public void testValidInputs(String input) {
        assertEquals(Integer.parseInt(input), StringToInt.convert(input));
    }

    @ParameterizedTest
    @CsvSource({"58 9", "S38"})
    public void testInvalidInputs(String input) {
        InvalidStringException exception = assertThrows(InvalidStringException.class, () -> StringToInt.convert(input));
        assertEquals("Invalid Input String", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"-32768", "32768"})
    public void testBorderValues(String input) {
        InvalidStringException exception = assertThrows(InvalidStringException.class, () -> StringToInt.convert(input));
        assertEquals("Input Number Not In Range", exception.getMessage());
    }
}
