package design_pattern.ex_4;

public class StripeAdapter implements PaymentProcessor{
    
    private StripeGateway gateway;

    public StripeAdapter() {
        gateway = new StripeGateway();
    }

    public void processPayment(double amount) {
        gateway.payAmount(amount);
    }
    
}
