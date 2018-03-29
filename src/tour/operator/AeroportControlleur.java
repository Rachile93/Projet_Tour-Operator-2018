
package tour.operator;

import java.io.IOException;

public class AeroportControlleur {
    private AeroportModele amd1 = null ;
    private AeroportVue av1 = null;
    
    public AeroportControlleur(){
        
    }
    public AeroportControlleur(AeroportModele amd1,AeroportVue av1){
        this.amd1=amd1;
        this.av1=av1;
    }
    
    public void ajoutAerop() throws IOException, ClassNotFoundException{
       
        amd1 = new AeroportModele();
        av1 = new AeroportVue();
        av1.affMsg(amd1.ajoutAeroport(av1.initAeroport())); 
        av1.affListe(amd1.getMesAeroport());
    }
}
