package task2;

import java.util.Scanner;

/** Масив об'єктів абстрактного класу Pair і демонстрація методів підкласів. */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть дві грошові суми (напр. 120,50 35,75): ");
        Money m1 = new Money(in.next());
        Money m2 = new Money(in.next());
        System.out.print("Введіть два дроби (напр. 3/4 5/6): ");
        Fraction f1 = new Fraction(in.next());
        Fraction f2 = new Fraction(in.next());
        System.out.print("Введіть ціле число для множення й ділення: ");
        int k = in.nextInt();

        Pair[] pairs = {m1, m2, f1, f2};                 // масив типу абстрактного класу
        System.out.println("\n--- Масив об'єктів Pair ---");
        for (Pair p : pairs) {
            System.out.println(p.describe());
        }

        System.out.println("\n--- Операції (поліморфний виклик через тип Pair) ---");
        for (int i = 0; i < pairs.length; i += 2) {
            Pair a = pairs[i], b = pairs[i + 1];
            System.out.println(a + " + " + b + " = " + a.add(b));
            System.out.println(a + " - " + b + " = " + a.subtract(b));
            System.out.println(a + " * " + k + " = " + a.multiply(k));
            System.out.println(a + " / " + k + " = " + a.divide(k));
        }
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2) + "  (метод лише класу Fraction)");

        System.out.println("\n--- equals ---");
        System.out.println("new Money(\"120,50\").equals(new Money(120, 50)): "
                + new Money("120,50").equals(new Money(120, 50)));
        System.out.println("new Fraction(6, 8).equals(new Fraction(\"3/4\")): "
                + new Fraction(6, 8).equals(new Fraction("3/4")));
        System.out.println("m1.equals(f1): " + m1.equals(f1));

        try {
            m1.add(f1);
        } catch (IllegalArgumentException e) {
            System.out.println("m1.add(f1) -> IllegalArgumentException: " + e.getMessage());
        }
        in.close();
    }
}
