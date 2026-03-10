package two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация с двумя обязательными свойствами.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {

    /**
     * Строковое свойство.
     *
     * @return строковое значение
     */
    String first();

    /**
     * Числовое свойство.
     *
     * @return числовое значение
     */
    int second();
}