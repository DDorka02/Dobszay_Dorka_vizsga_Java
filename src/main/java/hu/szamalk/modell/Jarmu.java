package hu.szamalk.modell;

public class Jarmu {
    private String rendszam;
    private Minosites minosites;


    public Jarmu(String rendszam, Minosites minosites) {
        this.minosites = minosites;
        this.rendszam=rendszam;
        if(rendszam == "-"){
            try {
                throw new KotojelesExeption();
            }catch (KotojelesExeption e){
                System.out.println();
            }
        }
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public Minosites getMinosites() {
        return minosites;
    }

    public void setMinosites(Minosites minosites) {
        this.minosites = minosites;
    }
}
