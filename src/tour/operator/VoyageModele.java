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
public class VoyageModele {
    private  List<Voyage> mesVoyges= new ArrayList<>();
    
    public VoyageModele(){
        
    }
    
     public String  ajoutVoyage(Voyage v1){
        mesVoyges.add(v1);
        String msg=" enregistrement ok ";
        return msg;  
    }

    public List<Voyage> getMesVoyges() {
        return mesVoyges;
    }

    public void setMesVoyges(List<Voyage> mesVoyges) {
        this.mesVoyges = mesVoyges;
    }
   

  
    
}
