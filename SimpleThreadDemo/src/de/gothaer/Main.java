package de.gothaer;

public class Main {

    public static void main(String[] args) throws Exception{

        MyThread hund = new MyThread("Wau");
        MyThread katze = new MyThread("Miau");
        MyThread maus = new MyThread("Piep");

        Thread threads[] = { new Thread(hund), new Thread(katze), new Thread(maus)};

        for (var thread: threads) {
            thread.start();
        }
       System.out.println("Fettisch");

      


    }


}
