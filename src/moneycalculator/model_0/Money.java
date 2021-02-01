package moneycalculator.model_0;

import moneycalculator.model_0.Currency;

/**
 *
 * @author Luzma
 * @version 30-10-2020
 * @since Práctica en Aula
 */
public class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
}
