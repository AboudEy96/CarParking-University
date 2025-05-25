package Payment;

public class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing payment via PayPal: $%.2f%n", amount);
    }
}