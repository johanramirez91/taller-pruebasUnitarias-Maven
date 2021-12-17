package co.com.sofka.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculatorTest.class);

    @Test
    @DisplayName("Testing sum: 1 + 1 = 2")
    void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "5,    1,   4",
            "1,    2,   -1",
            "0,  1, -1",
            "1,  1, 0",
            "2, -4, 6",
            "-5, -1, -4"
    })
    void severalSubs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.resta(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "5,    1,   5",
            "1,    2,   2",
            "0,  1, 0",
            "1,  1, 1",
            "2, -4, -8",
            "-10, -1, 10"
    })
    void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiplicacion(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "5,    1,   5",
            "1,    2,   0,5",
            "0,  1, 0",
            "1,  1, 1",
            "2, -4, -0,5",
            "-10, -1, 10",
            "5, 0,",
            "0, 0 "
    })
    void severalDivs(Long first, Long second, Long expectedResult) {
        try {
            assertEquals(expectedResult, basicCalculator.division(first, second),
                    () -> first + " + " + second + " should equal " + expectedResult);
        } catch (ArithmeticException error) {
            logger.error("Error, division by zero" + error.getMessage());
        }
    }
}
