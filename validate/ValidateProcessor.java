package validate;

/**
 * Обработчик аннотации validate.Validate.
 */
public class ValidateProcessor {

    /**
     * Возвращает список классов, указанных в аннотации validate.Validate.
     *
     * @param clazz класс для обработки
     * @return массив классов из аннотации
     * @throws IllegalArgumentException если класс равен null,
     *                                  аннотация отсутствует
     *                                  или массив классов пуст
     */
    public static Class<?>[] getValidatedClasses(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не должен быть null");
        }

        if (!clazz.isAnnotationPresent(Validate.class)) {
            throw new IllegalArgumentException(
                    "Класс " + clazz.getSimpleName() + " не помечен аннотацией @validate.Validate"
            );
        }

        Validate annotation = clazz.getAnnotation(Validate.class);
        Class<?>[] classes = annotation.value();

        if (classes.length == 0) {
            throw new IllegalArgumentException("Список классов в аннотации @validate.Validate пуст");
        }

        return classes;
    }

    /**
     * Выводит список классов, указанных в аннотации validate.Validate.
     *
     * @param clazz класс для обработки
     */
    public static void process(Class<?> clazz) {
        Class<?>[] classes = getValidatedClasses(clazz);

        System.out.println("Классы для проверки:");

        for (Class<?> checkedClass : classes) {
            System.out.println(checkedClass.getSimpleName());
        }
    }
}