
package tour.operator;
import java.util.*;
public class VoyageParVol {

    private String idVol;
    private String AeroportDepart;
    private String AeroportDestination;
    private int heureDepart;
    private int heureArrive;
    private int dateDepart;
    private int dateArrive;
    private double prix;

    public VoyageParVol() {
    }

    public VoyageParVol(String idVol, String AeroportDepart, String AeroportDestination, int heureDepart, int heureArrive, int dateDepart, int dateArrive, double prix) {
        this.idVol = idVol;
        this.AeroportDepart = AeroportDepart;
        this.AeroportDestination = AeroportDestination;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.prix = prix;
    }

    public String getIdVol() {
        return idVol;
    }

    public void setIdVol(String idVol) {
        this.idVol = idVol;
    }

    public String getAeroportDepart() {
        return AeroportDepart;
    }

    public void setAeroportDepart(String AeroportDepart) {
        this.AeroportDepart = AeroportDepart;
    }

    public String getAeroportDestination() {
        return AeroportDestination;
    }

    public void setAeroportDestination(String AeroportDestination) {
        this.AeroportDestination = AeroportDestination;
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

    @Override
    public String toString() {
        return "VoyageParVol{" + "idVol=" + idVol + ", AeroportDepart=" + AeroportDepart + ", AeroportDestination=" + AeroportDestination + ", heureDepart=" + heureDepart + ", heureArrive=" + heureArrive + ", dateDepart=" + dateDepart + ", dateArrive=" + dateArrive + ", prix=" + prix + '}';
    }
}
