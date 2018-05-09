package tour.operator;

import java.util.Objects;

public class DetailVoyage {

    private int idVoyage = 0;
    private int position = 0;
    private String id = null; // represente l'identifient du vol ou du bateau;
    
    int indice =  0;

   
    public DetailVoyage() {

    }

    public DetailVoyage(int idVoyage,int position,String id) {
        this.idVoyage=idVoyage;
        this.position=position;
        this.id=id;
    }
     public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idVoyage);
        hash = 23 * hash + this.position;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final DetailVoyage other = (DetailVoyage) obj;
        if (this.position != other.position) {
            return false;
        }
        if (!Objects.equals(this.idVoyage, other.idVoyage)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetailVoyage{" + "idVoyage=" + idVoyage + ", position=" + position + ", id=" + id + '}';
    }

}
