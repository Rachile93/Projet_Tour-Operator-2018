/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.operator;

/**
 *
 * @author Utilisateur
 */
public class Voyagecontroller {
    
    private Vue vue1= null;
    private VoyageModele voyMd1= null;
    
    public Voyagecontroller(){
        
    }
    public void ajoutVoy(){
        vue1 = new Vue();
        voyMd1 = new VoyageModele();
        vue1.affMsg(voyMd1.ajoutVoyage(vue1.initVoyage()));
    }

    @Override
    public String toString() {
        return "Voyagecontroller{" + "vue1=" + vue1 + ", voyMd1=" + voyMd1 + '}';
    }
   
}
