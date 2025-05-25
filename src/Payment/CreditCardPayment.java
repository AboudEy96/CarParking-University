package Payment;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(PaymentGateway gateway, String cardNumber, String cardHolder) {
        super(gateway);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void makePayment(double amount) {
        System.out.printf("Authenticating card %s for %s%n",
                maskCardNumber(cardNumber), cardHolder);
        gateway.processPayment(amount);
    }

    private String maskCardNumber(String number) {
        return "****-****-****-" + number.substring(number.length() - 4);
    }
}