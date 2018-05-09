package tour.operator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AeroportControlleur {
    
    private AeroportModele amd1 = new AeroportModele();;
    private AeroportVue av1 = new AeroportVue();
    private String id= null;
           

    public AeroportControlleur() {      

    }

    public AeroportControlleur(AeroportModele amd1, AeroportVue av1) {
        this.amd1 = amd1;
        this.av1 = av1;
    }
    
    public void ajoutAerop() {

        try {
            boolean verif = recherche(id = av1.verifId());
            if(verif==false){
                av1.affMsg(amd1.ajoutAeroport(av1.ajoutAeroport(id)));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        av1.affListe(amd1.getMesAeroport());
    }
    /**
     * cette methode permet verifier si un objet de type
     * Aeroport existe deja dans la base de donné ou dans le fichier correspondant
     * @param ida correspond a l'identifient de l'aeroport passée en parametre sur le quel 
     * on doit faire la verification
     * @return  un type boolean  true: si l'obljet existe deja et false si pas encore 
     */
    public boolean recherche(String ida) {
        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Aeroport.txt");
        boolean verif=false;
        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String line = br.readLine();
                while ((line != null) && (verif!=true) ) {
                    String[] part = line.split("/");
                    if(ida.equals(part[0])){
                        av1.affMsg("cet aeroport existe deja");
                        verif=true;
                    }
                    line = br.readLine();
                }
                if(verif==false){
                    id=ida;
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return verif;
    }
}
