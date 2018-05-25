
package tour.operator.modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.AbstractTableModel;
import myconnection.DBConnection;
import tour.operator.Aeroport;
import tour.operator.Port;

/**
 *
 * @author Utilisateur
 */
public class AfficheResultatRechercheLieu  extends AbstractTableModel{
    
    private final String[] entetes = {"position", "id_lieu", "nom", "ville", "pays", "type_lieu"};
    private List<Aeroport> aeroport = new ArrayList<>();
    private List<Port> port = new ArrayList<>();
    private String name_lieu = null;
    private AeroportModele aeroportMod = new AeroportModele();

    public AfficheResultatRechercheLieu() {
        super();
        //this.name_lieu=name_lieu;
    }
    public AfficheResultatRechercheLieu(String motRechercher) {
        super();
        //this.name_lieu=name_lieu;
        aeroportMod.rechercheAeroport(motRechercher);
        
    }
    @Override
    public int getColumnCount() {
        return entetes.length;
    }
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return aeroport.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        switch (columnIndex) {

            case 0:
                // Nom
                return rowIndex + 1;

            case 1:
                // Prenom
                if (name_lieu.equals("port")) {
                    return port.get(rowIndex).getIdPort();
                }
                return aeroport.get(rowIndex).getIdAeroport();

            case 2:
                // Annee
                if (name_lieu.equals("port")) {
                    return port.get(rowIndex).getNom();
                }
                return aeroport.get(rowIndex).getNom();

            case 3:
                // Sexe
                if (name_lieu.equals("port")) {
                    return port.get(rowIndex).getVille();
                }
                return aeroport.get(rowIndex).getVille();

            case 4:
                // Note au controle
                if (name_lieu.equals("port")) {
                    return port.get(rowIndex).getPays();
                }
                return aeroport.get(rowIndex).getPays();
            case 5:
                // Note au controle
                if (name_lieu.equals("port")) {
                    return port.get(rowIndex).getType_lieu();
                }
                return aeroport.get(rowIndex).getType_lieu();
            default:
                // throw new IllegalArgumentException();
                return "";
        }
    }

    /* @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {

            case 0:
            case 1:
                return String.class;

            case 2:
                //return Sexe.class;
                return String.class;

            case 3:
                return String.class;
            // return Integer.class;

            case 4:
                return String.class;
            //  return Double.class;

            default:
                return String.class;
            //return Object.class;
        }
    }*/
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Aeroport> getAeroport() {
        return aeroport;
    }
   
    
}
