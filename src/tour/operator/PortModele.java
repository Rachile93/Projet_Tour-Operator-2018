
package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PortModele {

    private List<Port>  mesPort = new ArrayList<>();

    public PortModele() {
    }
    
    public String ajoutPort(Port port1){
        mesPort.add(port1);
        saveInFile(port1);
        String msg = "ok";
        return msg;
    }
    
    public void recherchePort(){
        
    }
    
    public void moidifierPort(){
        
    }
    
    public void suprimerPort(){
        
    }

    public List<Port> getMesPort() {
        return mesPort;
    }

    public void setMesPort(List<Port> mesPort) {
        this.mesPort = mesPort;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.mesPort);
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
        final PortModele other = (PortModele) obj;
        if (!Objects.equals(this.mesPort, other.mesPort)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PortModele{" + "mesPort=" + mesPort + '}';
    }
    public void saveInFile(Port P) {

        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\port.txt");
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
            bw.write(P.getIdAeroport());
            bw.write("/");
            bw.write(P.getNom());
            bw.write("/");
            bw.write(P.getVille());
            bw.write("/");
            bw.write(P.getPays());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
