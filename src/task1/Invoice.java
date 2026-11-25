package task1;

/** Накладна на відпуск товару: сума обчислюється як ціна × кількість. */
public class Invoice extends Document {
    private String receiver;   // одержувач
    private String goods;      // найменування товару
    private int quantity;      // кількість одиниць
    private double price;      // ціна за одиницю

    public Invoice(String number, String date, String supplier, String receiver,
                   String goods, int quantity, double price) {
        super(number, date, supplier, quantity * price);
        this.receiver = receiver;
        this.goods = goods;
        this.quantity = quantity;
        this.price = price;
    }

    public String getReceiver() { return receiver; }
    public String getGoods() { return goods; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    @Override
    public String getKind() {
        return "Накладна";
    }

    @Override
    public void Show() {
        super.Show();
        System.out.printf("   одержувач: %s; товар: %s, %d шт. × %.2f грн%n",
                receiver, goods, quantity, price);
    }
}
