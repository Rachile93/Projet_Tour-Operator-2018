package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VoyageParVolModele {

    private List<VoyageParVol> mesVol = new ArrayList<>();

    public VoyageParVolModele() {

    }

    public void ajoutDeVol(VoyageParVol v) {

        mesVol.add(v);
        saveInFile(v);
    }

    public List<VoyageParVol> getVol() {
        return mesVol;
    }

    public void setVol(List<VoyageParVol> mesVol) {
        this.mesVol = mesVol;
    }

    @Override
    public String toString() {
        return "VoyageParVolModele{" + "vol=" + mesVol + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.mesVol);
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
        final VoyageParVolModele other = (VoyageParVolModele) obj;
        if (!Objects.equals(this.mesVol, other.mesVol)) {
            return false;
        }
        return true;
    }

    public void saveInFile(VoyageParVol A) {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_en_vol.txt");
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
            fw = new FileWriter(p, true);
            bw = new BufferedWriter(fw);
            bw.write(A.getIdVol());
            bw.write("/");
            bw.write(A.getAeroportDepart());
            bw.write("/");
            bw.write(A.getAeroportDestination());
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
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
