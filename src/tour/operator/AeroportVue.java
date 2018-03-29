package tour.operator;

import java.util.*;

public class AeroportVue {

    private Scanner sc = new Scanner(System.in);

    public AeroportVue() {

    }

    public Aeroport initAeroport() {
        String idAeroport = getMsg("Identifiant Aeroport : ");
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

}
