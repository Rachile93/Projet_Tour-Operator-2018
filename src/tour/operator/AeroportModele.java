package tour.operator;

import java.sql.*;
import myconnection.DBConnection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AeroportModele {

    private List<Aeroport> mesAeroport = new ArrayList<>();

    public AeroportModele() {

    }

    public String ajoutAeroport(Aeroport aeroport1) {
        mesAeroport.add(aeroport1);
        //saveInFile(aeroport1);
       saveDBLieu(aeroport1);
        String msg = "ok";
        return msg;
    }

    public void rechercheAeroport() {

    }

    public void moidifierAeroport() {

    }

    public void suprimerAeroport() {

    }

    public List<Aeroport> getMesAeroport() {
        return mesAeroport;
    }

    public void setMesAeroport(List<Aeroport> mesAeroport) {
        this.mesAeroport = mesAeroport;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.mesAeroport);
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
        final AeroportModele other = (AeroportModele) obj;
        if (!Objects.equals(this.mesAeroport, other.mesAeroport)) {
            return false;
        }
        return true;
    }

    public void saveInFile(Aeroport A) {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Aeroport.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        if (!p.exists()) {
            try {
                p.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            bw = new BufferedWriter(new FileWriter(p, true));
            bw.write(A.getIdAeroport());
            bw.write("/");
            bw.write(A.getNom());
            bw.write("/");
            bw.write(A.getVille());
            bw.write("/");
            bw.write(A.getPays());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDBLieu(Aeroport A) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "INSERT INTO lieu(id_lieu,nom,ville,pays,type) values(?,?,?,?,?)";

            pstm1 = dbConnect.prepareStatement(query1);
            pstm1.setString(1, A.getIdAeroport());
            pstm1.setString(2, A.getNom());
            pstm1.setString(3, A.getVille());
            pstm1.setString(4, A.getPays());
            pstm1.setString(5, "aeroport");
            
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

}
