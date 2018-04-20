package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class AeroportModele implements Serializable {

    private List<Aeroport> mesAeroport = new ArrayList<>();

    public AeroportModele() {

    }

    public String ajoutAeroport(Aeroport aeroport1) {
        mesAeroport.add(aeroport1);
        saveInFile(aeroport1);
        String msg = "ok";
        return msg;
    }

    public void rechercheAeroport() {

    }

    public void moidifierAeroport() {

    }

    public void suprimerAeroport() {

    }

    public List<Aeroport> getMesAeroport() {
        return mesAeroport;
    }

    public void setMesAeroport(List<Aeroport> mesAeroport) {
        this.mesAeroport = mesAeroport;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.mesAeroport);
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
        final AeroportModele other = (AeroportModele) obj;
        if (!Objects.equals(this.mesAeroport, other.mesAeroport)) {
            return false;
        }
        return true;
    }

    public void saveInFile(Aeroport A) {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Aeroport.txt");
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
            bw.write(A.getIdAeroport());
            bw.write("/");
            bw.write(A.getNom());
            bw.write("/");
            bw.write(A.getVille());
            bw.write("/");
            bw.write(A.getPays());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
