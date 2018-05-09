package tour.operator;

import java.util.Objects;

public class Voyage {

    private int idVoyage;
    private TypeVoyage typeVoyage;

    public Voyage() {
        
    }
    /**
     * cette methode permet de contruire un objet de type voyage 
     * @param idVoyage identifient du voyage code numerique 
     * @param typeVoyage  type de voyage (loisir,sport,aventure)
     */
    public Voyage(int idVoyage, TypeVoyage typeVoyage) {
        this.idVoyage = idVoyage;
        this.typeVoyage = typeVoyage;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public TypeVoyage getTypeVoyage() {
        return typeVoyage;
    }

    public void setTypeVoyage(TypeVoyage typeVoyage) {
        this.typeVoyage = typeVoyage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idVoyage;
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
        final Voyage other = (Voyage) obj;
        if (this.idVoyage != other.idVoyage) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Voyage{" + "idVoyage=" + idVoyage + ", typeVoyage=" + typeVoyage + '}';
    }
}
