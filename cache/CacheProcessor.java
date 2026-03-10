package cache;

/**
 * Обработчик аннотации cache.Cache.
 */
public class CacheProcessor {

    /**
     * Возвращает список кешируемых областей.
     *
     * @param clazz класс для обработки
     * @return массив кешируемых областей
     * @throws IllegalArgumentException если класс равен null
     *                                  или аннотация отсутствует
     */
    public static String[] getCacheAreas(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Класс не должен быть null");
        }

        if (!clazz.isAnnotationPresent(Cache.class)) {
            throw new IllegalArgumentException(
                    "Класс " + clazz.getSimpleName() + " не помечен аннотацией @cache.Cache"
            );
        }

        Cache annotation = clazz.getAnnotation(Cache.class);
        return annotation.value();
    }

    /**
     * Выводит список кешируемых областей.
     *
     * @param clazz класс для обработки
     */
    public static void process(Class<?> clazz) {
        String[] areas = getCacheAreas(clazz);

        if (areas.length == 0) {
            System.out.println("Кешируемые области отсутствуют");
            return;
        }

        System.out.println("Кешируемые области:");
        for (String area : areas) {
            System.out.println(area);
        }
    }
}