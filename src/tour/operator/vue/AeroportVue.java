package tour.operator.vue;

import java.util.*;
import tour.operator.Aeroport;
/**
 * @
 * @author Utilisateur
 */

public class AeroportVue {

    private Scanner sc = new Scanner(System.in);

    public AeroportVue() {

    }

    public Aeroport ajoutAeroport(String id) {
        String idAeroport = id;
        //Scanner s=new Scanner(idAeroport);
        String nom = getMsg("Nom Aeroport : ");
        String ville = getMsg("Ville : ");
        String pays = getMsg("Pays : ");

        Aeroport Aer1 = new Aeroport(idAeroport, nom, ville, pays);

        return Aer1;
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
            id = getMsg("identifiant du Aeroport (veuilez saisir un id de 3 chiffres et 3 lettres ):");
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
                affMsg("verification ok");
            } else {
                affMsg("erreur");
            }

        } while (verif == false);
        return id;
    }

}
