package tour.operator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class VoyageParVol {

    private String idVol;
    private String AeroportDepart;
    private String AeroportDestination;
    private LocalTime heureDepart;
    private LocalTime heureArrive;
    private LocalDate dateDepart;
    private LocalDate dateArrive;
    private double prix;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");

    public VoyageParVol() {
    }
    /**
     * contructeur qui permet de creer un objet de voyage en avion 
     * @param idVol identifient du vol
     * @param AeroportDepart nom de l'aeroport depart du vol
     * @param AeroportDestination  nom de l'aeroport destination du vol
     * @param heureDepart heure depart du vol
     * @param heureArrive heure d'arriver du vol
     * @param dateDepart date de depart du vol
     * @param dateArrive date d'arriver du vol
     * @param prix  prix du trajet 
     */
    public VoyageParVol(String idVol, String AeroportDepart, String AeroportDestination, LocalTime heureDepart, LocalTime heureArrive, LocalDate dateDepart, LocalDate dateArrive, double prix) {
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

    public String getAeroportDepart(){
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

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(LocalTime heureArrive) {
        this.heureArrive = heureArrive;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDate getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(LocalDate dateArrive) {
        this.dateArrive = dateArrive;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idVol);
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
        final VoyageParVol other = (VoyageParVol) obj;
        if (!Objects.equals(this.idVol, other.idVol)) {
            return false;
        }
        return true;
    }

  
    

    @Override
    public String toString() {
        return "VoyageParVol{" + "idVol=" + idVol + ", AeroportDepart=" + AeroportDepart + ", AeroportDestination=" + AeroportDestination + ", heureDepart=" + heureDepart.toString() + ", heureArrive=" + heureArrive.toString() + ", dateDepart=" + dateDepart.format(dtf) + ", dateArrive=" + dateArrive.format(dtf) + ", prix=" + prix + '}';
    }

}
