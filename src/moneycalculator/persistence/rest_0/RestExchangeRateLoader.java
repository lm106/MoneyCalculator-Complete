package moneycalculator.persistence.rest_0;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import moneycalculator.model_0.Currency;
import moneycalculator.model_0.ExchangeRate;
import moneycalculate.persistence_0.ExchangeRateLoader;

/**
 *
 * @author Luzma
 * @version 30-10-2020
 * @since Práctica en Aula
 */

public class RestExchangeRateLoader implements ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        }catch (IOException ex){
            System.out.println("ERROR: RestExchangeRateLoader: load (IO)" + ex.getMessage());
            return null;
        }    
    }
    
    private double read(String from, String to) throws IOException, MalformedURLException{
        String line = read(new URL("http://api.fixer.io/latest?base=" + from + "&symbols=" + to));
        return Double.parseDouble(line.substring(line.indexOf(to) + 5, line.indexOf("+")));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        return new String(buffer, 0, length);
    }
    
    
}
