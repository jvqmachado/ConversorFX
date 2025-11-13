package br.com.joaovitor.conversor.exceptios;

public class ErrorSearchCoin extends RuntimeException {
    public ErrorSearchCoin(String message) {
        super(message);
    }
}
