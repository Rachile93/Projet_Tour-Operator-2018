
package tour.operator;

public class VoyageParBateau {
    
    private String idBateau;
    private String portDepart;
    private String portDestination;
    private int heureDepart;
    private int heureArrive;
    private int dateDepart;
    private int dateArrive;
    private double prix;
    private double prixSup;
    
    public VoyageParBateau(){
        
    }

    public VoyageParBateau(String idBateau, String portDepart, String portDestination, int heureDepart, int heureArrive, int dateDepart, int dateArrive, double prix, double prixSup) {
        this.idBateau = idBateau;
        this.portDepart = portDepart;
        this.portDestination = portDestination;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.prix = prix;
        this.prixSup = prixSup;
    }

    

    public String getIdBateau() {
        return idBateau;
    }

    public void setIdBateau(String idBateau) {
        this.idBateau = idBateau;
    }

    public String getPortDepart() {
        return portDepart;
    }

    public void setPortDepart(String portDepart) {
        this.portDepart = portDepart;
    }

    public String getPortDestination() {
        return portDestination;
    }

    public void setPortDestination(String portDestination) {
        this.portDestination = portDestination;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }

    public int getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(int heureArrive) {
        this.heureArrive = heureArrive;
    }

    public int getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(int dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(int dateArrive) {
        this.dateArrive = dateArrive;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrixSup() {
        return prixSup;
    }

    public void setPrixSup(double prixSup) {
        this.prixSup = prixSup;
    }
    @Override
    public String toString() {
        return "VoyageParBateau{" + "idBateau=" + idBateau + ", portDepart=" + portDepart + ", portDestination=" + portDestination + ", heureDepart=" + heureDepart + ", heureArrive=" + heureArrive + ", dateDepart=" + dateDepart + ", dateArrive=" + dateArrive + ", prix=" + prix + ", prixSup=" + prixSup + '}';
    }
    
}
