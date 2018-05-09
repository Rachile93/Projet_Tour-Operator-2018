package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import myconnection.DBConnection;

public class VoyageParBateauModele {

    List<VoyageParBateau> mesVoyBateau = new ArrayList<>();

    public VoyageParBateauModele() {
    }

    public void ajouterVoyageBateau(VoyageParBateau v) {
        mesVoyBateau.add(v);
        saveInDBTransport(v);
    }

    @Override
    public String toString() {
        return "VoyageParBateauModele{" + "mesVoyBateau=" + mesVoyBateau + '}';
    }

    public List<VoyageParBateau> getMesVoyBateau() {
        return mesVoyBateau;
    }

    public void setMesVoyBateau(List<VoyageParBateau> mesVoyBateau) {
        this.mesVoyBateau = mesVoyBateau;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.mesVoyBateau);
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
        final VoyageParBateauModele other = (VoyageParBateauModele) obj;
        if (!Objects.equals(this.mesVoyBateau, other.mesVoyBateau)) {
            return false;
        }
        return true;
    }

    public void saveInFile(VoyageParBateau A) {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_en_bateau.txt");
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
            bw.write(A.getIdBateau());
            bw.write("/");
            bw.write(A.getPortDepart());
            bw.write("/");
            bw.write(A.getPortDestination());
            bw.write("/");
            bw.write(A.getHeureDepart().toString());
            bw.write("/");
            bw.write(A.getHeureArrive().toString());
            bw.write("/");
            bw.write(A.getDateDepart().toString());
            bw.write("/");
            bw.write(A.getDateArrive().toString());
            bw.write("/");
            bw.write(String.valueOf(A.getPrix()));
            bw.write("/");
            bw.write(String.valueOf(A.getPrixSup()));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveInDBTransport(VoyageParBateau A) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "INSERT INTO transport(id_transport,lieu_depart,lieu_arrive,heure_depart,heure_arrive,date_depart,date_arrive,prix,prix_sup,type_transport) ";
                   query1 += "values(?,?,?,?,?,?,?,?,?,?)";

            pstm1 = dbConnect.prepareStatement(query1);
            pstm1.setString(1, A.getIdBateau());
            pstm1.setString(2, A.getPortDepart());
            pstm1.setString(3, A.getPortDestination());
            pstm1.setTime(4, java.sql.Time.valueOf(A.getHeureDepart()));
            pstm1.setTime(5, java.sql.Time.valueOf(A.getHeureArrive()));
            pstm1.setDate(6, java.sql.Date.valueOf(A.getDateDepart()));
            pstm1.setDate(7, java.sql.Date.valueOf(A.getDateArrive()));
            pstm1.setDouble(8, A.getPrix());
            pstm1.setDouble(9, A.getPrixSup());
            pstm1.setString(10, "bateau");
            
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
