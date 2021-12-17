package co.com.sofka.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info("Summing {} + {}", number1, number2);
        return number1 + number2;
    }

    public Long resta(Long number1, Long number2) {
        logger.info("Substracting {} - {}", number1, number2);
        return number1 - number2;
    }

    public Long multiplicacion(Long number1, Long number2) {
        logger.info("Multiplicating {} * {}", number1, number2);
        return number1 * number2;
    }

    public Long division(Long number1, Long number2) throws ArithmeticException {
        if (number2 == 0)
            throw new ArithmeticException("Number cannot be equals to 0, 'math indetermination'");
        logger.info("Dividing {} / {}", number1, number2);
        return number1 / number2;
    }
}
