package hu.szamalk.nezet;

import hu.szamalk.modell.Jarmu;
import hu.szamalk.modell.Kolcsonzo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Konzol {
    private Kolcsonzo kolcsonzo;

    private void feladatok(){
        //jarmuvekKonzolon();
        jarmuvekFajlban();
        melyikNaponMelyikAuto();
    }

    private void melyikNaponMelyikAuto() {
    }

    private void jarmuvekFajlban() {
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("adatok.bin"))){
            oos.writeObject(kolcsonzo);
        } catch (FileNotFoundException e) {
            System.out.println("Fájl hiba");
        } catch (IOException e) {
            System.out.println("I/O hiba");
        }
    }

    public void jarmuvekKonzolon() {
        for(Jarmu jarmu :kolcsonzo.getJarmuvek()){
            System.out.println(jarmu.toString());
        }
    }
}
