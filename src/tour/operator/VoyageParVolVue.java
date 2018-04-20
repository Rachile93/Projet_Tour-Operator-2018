package tour.operator;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.time.format.DateTimeFormatter;

public class VoyageParVolVue {

    Scanner sc = new Scanner(System.in);
    private List<Aeroport> a1 = new ArrayList<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");

    public VoyageParVolVue() {

    }

    public VoyageParVol ajouterVol(String id) {
        readInFile();
        // VoyageParVol v1 = new VoyageParVol();

        String idVol = id;
        affMsg("Aeroport de depart : ");
        affListe(a1);
        String AeroportDepart = getChoix("choisissez un numero :  ");
        affMsg("Aeroport de destination : ");
        affListe(a1);
        String AeroportDestination = getChoix("choisissez un numero :  ");
        LocalTime heureDepart = LocalTime.parse(getMsg("heure depart du vol : "));
        LocalTime heureArrive = LocalTime.parse(getMsg("Heure Arrive du vol : "));
        LocalDate dateDepart = LocalDate.parse(getMsg("date de depart : "), dtf);
        LocalDate dateArrive = LocalDate.parse(getMsg("date arrivee : "), dtf);
        double prix = Double.parseDouble(getMsg("prix : "));

        VoyageParVol v1 = new VoyageParVol(idVol, AeroportDepart, AeroportDestination, heureDepart, heureArrive, dateDepart, dateArrive, prix);

        return v1;

    }

    public String getMsg() {
        String msg = sc.nextLine();
        return msg;
    }

    public void affMsg(Object msg) {
        System.out.println(msg);
    }

    public String getMsg(String msg) {//surcharge de la méthode getMsg
        affMsg(msg);
        return getMsg();
    }

    public void affListe(Collection liste) {
        int i = 1;
        for (Object o : liste) {
            affMsg((i++) + "." + o);
        }
    }

    public void readInFile() {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Aeroport.txt");
        Aeroport arp2 = new Aeroport();
        try {
            FileReader fr = new FileReader(p);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p)));
            String line = br.readLine();
            // System.out.println("N°  NomAeroport");
            int i = 0;
            while (line != null) {
                //System.out.println(line);
                String[] part = line.split("/");
                arp2.setIdAeroport(part[0]);
                arp2.setNom(part[1]);
                arp2.setVille(part[2]);
                arp2.setPays(part[3]);
                a1.add(arp2);
                line = br.readLine();
                i++;
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getChoix(String s) {
        int n = 0;
        boolean verif = false;
        do {
            verif = false;
            n = Integer.parseInt(getMsg(s));
            affMsg(a1.size());
            if (n > 0 && n <= a1.size()) {
                verif = true;
            }
        } while (verif == false);

        return a1.get(n-1).getNom();
    }

    public String verifId() {
        boolean verif = false;
        String id = null;
        do {
            int n = 0, i = 0;
            verif = false;
            id = getMsg("identifiant du vol");
            char[] c = id.toLowerCase().toCharArray();
            if (c.length == 6) {
                for (char l : c) {
                    if (i < 3) {
                        if (l >= 'a' && l <= 'z') {
                            n++;
                        }
                        i++;
                    } else {
                        if (i < 6) {

                            if (l >= '0' && l <= '9') {
                                n++;
                            }
                            i++;
                        }
                    }

                }
            }
            affMsg(c.length);
            if (n == c.length) {
                verif = true;
            } else {
                affMsg("erreur");
            }

        } while (verif == false);

        return id;
    }
}
