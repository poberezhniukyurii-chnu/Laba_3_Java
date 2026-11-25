package task3;

/** Звичайний дріб, що реалізує інтерфейс Pair. */
public class Fraction implements Pair {
    private final long num;
    private final long den;

    public Fraction(long num, long den) {
        if (den == 0) throw new ArithmeticException("знаменник дорівнює нулю");
        if (den < 0) {
            num = -num;
            den = -den;
        }
        long a = Math.abs(num), b = den;
        while (b != 0) {                 // НСД алгоритмом Евкліда
            long t = a % b;
            a = b;
            b = t;
        }
        long g = a == 0 ? 1 : a;
        this.num = num / g;
        this.den = den / g;
    }

    private static Fraction cast(Pair other) {
        if (!(other instanceof Fraction)) {
            throw new IllegalArgumentException("операція можлива лише між об'єктами Fraction");
        }
        return (Fraction) other;
    }

    @Override
    public Pair add(Pair other) {
        Fraction f = cast(other);
        return new Fraction(num * f.den + f.num * den, den * f.den);
    }

    @Override
    public Pair subtract(Pair other) {
        Fraction f = cast(other);
        return new Fraction(num * f.den - f.num * den, den * f.den);
    }

    @Override
    public Pair multiply(int k) {
        return new Fraction(num * k, den);
    }

    @Override
    public Pair divide(int k) {
        if (k == 0) throw new ArithmeticException("ділення на нуль");
        return new Fraction(num, den * k);
    }

    @Override
    public double value() {
        return (double) num / den;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) return false;
        Fraction f = (Fraction) obj;
        return num == f.num && den == f.den;
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(num) + Long.hashCode(den);
    }

    @Override
    public String toString() {
        return den == 1 ? String.valueOf(num) : num + "/" + den;
    }
}
