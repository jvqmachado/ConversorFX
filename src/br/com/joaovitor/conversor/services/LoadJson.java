package br.com.joaovitor.conversor.services;

import br.com.joaovitor.conversor.model.Historical;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static br.com.joaovitor.conversor.config.GsonConfig.gson;

public class LoadJson {
    private final String FILE = "Cotacoes.json";

    public List<Historical> readJson() {
        try (FileReader reader = new FileReader(FILE)) {
            Type listType = new TypeToken<List<Historical>>(){}.getType();
            return gson.fromJson(reader, listType);
        }catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public void saveJson(List<Historical> historical) throws IOException {
        try (FileWriter writer = new FileWriter(FILE)) {
            writer.write(gson.toJson(historical));
        }
    }
}
