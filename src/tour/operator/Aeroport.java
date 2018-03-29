
package tour.operator;

import java.io.Serializable;
import java.util.Objects;

public class Aeroport implements Serializable{
    private String idAeroport;
    private String nom;
    private String ville;
    private String pays;
    
    public Aeroport(){
        
    }
    public Aeroport(String idAeroport, String nom, String ville, String pays){
        this.idAeroport=idAeroport;
        this.nom=nom;
        this.ville=ville;
        this.pays=pays;
    }
    
    public void initAeroport(){
       
    }

    public String getIdAeroport() {
        return idAeroport;
    }

    public void setIdAeroport(String idAeroport) {
        this.idAeroport = idAeroport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    public void getAffiche(Object msg){
        System.out.println(msg);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idAeroport);
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.ville);
        hash = 59 * hash + Objects.hashCode(this.pays);
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
        final Aeroport other = (Aeroport) obj;
        if (!Objects.equals(this.idAeroport, other.idAeroport)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.pays, other.pays)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aeroport{" + "idAeroport=" + idAeroport + ", nom=" + nom + ", ville=" + ville + ", pays=" + pays + '}';
    }
}
