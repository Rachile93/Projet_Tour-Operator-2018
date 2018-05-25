
package tour.operator;

import java.util.Objects;

public class Port {

    private String idPort;
    private String nom;
    private String ville;
    private String pays;
    private String type_lieu;

    public Port() {

    }
    /**
     * cette methode permet de creer un objet de type port 
     * @param idPort identifient du port code alpha numerique de 2 chiffre et 3 lettre
     * @param nom nom de l'earoport 
     * @param ville lieu de localisation 
     * @param pays  pays de localisation
     */
    public Port(String idPort, String nom, String ville, String pays) {
        this.idPort = idPort;
        this.nom = nom;
        this.ville = ville;
        this.pays = pays;
        this.type_lieu = "port";
    }

    public String getType_lieu() {
        return type_lieu;
    }

    public void setType_lieu(String type_lieu) {
        this.type_lieu = type_lieu;
    }

    public String getIdPort() {
        return idPort;
    }

    public void setIdPort(String idPort) {
        this.idPort = idPort;
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

  
    public void getAffiche(Object msg) {
        System.out.println(msg);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idPort);
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
        final Port other = (Port) obj;
        if (!Objects.equals(this.idPort, other.idPort)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Port{" + "idPort=" + idPort + ", nom=" + nom + ", ville=" + ville + ", pays=" + pays + '}';
    }
}
