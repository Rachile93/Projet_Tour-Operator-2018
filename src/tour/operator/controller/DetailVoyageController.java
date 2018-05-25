
package tour.operator.controller;

import tour.operator.vue.DetailVoyageVue;
import tour.operator.modele.*;
import tour.operator.vue.*;

public class DetailVoyageController {
    private DetailVoyageVue dtVgVue = new DetailVoyageVue();
    private DetailVoyageModele dtVgMod = new DetailVoyageModele();
    
    public void ajoutDetail(int idvoyage){
        dtVgMod.ajoutDetail(dtVgVue.ajouterDetail(idvoyage));
    }
}
