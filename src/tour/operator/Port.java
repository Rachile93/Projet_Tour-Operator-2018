
package tour.operator;

public class Port {

    private String idPort;
    private String nom;
    private String ville;
    private String pays;

    public Port() {

    }

    public Port(String idPort, String nom, String ville, String pays) {
        this.idPort = idPort;
        this.nom = nom;
        this.ville = ville;
        this.pays = pays;
    }

    public void initAeroport() {

    }

    public String getIdAeroport() {
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
    public String toString() {
        return "Port{" + "idPort=" + idPort + ", nom=" + nom + ", ville=" + ville + ", pays=" + pays + '}';
    }
}
