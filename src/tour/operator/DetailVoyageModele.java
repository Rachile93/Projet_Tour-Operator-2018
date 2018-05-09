
package tour.operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import myconnection.DBConnection;


public class DetailVoyageModele {
    
    private List<DetailVoyage> mesDetails = new ArrayList<>();

    public DetailVoyageModele() {
    }
    
    public void ajoutDetail(DetailVoyage dtv){
        mesDetails.add(dtv);
        saveInDBADetailVoyage(dtv);
    }

    public List<DetailVoyage> getMesDetails() {
        return mesDetails;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.mesDetails);
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
        final DetailVoyageModele other = (DetailVoyageModele) obj;
        if (!Objects.equals(this.mesDetails, other.mesDetails)) {
            return false;
        }
        return true;
    }
    public void saveInDBADetailVoyage(DetailVoyage A) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "INSERT INTO Detail_Voyage(id_voyage,position,id_transport) values(?,?,?)";
            pstm1 = dbConnect.prepareStatement(query1);
            
            pstm1.setInt(1, A.getIdVoyage());
            pstm1.setInt(2, A.getPosition());
            pstm1.setString(3, A.getId());
           
            int nl = pstm1.executeUpdate();
            System.out.println(nl + "ligne insérée");

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

    @Override
    public String toString() {
        return "DetailVoyageModele{" + "mesDetails=" + mesDetails + '}';
    }
    
    
            
}
