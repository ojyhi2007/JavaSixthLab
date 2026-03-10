package tostring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления отображением класса или поля
 * в строковом представлении объекта.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {

    /**
     * Режим отображения.
     *
     * @return YES, если поле нужно включить в строку,
     *         NO, если поле нужно исключить
     */
    Mode value() default Mode.YES;
}