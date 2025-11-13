package br.com.joaovitor.conversor.model;

import br.com.joaovitor.conversor.exceptios.CoinNull;

public class Coin {
    private Double bid;

    public Coin(String bid) {
        if (bid == null || bid.isBlank()) {
            throw new CoinNull("O valor da cotação nao foi encontrado. Tente novamente.");
        }
        this.bid = Double.parseDouble(bid);
    }

    public Double getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "A cotação ficou: $" + this.bid;
    }
}
