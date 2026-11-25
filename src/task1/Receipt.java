package task1;

/** Квитанція про оплату: хто й за що заплатив. */
public class Receipt extends Document {
    private String payer;      // платник
    private String purpose;    // призначення платежу

    public Receipt(String number, String date, String organization, double amount,
                   String payer, String purpose) {
        super(number, date, organization, amount);
        this.payer = payer;
        this.purpose = purpose;
    }

    public String getPayer() { return payer; }
    public String getPurpose() { return purpose; }

    @Override
    public String getKind() {
        return "Квитанція";
    }

    @Override
    public void Show() {
        super.Show();
        System.out.printf("   платник: %s; призначення платежу: %s%n", payer, purpose);
    }
}
