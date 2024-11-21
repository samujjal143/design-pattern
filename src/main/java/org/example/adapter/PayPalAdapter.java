package org.example.adapter;

public class PayPalAdapter implements PaymentGateway {
    private final PayPal paymentGateway;

    public PayPalAdapter(PayPal paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        paymentGateway.makePayment(amount);
    }
}
