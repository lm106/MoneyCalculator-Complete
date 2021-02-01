package moneycalculate.persistence_0;

import moneycalculator.model_0.Currency;
import moneycalculator.model_0.ExchangeRate;

/**
 *
 * @author Luzma
 * @version 30-10-2020
 * @since Práctica en Aula
 */

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
