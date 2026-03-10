package invoke;

import java.lang.reflect.Method;

/**
 * Обработчик методов, помеченных аннотацией invoke.Invoke.
 */
public class InvokeProcessor {

    /**
     * Находит и вызывает все методы объекта, отмеченные аннотацией invoke.Invoke.
     *
     * @param obj объект для обработки
     */
    public static void process(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Объект не должен быть null");
        }

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(obj);
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка при вызове метода: " + method.getName(), e);
                }
            }
        }
    }
}