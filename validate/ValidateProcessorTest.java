package validate;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для обработчика аннотации Validate.
 */
public class ValidateProcessorTest {

    /**
     * Проверяет, что классы из аннотации Validate
     * корректно извлекаются обработчиком.
     */
    @Test
    public void testGetValidatedClasses() {
        Class<?>[] classes = ValidateProcessor.getValidatedClasses(ValidateExample.class);

        assertEquals(3, classes.length);
        assertEquals(String.class, classes[0]);
        assertEquals(Integer.class, classes[1]);
        assertEquals(Double.class, classes[2]);
    }

    /**
     * Проверяет, что при пустом массиве классов
     * выбрасывается исключение IllegalArgumentException.
     */
    @Test
    public void testEmptyValidatedClassesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateProcessor.getValidatedClasses(EmptyValidateExample.class);
        });
    }
}