package task3;

/** Грошова сума, що реалізує інтерфейс Pair. Зберігається в копійках. */
public class Money implements Pair {
    private final long kopecks;

    public Money(long hryvnias, int kopecks) {
        this.kopecks = hryvnias * 100 + kopecks;
    }

    private Money(long totalKopecks) {
        this.kopecks = totalKopecks;
    }

    public long getHryvnias() { return kopecks / 100; }
    public int getKopecks() { return (int) (kopecks % 100); }

    private static Money cast(Pair other) {
        if (!(other instanceof Money)) {
            throw new IllegalArgumentException("операція можлива лише між об'єктами Money");
        }
        return (Money) other;
    }

    @Override
    public Pair add(Pair other) {
        return new Money(kopecks + cast(other).kopecks);
    }

    @Override
    public Pair subtract(Pair other) {
        return new Money(kopecks - cast(other).kopecks);
    }

    @Override
    public Pair multiply(int k) {
        return new Money(kopecks * k);
    }

    @Override
    public Pair divide(int k) {
        if (k == 0) throw new ArithmeticException("ділення на нуль");
        return new Money(Math.round((double) kopecks / k));
    }

    @Override
    public double value() {
        return kopecks / 100.0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Money && ((Money) obj).kopecks == kopecks;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(kopecks);
    }

    @Override
    public String toString() {
        long abs = Math.abs(kopecks);
        return String.format("%s%d,%02d грн", kopecks < 0 ? "-" : "", abs / 100, abs % 100);
    }
}
