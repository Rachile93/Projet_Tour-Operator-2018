/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Utilisateur
 */
public class PortModele {

    private List<Port>  mesPort = new ArrayList<>();

    public PortModele() {
    }
    
    public String ajoutPort(Port port1){
        mesPort.add(port1);
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

}
