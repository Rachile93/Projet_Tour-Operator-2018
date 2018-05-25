package tour.operator.controller;

import tour.operator.vue.PortVue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import tour.operator.modele.*;
import tour.operator.vue.*;

public class PortControlleur {

    private PortModele ptm1 = new PortModele();
    private PortVue pv1 = new PortVue();
    String id = null;

    public PortControlleur() {

    }

    public PortControlleur(PortModele ptm1, PortVue pv1) {
        this.ptm1 = ptm1;
        this.pv1 = pv1;
    }

    public void ajoutPort() {
        boolean verif = recherche(pv1.verifId());
        if (verif == false) {
            pv1.affMsg(ptm1.ajoutPort(pv1.ajoutPort(id)));
        }

    }

    public boolean recherche(String ida) {
        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\port.txt");
        boolean verif = false;
        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String line = br.readLine();
                while ((line != null) && (verif != true)) {
                    String[] part = line.split("/");
                    if (ida.equals(part[0])) {
                        pv1.affMsg("cet aeroport existe deja");
                        verif = true;
                    }
                    line = br.readLine();
                }
                if (verif == false) {
                    id = ida;
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return verif;
    }
}
