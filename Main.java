import invoke.*;
import defaultvalue.*;
import tostring.*;
import validate.*;
import two.*;
import cache.*;

import java.util.Scanner;

/**
 * Главный класс программы.
 * Позволяет выбрать и запустить нужное задание лабораторной работы №6.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nСписок заданий на аннотации:");
            System.out.println("1 — @Invoke");
            System.out.println("2 — @Default");
            System.out.println("3 — @ToString");
            System.out.println("4 — @Validate");
            System.out.println("5 — @Two");
            System.out.println("6 — @Cache");
            System.out.println("0 — Выход");
            System.out.print("Выберите задание: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n=== Задание 1. @Invoke ===");
                    InvokeExample invokeExample = new InvokeExample();
                    InvokeProcessor.process(invokeExample);
                    System.out.println("Флаг invoked = " + invokeExample.isInvoked());
                    break;

                case 2:
                    System.out.println("\n=== Задание 2. @Default ===");
                    DefaultProcessor.processClass(DefaultExample.class);
                    DefaultProcessor.processFields(DefaultExample.class);
                    break;

                case 3:
                    System.out.println("\n=== Задание 3. @ToString ===");
                    ToStringExample example = new ToStringExample("Илья", 19, "secret");
                    System.out.println(ToStringBuilder.build(example));
                    break;

                case 4:
                    System.out.println("\n=== Задание 4. @Validate ===");
                    ValidateProcessor.process(ValidateExample.class);
                    break;

                case 5:
                    System.out.println("\n=== Задание 5. @Two ===");
                    TwoProcessor.process(TwoExample.class);
                    break;

                case 6:
                    System.out.println("\n=== Задание 6. @Cache ===");
                    CacheProcessor.process(CacheExample.class);

                    System.out.println("\nПроверка пустого Cache:");
                    CacheProcessor.process(EmptyCacheExample.class);
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}