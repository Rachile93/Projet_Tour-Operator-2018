
package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class VoyageParBateauModele {
   List<VoyageParBateau>  mesVoyBateau= new ArrayList<>();

    public VoyageParBateauModele() {
    }
    
    public void ajouterVoyageBateau(VoyageParBateau v){
        mesVoyBateau.add(v);
    }

    @Override
    public String toString() {
        return "VoyageParBateauModele{" + "mesVoyBateau=" + mesVoyBateau + '}';
    }

    public List<VoyageParBateau> getMesVoyBateau() {
        return mesVoyBateau;
    }

    public void setMesVoyBateau(List<VoyageParBateau> mesVoyBateau) {
        this.mesVoyBateau = mesVoyBateau;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.mesVoyBateau);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VoyageParBateauModele other = (VoyageParBateauModele) obj;
        if (!Objects.equals(this.mesVoyBateau, other.mesVoyBateau)) {
            return false;
        }
        return true;
    }
    public void saveInFile(VoyageParBateau A) {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_en_bateau.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        if (!p.exists()) {
            try {
                p.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            bw = new BufferedWriter(new FileWriter(p, true));
            bw.write(A.getIdBateau());
            bw.write("/");
            bw.write(A.getPortDepart());
            bw.write("/");
            bw.write(A.getPortDestination());
            bw.write("/");
            bw.write(A.getHeureDepart().toString());
            bw.newLine();
            bw.write(A.getHeureArrive().toString());
            bw.newLine();
            bw.write(A.getDateDepart().toString());
            bw.newLine();
            bw.write(A.getDateArrive().toString());
            bw.newLine();
            bw.write(String.valueOf(A.getPrix()));
            bw.newLine();
             bw.write(String.valueOf(A.getPrixSup()));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   
}
