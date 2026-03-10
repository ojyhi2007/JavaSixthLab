package two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для обработчика аннотации Two.
 */
public class TwoProcessorTest {

    /**
     * Проверяет, что корректная аннотация Two
     * проходит валидацию без исключений.
     */
    @Test
    public void testValidTwoAnnotation() {
        assertDoesNotThrow(() -> {
            TwoProcessor.validate(TwoExample.class);
        });
    }

    /**
     * Проверяет, что при некорректных значениях
     * аннотации Two выбрасывается IllegalArgumentException.
     */
    @Test
    public void testInvalidTwoAnnotationThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TwoProcessor.validate(InvalidTwoExample.class);
        });
    }
}