package hu.szamalk.modell;

import java.text.Collator;
import java.util.Comparator;
import java.util.UUID;

public class Auto extends Jarmu implements Comparable<Auto> {
    private transient UUID id;
    private String hetnapja;



    public Auto(String rendszam, Minosites minosites, String hetnapja) {
        super(rendszam, minosites);
        this.hetnapja = hetnapja;
        id = UUID.randomUUID();
        if(rendszam == null){
            this.hetnapja = "hétfő";
        }
        else{
            this.hetnapja=hetnapja;
        }
    }

    public String getHetnapja() {
        return hetnapja;
    }

    @Override
    public int compareTo(Auto masik) {
        return getRendszam().compareTo(masik.getRendszam());
    }

    public HetnapjaComparator rendezHetnapja(){
        return new HetnapjaComparator();
    }

    class HetnapjaComparator implements Comparator<Auto> {
        public int compare(Auto auto, Auto auto2) {
            int hetnapjaCompare = auto.getHetnapja().compareTo(auto2.getHetnapja());
            return hetnapjaCompare;
        }
    }

    @Override
    public String toString() {
        return "Auto{" + super.getRendszam()+ super.getMinosites() +
                "id=" + id +
                ", hetnapja='" + hetnapja + '\'' +
                '}';
    }
}
