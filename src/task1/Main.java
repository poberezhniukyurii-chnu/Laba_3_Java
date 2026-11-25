package task1;

import java.util.Scanner;

/** Введення документів у масив типу суперкласу та друк методом Show(). */
public class Main {
    static Scanner in;

    static String ask(String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }

    static double askDouble(String prompt) {
        return Double.parseDouble(ask(prompt).replace(',', '.'));
    }

    static Document readDocument() {
        String type = ask("Вид (1 - квитанція, 2 - накладна, 3 - рахунок, 4 - інший документ): ");
        String number = ask("  номер: ");
        String date = ask("  дата: ");
        switch (type) {
            case "1": {
                String org = ask("  організація-одержувач коштів: ");
                double sum = askDouble("  сума, грн: ");
                String payer = ask("  платник: ");
                return new Receipt(number, date, org, sum, payer, ask("  призначення платежу: "));
            }
            case "2": {
                String supplier = ask("  постачальник: ");
                String receiver = ask("  одержувач: ");
                String goods = ask("  товар: ");
                int qty = Integer.parseInt(ask("  кількість: "));
                double price = askDouble("  ціна за одиницю: ");
                return new Invoice(number, date, supplier, receiver, goods, qty, price);
            }
            case "3": {
                String org = ask("  організація-постачальник: ");
                double sum = askDouble("  сума, грн: ");
                String customer = ask("  замовник: ");
                String due = ask("  сплатити до: ");
                boolean paid = ask("  оплачено? (так/ні): ").equalsIgnoreCase("так");
                return new Bill(number, date, org, sum, customer, due, paid);
            }
            default:
                return new Document(number, date, ask("  організація: "), askDouble("  сума, грн: "));
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int n = Integer.parseInt(ask("Кількість документів: "));
        Document[] docs = new Document[n];             // масив типу суперкласу
        for (int i = 0; i < n; i++) {
            System.out.println("Документ " + (i + 1) + ":");
            docs[i] = readDocument();
        }

        System.out.println("\n===== Введені документи =====");
        double total = 0;
        for (Document d : docs) {
            d.Show();                                  // викликається версія методу підкласу
            total += d.getAmount();
        }
        System.out.printf("Разом документів: %d, загальна сума: %.2f грн%n", n, total);

        int unpaid = 0;
        for (Document d : docs) {
            if (d instanceof Bill && !((Bill) d).isPaid()) unpaid++;
        }
        System.out.println("Неоплачених рахунків: " + unpaid);
        in.close();
    }
}
