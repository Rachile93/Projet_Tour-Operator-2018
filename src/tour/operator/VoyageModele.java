package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VoyageModele {

    private List<Voyage> mesVoyges = new ArrayList<>();

    public VoyageModele() {

    }

    public String ajoutVoyage(Voyage v1) {
        mesVoyges.add(v1);
        saveInFileVoyage(v1);
     //  readsInFileVoyage();
        String msg = " enregistrement ok ";
        return msg;
    }

    public List<Voyage> getMesVoyges() {
        return mesVoyges;
    }

    public void setMesVoyges(List<Voyage> mesVoyges) {
        this.mesVoyges = mesVoyges;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.mesVoyges);
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
        final VoyageModele other = (VoyageModele) obj;
        if (!Objects.equals(this.mesVoyges, other.mesVoyges)) {
            return false;
        }
        return true;
    }

    public void saveInFileVoyage(Voyage v) {
        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
       

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {

            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);

            bw.write(String.valueOf(v.getIdVoyage()));
            bw.write("/");
            bw.write(v.getTypeVoyage().toString());

            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

}
