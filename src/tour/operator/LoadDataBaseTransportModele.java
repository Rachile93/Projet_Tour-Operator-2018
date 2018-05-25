package tour.operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.AbstractTableModel;
import myconnection.DBConnection;

public final class LoadDataBaseTransportModele extends AbstractTableModel {

    private final String[] entetes = {"N°", "id transport", "lieu depart", "lieu arrive", "heure depart", "heure arrive", "date depart", "date arrive", "prix", "prix sup", "type transport"};
    private List<VoyageParVol> vol = new ArrayList<>();
    private List<VoyageParBateau> bateau = new ArrayList<>();

    public LoadDataBaseTransportModele() {
        super();
        loadDataBaseTransport();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return vol.size();
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

                return vol.get(rowIndex).getIdVol();

            case 2:
                // Annee
                return vol.get(rowIndex).getAeroportDepart();

            case 3:
                // Sexe
                return vol.get(rowIndex).getAeroportDestination();

            case 4:
                // Note au controle
                return vol.get(rowIndex).getHeureDepart();

            case 5:
                // Note au controle
                return vol.get(rowIndex).getHeureArrive();
            case 6:
                // Note au controle
                return vol.get(rowIndex).getDateDepart();
                        
            case 7:
                // Note au controle
                return vol.get(rowIndex).getDateArrive();
            case 8:
                // Note au controle
                return vol.get(rowIndex).getPrix();
            case 9:
                // Note au controle
              //  return vol.get(rowIndex).getPays();
            case 10:
                // Note au controle
              //  return vol.get(rowIndex).getPays();

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

    public List<VoyageParVol> getVol() {
        return vol;
    }


    public void loadDataBaseTransport() {
        //  System.out.println("ok1");

        boolean verif = false;
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        //System.out.println("connexion établie");
        try {
            // int colNo = rsmd.getColumnCount();
            String query1 = "select * from transport ";
            pstm1 = dbConnect.prepareStatement(query1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = pstm1.executeQuery();
            while (rs.next()) {
                VoyageParVol vol1 = new VoyageParVol(rs.getString(1), rs.getString(2), rs.getString(3),LocalTime.parse(rs.getTime(4).toString()),LocalTime.parse(rs.getTime(5).toString()), LocalDate.parse(rs.getDate(6).toString()), LocalDate.parse(rs.getDate(7).toString()), rs.getDouble(8));
                vol.add(vol1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //finalement fermer les ressources
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("erreur de fermeture de resultset " + e);
            }
            try {
                if (pstm1 != null) {
                    pstm1.close();
                }
            } catch (SQLException e) {
                System.out.println("erreur de fermeture de statement " + e);
            }
            DBConnection.closeConnection();
        }
    }
}
