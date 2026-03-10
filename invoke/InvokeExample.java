package invoke;

/**
 * Класс для демонстрации работы аннотации invoke.Invoke.
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
        System.out.println("Метод start() вызван");
    }

    /**
     * Обычный метод без аннотации.
     */
    public void обычныйМетод() {
        System.out.println("Обычный метод без invoke.Invoke");
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