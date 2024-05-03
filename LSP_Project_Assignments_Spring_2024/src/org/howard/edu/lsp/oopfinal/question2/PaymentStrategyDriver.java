package org.howard.edu.lsp.oopfinal.question2;

public class PaymentStrategyDriver {

	public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using credit card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100.0);

        // Pay using PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(50.0);

        // Pay using Bitcoin
        cart.setPaymentStrategy(new BitcoinPayment("1AaBbCcDdEeFfGgHh"));
        cart.checkout(75.0);
    }
}
