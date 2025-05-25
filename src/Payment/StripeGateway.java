package Payment;

public class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing payment via Stripe: $%.2f%n", amount);
    }
}