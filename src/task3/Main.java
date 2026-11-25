package task3;

/** Масив об'єктів типу інтерфейсу Pair. */
public class Main {
    public static void main(String[] args) {
        Pair[] pairs = {
                new Money(250, 40), new Money(99, 99),
                new Fraction(2, 3), new Fraction(-1, 6)
        };
        System.out.println("--- Масив об'єктів інтерфейсного типу Pair ---");
        for (Pair p : pairs) {
            System.out.println(p.describe() + "; instanceof Pair: " + (p instanceof Pair));
        }
        for (int i = 0; i < pairs.length; i += 2) {
            Pair a = pairs[i], b = pairs[i + 1];
            System.out.println(a + " + " + b + " = " + a.add(b));
            System.out.println(a + " - " + b + " = " + a.subtract(b));
            System.out.println(a + " * 3 = " + a.multiply(3));
            System.out.println(a + " / 4 = " + a.divide(4));
        }
        System.out.println("equals: " + new Money(250, 40).equals(pairs[0])
                + ", " + new Fraction(4, 6).equals(pairs[2]) + ", " + pairs[0].equals(pairs[2]));
        System.out.printf("Статичний метод інтерфейсу Pair.totalValue(...) = %.4f%n",
                Pair.totalValue(pairs));
        try {
            pairs[2].divide(0);
        } catch (ArithmeticException e) {
            System.out.println("divide(0) -> ArithmeticException: " + e.getMessage());
        }
    }
}
