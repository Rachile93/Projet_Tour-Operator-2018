package tour.operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.AbstractTableModel;
import myconnection.DBConnection;

public final class LoadDataBaseLieuModele extends AbstractTableModel{

    private final String[] entetes = {"position", "id_lieu", "nom", "ville", "pays", "type_lieu"};
    private List<Aeroport> aeroport = new ArrayList<>();
    private List<Port> port = new ArrayList<>();
    private String name_lieu = null;

    public LoadDataBaseLieuModele() {
        super();
        loadDataBaseLieu();
        // this.name_lieu=name_lieu;
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
    public void fireTableRowsDeleted(int i, int i1) {
        super.fireTableRowsDeleted(i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsUpdated(int i, int i1) {
        super.fireTableRowsUpdated(i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsInserted(int i, int i1) {
        super.fireTableRowsInserted(i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableStructureChanged() {
        super.fireTableStructureChanged(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
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
   

    public void loadDataBaseLieu() {
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
            String query1 = "select id_lieu,nom,ville,pays,type from lieu ";
            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pstm1.executeQuery();
            while (rs.next()) {
                if (rs.getString(5).equals("aeroport")) {
                    Aeroport aerp = new Aeroport(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                    aeroport.add(aerp);
                    name_lieu = "aeroport";
                }
                Port port1 = new Port(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                port.add(port1);
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
