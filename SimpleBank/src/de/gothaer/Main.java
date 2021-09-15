package de.gothaer;

public class Main {

    public static void main(String[] args) {

        final Bank bank = new Bank();

        Angestellter angestelle [] = {
            new Angestellter(bank, 0,1, 20),
            new Angestellter(bank, 1,2, 20),
            new Angestellter(bank, 2,0, 20)
        };

        System.out.println("Kontostand vorher");
        bank.kontostand();

        for(var angestellter: angestelle) {
            angestellter.start();
        }
    }
}
