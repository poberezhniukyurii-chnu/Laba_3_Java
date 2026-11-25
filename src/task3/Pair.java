package task3;

/**
 * Завдання 3: те саме, що й завдання 2, але замість абстрактного класу — інтерфейс.
 * Інтерфейс не може мати полів екземпляра, тому дані зберігаються в класах-реалізаціях.
 * Лабораторна робота №3, завдання 3 (варіант 8). Побережнюк Ю.В., група 241б.
 */
public interface Pair {
    Pair add(Pair other);

    Pair subtract(Pair other);

    Pair multiply(int k);

    Pair divide(int k);

    double value();

    /** Метод за замовчуванням (default) — має реалізацію прямо в інтерфейсі. */
    default String describe() {
        return getClass().getSimpleName() + " " + this
                + " (значення " + String.format("%.4f", value()) + ")";
    }

    /** Статичний метод інтерфейсу: сума значень кількох пар. */
    static double totalValue(Pair... pairs) {
        double s = 0;
        for (Pair p : pairs) s += p.value();
        return s;
    }
}
