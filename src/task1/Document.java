package task1;

/**
 * Документ — суперклас ієрархії (варіант 10: квитанція, накладна, документ, рахунок).
 * Лабораторна робота №3, завдання 1. Побережнюк Ю.В., група 241б.
 */
public class Document {
    private String number;        // номер документа
    private String date;          // дата складання (дд.мм.рррр)
    private String organization;  // організація, що видала документ
    private double amount;        // сума, грн

    public Document(String number, String date, String organization, double amount) {
        this.number = number;
        this.date = date;
        this.organization = organization;
        this.amount = amount;
    }

    public String getNumber() { return number; }
    public String getDate() { return date; }
    public String getOrganization() { return organization; }
    public double getAmount() { return amount; }

    protected void setAmount(double amount) { this.amount = amount; }

    /** Назва виду документа (перевизначається в підкласах). */
    public String getKind() {
        return "Документ";
    }

    /** Виводить дані про документ. */
    public void Show() {
        System.out.printf("%s №%s від %s%n", getKind(), number, date);
        System.out.printf("   організація: %s; сума: %.2f грн%n", organization, amount);
    }
}
