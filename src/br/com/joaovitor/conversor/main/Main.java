package br.com.joaovitor.conversor.main;


import br.com.joaovitor.conversor.services.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.menu();
    }
}