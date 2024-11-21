package org.example.adapter;

public class StripeAdapter implements PaymentGateway {
    private final Stripe paymentGateway;

    public StripeAdapter(Stripe paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        paymentGateway.charge(amount);
    }
}
