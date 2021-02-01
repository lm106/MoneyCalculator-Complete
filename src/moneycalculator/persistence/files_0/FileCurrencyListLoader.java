package moneycalculator.persistence.files_0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model_0.Currency;
import moneycalculate.persistence_0.CurrencyListLoader;

/**
 *
 * @author Luzma
 * @version 30-10-2020
 * @since Práctica en Aula
 */

public class FileCurrencyListLoader implements CurrencyListLoader{
    
    private final String filename;
    
    public FileCurrencyListLoader(String filename){
        this.filename = filename;
    }

    @Override
    public Currency[] currencies() {
        List<Currency> list = new ArrayList <>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            while(true){
                String line= reader.readLine();
                if(line == null) break;
                list.add(currencyOf(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: FileCurrencyListLoader: currencies (File not found)" + ex.getMessage());
        } catch(IOException ex){
            System.out.println("ERROR: FileCurrencyListLoader: currencies (IO)" + ex.getMessage());
        }
        return list.toArray(new Currency[0]);
    }

    private Currency currencyOf(String line) {
        String [] split = line.split(",");
        return new Currency (split[0], split[1], split[2]);
    }
    
}
