package task1;

/** Рахунок на оплату: кому виставлено, до якої дати сплатити, чи оплачено. */
public class Bill extends Document {
    private String customer;   // замовник (платник за рахунком)
    private String dueDate;    // сплатити до
    private boolean paid;      // чи оплачено

    public Bill(String number, String date, String organization, double amount,
                String customer, String dueDate, boolean paid) {
        super(number, date, organization, amount);
        this.customer = customer;
        this.dueDate = dueDate;
        this.paid = paid;
    }

    public String getCustomer() { return customer; }
    public String getDueDate() { return dueDate; }
    public boolean isPaid() { return paid; }

    public void pay() {
        paid = true;
    }

    @Override
    public String getKind() {
        return "Рахунок";
    }

    @Override
    public void Show() {
        super.Show();
        System.out.printf("   замовник: %s; сплатити до %s; %s%n", customer, dueDate,
                paid ? "оплачено" : "не оплачено");
    }
}
