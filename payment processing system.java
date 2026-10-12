import java.util.Scanner;

interface Payment {
    void pay(double amount);
    double getFeeRate();
    String getPaymentType();
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment using Credit Card");
    }

    public double getFeeRate() {
        return 0.02;
    }

    public String getPaymentType() {
        return "CreditCard";
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment using UPI");
    }

    public double getFeeRate() {
        return 0.01;
    }

    public String getPaymentType() {
        return "UPI";
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment using Net Banking");
    }

    public double getFeeRate() {
        return 0.015;
    }

    public String getPaymentType() {
        return "NetBanking";
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {
    @Override
    double processPayment(Payment payment, double amount) {
        payment.pay(amount);
        return amount + amount * payment.getFeeRate();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        OnlinePaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;

            if (type == 1) {
                payment = new CreditCardPayment();
            } else if (type == 2) {
                payment = new UPIPayment();
            } else {
                payment = new NetBankingPayment();
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n",
                    payment.getPaymentType(), finalAmount);
        }

        sc