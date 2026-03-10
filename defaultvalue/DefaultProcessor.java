package defaultvalue;

import java.lang.reflect.Field;

/**
 * Обработчик аннотации defaultvalue.Default.
 */
public class DefaultProcessor {

    /**
     * Выводит информацию об аннотации defaultvalue.Default у класса.
     *
     * @param clazz класс для обработки
     */
    public static void processClass(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не должен быть null");
        }

        if (clazz.isAnnotationPresent(Default.class)) {
            Default annotation = clazz.getAnnotation(Default.class);
            System.out.println("Класс по умолчанию для " + clazz.getSimpleName() +
                    ": " + annotation.value().getSimpleName());
        } else {
            System.out.println("На классе " + clazz.getSimpleName() + " аннотация @defaultvalue.Default не найдена");
        }
    }

    /**
     * Выводит информацию об аннотации defaultvalue.Default у всех полей класса.
     *
     * @param clazz класс для обработки
     */
    public static void processFields(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не должен быть null");
        }

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                System.out.println("Поле " + field.getName() +
                        " имеет класс по умолчанию: " +
                        annotation.value().getSimpleName());
            }
        }
    }
}