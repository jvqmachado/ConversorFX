package br.com.joaovitor.conversor.services;

import br.com.joaovitor.conversor.exceptios.ErrorSearchCoin;
import br.com.joaovitor.conversor.model.Coin;
import com.google.gson.reflect.TypeToken;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

import static br.com.joaovitor.conversor.config.GsonConfig.gson;

public class RequestApi {
    DecimalFormat df = new DecimalFormat("#,##0.00");
    public Coin requestApi(String firtscoin, String secondcoin) throws IOException, InterruptedException {
        var url = "https://economia.awesomeapi.com.br/json/last/" + firtscoin + "-" + secondcoin;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();

            Type type = new TypeToken<Map<String, Coin>>(){}.getType();
            Map<String, Coin> map = gson.fromJson(json, type);

            Coin coin = map.values().iterator().next();

            System.out.println("Cotacao atual do " + firtscoin + ": $" + df.format(coin.getBid()));

            return coin;
        } catch (IOException | InterruptedException e) {
            throw new ErrorSearchCoin("Nao foi possivel consultar a cotacao da moeda. Verifique sua conexao.");
        }
    }
}
