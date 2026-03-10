package validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для хранения списка классов,
 * которые нужно использовать для проверки.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Validate {

    /**
     * Список классов для проверки.
     *
     * @return массив классов
     */
    Class<?>[] value();
}