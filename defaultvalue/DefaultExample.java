package defaultvalue;

/**
 * Класс для демонстрации работы аннотации defaultvalue.Default.
 */
@Default(String.class)
public class DefaultExample {

    @Default(Integer.class)
    private Object number;

    private Object text;

    /**
     * Создает объект с начальными значениями полей.
     */
    public DefaultExample() {
        this.number = 100;
        this.text = "Пример";
    }

    /**
     * Возвращает значение поля number.
     *
     * @return значение поля number
     */
    public Object getNumber() {
        return number;
    }

    /**
     * Возвращает значение поля text.
     *
     * @return значение поля text
     */
    public Object getText() {
        return text;
    }
}