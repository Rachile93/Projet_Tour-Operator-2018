package tour.operator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class VoyageParBateau {

    private String idBateau;
    private String portDepart;
    private String portDestination;
    private LocalTime heureDepart;
    private LocalTime heureArrive;
    private LocalDate dateDepart;
    private LocalDate dateArrive;
    private double prix;
    private double prixSup;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyy");

    public VoyageParBateau() {

    }

    public VoyageParBateau(String idBateau, String portDepart, String portDestination, LocalTime heureDepart, LocalTime heureArrive, LocalDate dateDepart, LocalDate dateArrive, double prix, double prixSup) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idBateau);
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
        final VoyageParBateau other = (VoyageParBateau) obj;
        if (!Objects.equals(this.idBateau, other.idBateau)) {
            return false;
        }
        return true;
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

    public double getPrixSup() {
        return prixSup;
    }

    public void setPrixSup(double prixSup) {
        this.prixSup = prixSup;
    }

    @Override
    public String toString() {
        return "VoyageParBateau{" + "idBateau=" + idBateau + ", portDepart=" + portDepart + ", portDestination=" + portDestination + ", heureDepart=" + heureDepart.toString() + ", heureArrive=" + heureArrive.toString() + ", dateDepart=" + dateDepart.format(dtf) + ", dateArrive=" + dateArrive.format(dtf) + ", prix=" + prix + ", prixSup=" + prixSup + '}';
    }

}
