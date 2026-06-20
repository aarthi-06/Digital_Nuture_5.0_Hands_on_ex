package design_pattern.ex_4;

public class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway gateway;

    public PayPalAdapter() {
        gateway = new PayPalGateway();
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }

}
