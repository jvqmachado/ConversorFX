package br.com.joaovitor.conversor.services;

import br.com.joaovitor.conversor.model.Historical;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static br.com.joaovitor.conversor.config.ScannerConfig.scan;

public class Converter {
    private List<Historical> historicals = new ArrayList<>();
    private LoadJson loadJson = new LoadJson();
    RequestApi request = new RequestApi();
    DecimalFormat df = new DecimalFormat("#,##0.00");
    public void converter(String firstCoin, String secondCoin) throws IOException, InterruptedException {
        var price = request.requestApi(firstCoin, secondCoin);
        try {
            System.out.println("Digite o valor em " + firstCoin + " que deseja cotar: ");
            var value = scan.nextDouble();
            var balance = value * price.getBid();

            System.out.println("A cotação ficou: $" + df.format(balance));
            scan.nextLine();

            List<Historical> historicals = loadJson.readJson();
            historicals.add(new Historical(firstCoin, secondCoin, value, balance));
            loadJson.saveJson(historicals);

        }catch (InputMismatchException e) {
            System.out.println("Digite apenas numeros");
            scan.nextLine();
        }
    }
}
