package hu.szamalk.modell;

public class Hajo extends Jarmu{
    private int ferohely;
    private String nev;

    public Hajo(String rendszam, Minosites minosites, int ferohely, String nev) {
        super(rendszam, minosites);
        this.ferohely = ferohely;
        this.nev = nev;
    }

    @Override
    public String toString() {
        return "Hajo{" + super.getRendszam()+ super.getMinosites() +
                "ferohely=" + ferohely +
                ", nev='" + nev + '\'' +
                '}';
    }
}
