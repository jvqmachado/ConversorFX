package br.com.joaovitor.conversor.services;

import br.com.joaovitor.conversor.exceptios.ErrorSearchCoin;

import java.io.IOException;
import java.util.InputMismatchException;

import static br.com.joaovitor.conversor.config.ScannerConfig.scan;

public class Menu {
    String option = "";
    RequestApi request = new RequestApi();
    Converter converter = new Converter();
    public void menu() throws IOException, InterruptedException {
        try {
            do {
                System.out.println("1. Converter Dólar → Real");
                System.out.println("2. Converter Real → Dólar");
                System.out.println("3. Converter Euro → Real");
                System.out.println("4. Converter Real → Euro");
                System.out.println("Deseja finalizar? (sim/nao)");
                option = scan.nextLine();

                switch (option) {
                    case "1" -> converter.converter("usd", "brl");
                    case "2" -> converter.converter("brl", "usd");
                    case "3" -> converter.converter("eur", "brl");
                    case "4" -> converter.converter("brl", "eur");
                }
            }while (!option.equalsIgnoreCase("sim"));
        } catch (InputMismatchException | ErrorSearchCoin e) {
            System.out.println(e.getMessage());
        }
    }
}
