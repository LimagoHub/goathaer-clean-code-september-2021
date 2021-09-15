package de.gothaer;

public class Bank {

    private int konten [] = {10, 50, 100};

    public void kontostand() {
        for (int i = 0; i < konten.length; i++) {
            System.out.println(String.format("Das konto Nr. %s hat den Saldo %s.", i, konten[i]));
        }
        System.out.println("--------------------");
    }

    public synchronized void ueberweisen(int von, int nach, int betrag) {

            int zettel = konten[von];

            zettel -= betrag;

            try { Thread.sleep((long)(Math.random()*2000)); } catch (InterruptedException e) { e.printStackTrace();  }
            konten[von] = zettel;
            konten[nach] += betrag;
            kontostand();

    }
}
