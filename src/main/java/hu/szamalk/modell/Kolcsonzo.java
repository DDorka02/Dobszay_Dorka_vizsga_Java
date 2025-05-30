package hu.szamalk.modell;

import java.util.ArrayList;
import java.util.List;

public class Kolcsonzo {
    private List<String> jarmuvek = new ArrayList<>();


    public List<String> getJarmuvek() {
        return jarmuvek;
    }

    public void addJarmu(Jarmu jarmu) {
        jarmuvek.add(String.valueOf(jarmu));
    }
}
