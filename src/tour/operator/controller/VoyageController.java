
package tour.operator.controller;

import tour.operator.vue.VoyageVue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import tour.operator.modele.*;
import tour.operator.vue.*;

public class VoyageController {

    private VoyageVue voyVue = new VoyageVue();
    private VoyageModele voyMod = new VoyageModele();
    int id;

    public VoyageController() {

    }

    public void ajoutVoy() {
        boolean verif= recherche( voyVue.verifId());
        if(verif == false ){
            voyVue.affMsg(voyMod.ajoutVoyage(voyVue.ajoutVoyage(id)));
        }
        
    }

    public boolean recherche(String ida) {
        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage.txt");
        boolean verif = false;
        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String line = br.readLine();
                while ((line != null) && (verif != true)) {
                    String[] part = line.split("/");
                    if (ida.equals(part[0])) {
                        voyVue.affMsg("ce voyage existe deja");
                        verif = true;
                    }
                    line = br.readLine();
                }
                if (verif == false) {
                    id = Integer.parseInt(ida);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return verif;
    }

  

}
