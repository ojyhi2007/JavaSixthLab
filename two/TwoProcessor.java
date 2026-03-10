package two;

/**
 * Обработчик аннотации two.Two.
 */
public class TwoProcessor {

    /**
     * Проверяет корректность значений аннотации two.Two.
     *
     * @param clazz класс для обработки
     * @throws IllegalArgumentException если класс равен null,
     *                                  аннотация отсутствует,
     *                                  строка пустая
     *                                  или число отрицательное
     */
    public static void validate(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не должен быть null");
        }

        if (!clazz.isAnnotationPresent(Two.class)) {
            throw new IllegalArgumentException(
                    "Класс " + clazz.getSimpleName() + " не помечен аннотацией @two.Two"
            );
        }

        Two annotation = clazz.getAnnotation(Two.class);

        if (annotation.first() == null || annotation.first().isBlank()) {
            throw new IllegalArgumentException("Свойство first не должно быть пустым");
        }

        if (annotation.second() < 0) {
            throw new IllegalArgumentException("Свойство second не должно быть отрицательным");
        }
    }

    /**
     * Выводит значения свойств аннотации two.Two.
     *
     * @param clazz класс для обработки
     */
    public static void process(Class<?> clazz) {
        validate(clazz);

        Two annotation = clazz.getAnnotation(Two.class);

        System.out.println("first = " + annotation.first());
        System.out.println("second = " + annotation.second());
    }
}