package tour.operator;

import java.util.*;

public class PortVue {

    private Scanner sc = new Scanner(System.in);

    public PortVue() {

    }

    public Port ajoutPort(String id) {
        String idPort = id;
        String nom = getMsg("Nom : ");
        String ville = getMsg("Ville : ");
        String pays = getMsg("Pays : ");

        Port prt1 = new Port(idPort, nom, ville, pays);
        return prt1;
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

    public String verifId() {
        boolean verif = false;
        String id = null;
        do {
            int n = 0, i = 0;
            verif = false;
            id = getMsg("identifiant du port (veuilez saisir un id de 3 chiffres et 3 lettres ) : ");
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
