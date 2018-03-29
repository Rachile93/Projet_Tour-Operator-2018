
package tour.operator;

import java.util.*;

public class PortVue {
    private Scanner sc = new Scanner(System.in);

    public PortVue() {

    }

    public Port initPort() {
        String idPort = getMsg("Identifiant  du Port : ");
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
}
