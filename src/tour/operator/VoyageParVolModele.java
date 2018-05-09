package tour.operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import myconnection.DBConnection;

public class VoyageParVolModele {

    private List<VoyageParVol> mesVol = new ArrayList<>();

    public VoyageParVolModele() {

    }

    public void ajoutDeVol(VoyageParVol v) {

        mesVol.add(v);
       // saveInFile(v);
        saveInDBTranport(v);
    }

    public List<VoyageParVol> getVol() {
        return mesVol;
    }

    public void setVol(List<VoyageParVol> mesVol) {
        this.mesVol = mesVol;
    }

    @Override
    public String toString() {
        return "VoyageParVolModele{" + "vol=" + mesVol + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.mesVol);
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
        final VoyageParVolModele other = (VoyageParVolModele) obj;
        if (!Objects.equals(this.mesVol, other.mesVol)) {
            return false;
        }
        return true;
    }

   /* public void saveInFile(VoyageParVol A) {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_en_vol.txt");
        if (!p.exists()) {
            try {
                p.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(p, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(A.getIdVol());
            bw.write("/");
            bw.write(A.getAeroportDepart());
            bw.write("/");
            bw.write(A.getAeroportDestination());
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
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void saveInDBTranport(VoyageParVol A) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "INSERT INTO transport(id_transport,lieu_depart,lieu_arrive,heure_depart,heure_arrive,date_depart,date_arrive,prix,type_transport) ";
                   query1 += "values(?,?,?,?,?,?,?,?,?)";

            pstm1 = dbConnect.prepareStatement(query1);
            pstm1.setString(1, A.getIdVol());
            pstm1.setString(2, A.getAeroportDepart());
            pstm1.setString(3, A.getAeroportDestination());
            pstm1.setTime(4, java.sql.Time.valueOf(A.getHeureDepart()));
            pstm1.setTime(5, java.sql.Time.valueOf(A.getHeureArrive()));
            pstm1.setDate(6, java.sql.Date.valueOf(A.getDateDepart()));
            pstm1.setDate(7, java.sql.Date.valueOf(A.getDateArrive()));
            pstm1.setDouble(8, A.getPrix());
            pstm1.setString(9, "vol");
            

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
