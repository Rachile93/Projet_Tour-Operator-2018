
package tour.operator;

public class Voyage {
    private int idVoyage;
    private String typeVoyage;

    public Voyage() {
    }
    
    public Voyage(int idVoyage, String typeVoyage){
        this.idVoyage=idVoyage;
        this.typeVoyage=typeVoyage;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getTypeVoyage() {
        return typeVoyage;
    }

    public void setTypeVoyage(String typeVoyage) {
        this.typeVoyage = typeVoyage;
    }
}
