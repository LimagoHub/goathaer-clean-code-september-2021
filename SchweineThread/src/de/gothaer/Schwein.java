package de.gothaer;

public class Schwein {

    private String name;
    private volatile int gewicht;

    public Schwein() {
        this("nobody");
    }
    public Schwein(String name) {
        this.name = name;
        this.gewicht = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void fressen() { // Async
        try {
            Thread.sleep(2000);
            gewicht ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Schwein{" +
                "name='" + name + '\'' +
                ", gewicht=" + gewicht +
                '}';
    }
}
