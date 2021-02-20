import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void test_toUpperCase_withNull_ReturnsNull() {
        String input = null;
        String actual = StringUtils.toUpperCase(input);
        Assertions.assertNull(actual);
    }

    @Test
    void test_toUpperCase_withNonNull_ReturnsUpperCase() {
        String input = "abc";
        String actual = StringUtils.toUpperCase(input);
        Assertions.assertEquals("ABC", actual);
    }

    @Test
    void test_toUpperCase_withSpecialChar_ReturnsUpperCase() {
        String input = "aéèàù";
        String actual = StringUtils.toUpperCase(input);
        Assertions.assertEquals("AÉÈÀÙ", actual);
    }
}
