
package tour.operator;

public class DetailVoyageController {
    private DetailVoyageVue dtVgVue = new DetailVoyageVue();
    private DetailVoyageModele dtVgMod = new DetailVoyageModele();
    
    public void ajoutDetail(int idvoyage){
        dtVgMod.ajoutDetail(dtVgVue.ajouterDetail(idvoyage));
    }
}
