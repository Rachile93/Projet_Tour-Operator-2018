package tour.operator;

import java.util.*;

public class Vue {

    private Scanner sc = new Scanner(System.in);

    public Vue() {
        System.out.println("BIEN VENU CHEZ TOUR OPERATOR ");
    }

    public Voyage initVoyage() {
        int idVoyage = Integer.parseInt(getMsg("identifient du voyage : "));
        String typeVoyage = getMsg("quelle type de Voyage ? ");

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

}
