
package tour.operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class Menu {

    private Scanner sc = new Scanner(System.in);
    private AeroportControlleur aerp = new AeroportControlleur();
    private PortControlleur pc = new PortControlleur();
    private VoyageController voyCon = new VoyageController();
    private VoyageParBateauControleur voyBatCon = new VoyageParBateauControleur();
    private VoyageParVolControlleur voyVolCon = new VoyageParVolControlleur();
    public Menu() {
        navigationMenuPrincipale(menuPrincipale());
    }

    public int menuPrincipale() {
        List<String> listeItems = new ArrayList<>(Arrays.asList(
                "Ajout",
                "Modification",
                "Recherche",
                "Supression",
                "Fin"));
        affListe(listeItems);

        int ch;
        do {
            String chs = getMsg("votre choix");
            ch = Integer.parseInt(chs);
            if (ch > 0 && ch <= listeItems.size()) {
                break;
            }
            affMsg("choix incorrect");
        } while (true);
        return ch;
    }

    public int menuAjout() {
        List<String> listeItems = new ArrayList<>(Arrays.asList(
                "Ajouter un voyage",
                "Ajouter un Aeroport",
                "Ajouter un port",
                "Ajouter un vol",
                "Ajouter un deplacement en bateau",
                "fin"));
        affListe(listeItems);

        int ch;
        do {
            String chs = getMsg("votre choix");
            ch = Integer.parseInt(chs);
            if (ch > 0 && ch <= listeItems.size()) {
                break;
            }
            affMsg("choix incorrect");
        } while (true);
        return ch;
    }

    public void navigationMenuPrincipale(int i) {
        switch (i) {
            case 1:
                navigationMenuAjout(menuAjout());
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                affMsg("fin du programme");
                break;
        }

    }

    public void navigationMenuAjout(int i) {
        switch (i) {
            case 1:
                voyCon.ajoutVoy();
                break;
            case 2:
                aerp.ajoutAerop();
                break;
            case 3:
                pc.ajoutPort();
                break;
            case 4:
                voyVolCon.ajout();
                break;
            case 5:
                voyBatCon.ajout();
                break;
            case 6:
                affMsg("fin du programme");
                break;
        }
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
