interface PaymentProcessor {
    void processPayment(double amount);
    void refundPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
    
    public void issueRefund(double amount) {
        System.out.println("Issuing PayPal refund of $" + amount);
    }
}

class StripeGateway {
    public void makeCharge(double amount) {
        System.out.println("Processing Stripe charge of $" + amount);
    }
    
    public void reverseCharge(double amount) {
        System.out.println("Reversing Stripe charge of $" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;
    
    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }
    
    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
    
    @Override
    public void refundPayment(double amount) {
        payPal.issueRefund(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;
    
    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }
    
    @Override
    public void processPayment(double amount) {
        stripe.makeCharge(amount);
    }
    
    @Override
    public void refundPayment(double amount) {
        stripe.reverseCharge(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PayPalGateway payPal = new PayPalGateway();
        StripeGateway stripe = new StripeGateway();

        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        System.out.println("Processing payments:");
        payPalProcessor.processPayment(100.50);
        stripeProcessor.processPayment(75.25);

        System.out.println("\nProcessing refunds:");
        payPalProcessor.refundPayment(50.25);
        stripeProcessor.refundPayment(25.75);
    }
}
