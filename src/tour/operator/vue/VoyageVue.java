package tour.operator.vue;

import java.util.*;
import tour.operator.TypeVoyage;
import tour.operator.Voyage;

public class VoyageVue {

    private Scanner sc = new Scanner(System.in);

    public VoyageVue() {
        System.out.println("BIEN VENU CHEZ TOUR OPERATOR ");
    }

    public Voyage ajoutVoyage(int id) {
        int idVoyage = id;
        typeVoyList();
        TypeVoyage typeVoyage = getChoix("Quelle type de voyage ? (choisissez un numero)");

        Voyage v1 = new Voyage(idVoyage, typeVoyage);

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

    public void typeVoyList() {
        int i = 1;
        for (TypeVoyage t : TypeVoyage.values()) {
            System.out.println(i + " - " + t);
            i++;
        }
    }

    public TypeVoyage getChoix(String s) {
        boolean verif = false;
        TypeVoyage tp = null;
        do {
            int n = Integer.parseInt(getMsg(s));
            verif = false;
            if (n > 0 && n <= 3) {
                switch (n) {
                    case 1:
                        tp = TypeVoyage.loisir;
                        break;
                    case 2:
                        tp = TypeVoyage.sport;
                         break;
                    case 3:
                        tp = TypeVoyage.avanture;
                        break;
                }
                verif = true;
            } else {
                affMsg("erreur....... ");
            }
        } while (verif == false);
        return tp;
    }

    public String verifId() {
        boolean verif = false;
        String id = null;
        do {
            int n = 0;
            verif = false;
            id = getMsg("identifient du voyage(numerique) : ");
            char[] c = id.toLowerCase().toCharArray();
            for (char l : c) {
                if (l >= '0' && l <= '9') {
                    n++;
                }
            }
            affMsg(c.length);
            if (n==c.length) {
                verif=true;
                affMsg("verification ok");
            }else{
                 affMsg("erreur");
            }

        } while (verif == false);

        return id;
    }

}
