package invoke;

/**
 * Класс для демонстрации работы аннотации Invoke.
 */
public class InvokeExample {

    private boolean invoked;

    /**
     * Создает объект с флагом вызова false.
     */
    public InvokeExample() {
        this.invoked = false;
    }

    /**
     * Метод, который должен быть вызван автоматически.
     */
    @Invoke
    public void start() {
        invoked = true;
        System.out.println("Method start() invoked");
    }

    /**
     * Обычный метод без аннотации.
     */
    public void regularMethod() {
        System.out.println("Regular method without annotation");
    }

    /**
     * Возвращает, был ли вызван метод с аннотацией.
     *
     * @return true, если метод был вызван
     */
    public boolean isInvoked() {
        return invoked;
    }
}
