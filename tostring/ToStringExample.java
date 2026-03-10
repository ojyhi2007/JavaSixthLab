package tostring;

/**
 * Класс для демонстрации работы аннотации tostring.ToString.
 */
@ToString
public class ToStringExample {

    private String name;
    private int age;

    @ToString(Mode.NO)
    private String password;

    /**
     * Создает объект с заданными значениями.
     *
     * @param name имя
     * @param age возраст
     * @param password пароль
     */
    public ToStringExample(String name, int age, String password) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        if (password == null) {
            throw new IllegalArgumentException("Пароль не должен быть null");
        }

        this.name = name;
        this.age = age;
        this.password = password;
    }

    /**
     * Возвращает имя.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает возраст.
     *
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Возвращает пароль.
     *
     * @return пароль
     */
    public String getPassword() {
        return password;
    }
}