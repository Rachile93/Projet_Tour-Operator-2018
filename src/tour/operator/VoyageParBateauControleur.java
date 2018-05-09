
package tour.operator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class VoyageParBateauControleur {

    private VoyageParBateauModele voyBatMod = new VoyageParBateauModele();
    private VoyageParBateauVue voyBatVue = new VoyageParBateauVue();
    String  id = null;

    public VoyageParBateauControleur() {
    }

    public void  ajout(){
        boolean verif = recherche(id = voyBatVue.verifId());
        if(verif == false){
            voyBatMod.ajouterVoyageBateau(voyBatVue.ajouterVoyBateau(id));
        }     
    }
     public boolean recherche(String ida) {
        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_par_bateau.txt");
        boolean verif = false;
        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String line = br.readLine();
                while ((line != null) && (verif != true)) {
                    String[] part = line.split("/");
                    if (ida.equals(part[0])) {
                        voyBatVue.affMsg("cet aeroport existe deja");
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
