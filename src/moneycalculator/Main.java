package moneycalculator;

import moneycalculate.persistence_0.CurrencyListLoader;
import moneycalculate.persistence_0.ExchangeRateLoader;
import moneycalculator.control.CalculateCommand;
import moneycalculator.persistence.files_0.FileCurrencyListLoader;
import moneycalculator.persistence.rest_0.RestExchangeRateLoader;

/**
 *
 * @author Luzma
 * @version 30-10-2020
 * @since Práctica en Aula
 */
public class Main {
    public static void main (String[] args){
        CurrencyListLoader currencyListLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        
        MainFrame mainFrame = new MainFrame(currencyListLoader.currencies());
        
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }
}
