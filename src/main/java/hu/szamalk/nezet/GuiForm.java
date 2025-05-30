package hu.szamalk.nezet;

import hu.szamalk.modell.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class GuiForm {
    private JFrame frame;
    private JList list1;
    private JPanel plnMain;
    private JComboBox comboBox;
    private JButton átmásolButton;
    private JButton átmozgatButton;
    private JButton btnUjAuto;
    private JMenu mnuBeolvas;
    private JMenu mnuKilepes;

    public GuiForm(){
        ini();
        btnUjAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kolcsonzo kolcsonzo = new Kolcsonzo();
                Auto ujAuto = new Auto("bbb-111", Minosites.ATLAGOS,"szerda");
                kolcsonzo.addJarmu(ujAuto);
                comboBox.addItem(ujAuto.getRendszam()+"(autó)");
            }
        });
    }

    private void ini() {
        frame = new JFrame("Program");
        frame.setContentPane(plnMain);
        frame.setSize(320,240);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                kilepes();
            }

        });

        DefaultListModel<String> dlm = new DefaultListModel<>();
        list1.setModel(dlm);

        mnuBeolvas = new JMenu("Beolvas");
        mnuKilepes = new JMenu("Kilépés");
        JMenu menu = new JMenu("Program");
        menu.add(mnuBeolvas);
        menu.add(new JSeparator());
        menu.add(mnuKilepes);
        JMenuBar mnubar = new JMenuBar();
        mnubar.add(menu);
        frame.setJMenuBar(mnubar);
        frame.pack();

        mnuBeolvas.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser(new File(System.getProperty("user.dir")));
            if(jfc.showOpenDialog(null) == jfc.APPROVE_OPTION){
                File fajl = jfc.getSelectedFile();
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fajl))){
                    Kolcsonzo kolcsonzo = (Kolcsonzo) ois.readObject();
                    for(Jarmu jarmuvek: kolcsonzo.getJarmuvek()){
                        if(jarmuvek instanceof Auto){
                            comboBox.addItem(jarmuvek.getRendszam()+"(Auto)");
                        }
                        if(jarmuvek instanceof Hajo){
                            comboBox.addItem(jarmuvek.getRendszam()+"(Auto)");
                        }
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Fájl hiba");
                } catch (IOException ex) {
                    System.out.println("I/O hiba");
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        mnuKilepes.addActionListener(e -> {
            JFrame felugro = new JFrame();
            felugro.setSize(300,200);
            kilepes();
        });
    }




    private void kilepes() {
        String msg = "Biztos kilép?";
        String cim = "KILÉPÉS";
        int opt = JOptionPane.YES_NO_OPTION;
        int gomb = JOptionPane.showConfirmDialog(null,msg,cim,opt);
        if (gomb == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new GuiForm();
    }
}
