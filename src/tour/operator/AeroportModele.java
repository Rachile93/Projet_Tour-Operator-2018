package tour.operator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeroportModele implements Serializable {

    private List<Aeroport> mesAeroport = new ArrayList<>();

    public AeroportModele() {

    }

    public String ajoutAeroport(Aeroport aeroport1) throws IOException, ClassNotFoundException {
        readInFile();
        mesAeroport.add(aeroport1);
        try {
            saveInFile(aeroport1);
        } catch (IOException ex) {
            Logger.getLogger(AeroportModele.class.getName()).log(Level.SEVERE, null, ex);
        }

        //  readInFile();
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

    public void saveInFile(Aeroport A) throws IOException {
        File p = new File("Aeroport_file.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(p,true)));
        oos.writeObject(A);
        oos.close();
    }

    public void readInFile() throws IOException, ClassNotFoundException {
        File p = new File("Aeroport_file.txt");
        FileInputStream fis = new FileInputStream(p);
        try (ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(fis))) {
            Aeroport retn=new Aeroport();
            retn = (Aeroport) oos.readObject();
            System.out.println(retn);
            retn = (Aeroport) oos.readObject();
            System.out.println(retn);
           // retn = (Aeroport) oos.readObject();
           // System.out.println(retn);
            
           // int n=0;
            /*while ( n != -1) {
                n=fis.available();
                retn = (Aeroport) oos.readObject();
                System.out.println(retn);
            }*/
        }
    }

}
