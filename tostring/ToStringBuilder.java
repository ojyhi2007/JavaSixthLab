package tostring;

import java.lang.reflect.Field;

/**
 * Формирует строковое представление объекта на основе аннотации tostring.ToString.
 */
public class ToStringBuilder {

    /**
     * Формирует строковое представление объекта,
     * исключая поля с аннотацией tostring.ToString(tostring.Mode.NO).
     *
     * @param obj объект для обработки
     * @return строковое представление объекта
     */
    public static String build(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Объект не должен быть null");
        }

        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(ToString.class)) {
            throw new IllegalArgumentException("Класс " + clazz.getSimpleName() +
                    " не помечен аннотацией @tostring.ToString");
        }

        StringBuilder result = new StringBuilder();
        result.append(clazz.getSimpleName()).append("{");

        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            ToString fieldAnnotation = field.getAnnotation(ToString.class);

            if (fieldAnnotation != null && fieldAnnotation.value() == Mode.NO) {
                continue;
            }

            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (!first) {
                    result.append(", ");
                }

                result.append(field.getName()).append("=").append(value);
                first = false;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Ошибка доступа к полю " + field.getName(), e);
            }
        }

        result.append("}");
        return result.toString();
    }
}