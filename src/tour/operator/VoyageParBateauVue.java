package tour.operator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class VoyageParBateauVue {

    Scanner sc = new Scanner(System.in);
    private List<Port> port = new ArrayList<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyy");

    public VoyageParBateauVue() {

    }

    public VoyageParBateau ajouterVoyBateau(String id) {
        // readInFile();

        String idBateau = id ;
        affMsg("port de depart : ");
        affListe(port);
        String portDepart = getChoix("choisissez un numero :  ");
        affMsg("port de destination : ");
        affListe(port);
        String portDestination = getChoix("choisissez un numero :  ");
        LocalTime heureDepart = LocalTime.parse(getMsg("heure depart du bateau : "));
        LocalTime heureArrive = LocalTime.parse(getMsg("Heure Arrive du bateau : "));
        LocalDate dateDepart = LocalDate.parse(getMsg("date de depart : "), dtf);
        LocalDate dateArrive = LocalDate.parse(getMsg("date arrivee : "), dtf);
        double prix = Double.parseDouble(getMsg("prix : "));
        double prixSup = Double.parseDouble(getMsg("prix supl: "));
        VoyageParBateau vBateau = new VoyageParBateau(idBateau, portDepart, portDestination, heureDepart, heureArrive, dateDepart, dateArrive, prix, prixSup);

        return vBateau;

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
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Port.txt");
        Port p2 = new Port();
        try {
            FileReader fr = new FileReader(p);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p)));
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                //System.out.println(line);
                String[] part = line.split("/");
                p2.setIdPort(part[0]);
                p2.setNom(part[1]);
                p2.setVille(part[2]);
                p2.setPays(part[3]);
                port.add(p2);
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
            if (n > 0 && n <= port.size()) {
                verif = true;
            }
        } while (false);

        return port.get(n-1).getNom();
    }

    public String verifId() {
        boolean verif = false;
        String id = null;
        do {
            int n = 0, i = 0;
            verif = false;
            id = getMsg("identifiant du bateau");
            char[] c = id.toLowerCase().toCharArray();
            if (c.length == 5) {
                for (char l : c) {
                    if (i < 2) {
                        if (l >= '0' && l <= '9') {
                            n++;
                        }
                        i++;
                    } else {
                        if (i < 5) {
                            if (l >= 'a' && l <= 'z') {
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
