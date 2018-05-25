package tour.operator.modele;

import tour.operator.*;
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

public class VoyageModele {

    private List<Voyage> mesVoyges = new ArrayList<>();

    public VoyageModele() {

    }

    public int ajoutVoyage(Voyage v1) {
        mesVoyges.add(v1);
        //saveInFileVoyage(v1);
        saveInDBVoyage(v1);
        return mesVoyges.get(mesVoyges.size() - 1).getIdVoyage();
    }

    public void suprimerAeroport(String id) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "DELETE FROM voyage where id_voyage = ?";

            pstm1 = dbConnect.prepareStatement(query1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            pstm1.setString(1, id);

            int nl = pstm1.executeUpdate();

            System.out.println(nl + "ligne suprimer");

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

    public List<Voyage> getMesVoyges() {
        return mesVoyges;
    }

    public void setMesVoyges(List<Voyage> mesVoyges) {
        this.mesVoyges = mesVoyges;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.mesVoyges);
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
        final VoyageModele other = (VoyageModele) obj;
        if (!Objects.equals(this.mesVoyges, other.mesVoyges)) {
            return false;
        }
        return true;
    }

    /* public void saveInFileVoyage(Voyage v) {
        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {

            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);

            bw.write(String.valueOf(v.getIdVoyage()));
            bw.write("/");
            bw.write(v.getTypeVoyage().toString());

            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public void saveInDBVoyage(Voyage A) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "INSERT INTO Voyage(id_voyage ,TYPE_VOYAGE) values(?,?)";

            pstm1 = dbConnect.prepareStatement(query1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pstm1.setInt(1, A.getIdVoyage());
            pstm1.setString(2, A.getTypeVoyage().toString());

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
