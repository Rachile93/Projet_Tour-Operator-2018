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

public class PortModele {

    private List<Port> mesPort = new ArrayList<>();

    public PortModele() {
    }

    public String ajoutPort(Port port1) {
        mesPort.add(port1);
       // saveInFile(port1);
        saveInDBLieu(port1);
        String msg = "ok";
        return msg;
    }


    public void recherchePort() {

    }

    public void moidifierPort() {

    }

    public void suprimerPort() {

    }

    public List<Port> getMesPort() {
        return mesPort;
    }

    public void setMesPort(List<Port> mesPort) {
        this.mesPort = mesPort;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.mesPort);
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
        final PortModele other = (PortModele) obj;
        if (!Objects.equals(this.mesPort, other.mesPort)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PortModele{" + "mesPort=" + mesPort + '}';
    }

    public void saveInFile(Port pt) {

        File f = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\port.txt");
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
            bw.write(pt.getIdPort());
            bw.write("/");
            bw.write(pt.getNom());
            bw.write("/");
            bw.write(pt.getVille());
            bw.write("/");
            bw.write(pt.getPays());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveInDBLieu(Port A) {
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
            pstm1.setString(1, A.getIdPort());
            pstm1.setString(2, A.getNom());
            pstm1.setString(3, A.getVille());
            pstm1.setString(4, A.getPays());
            pstm1.setString(5, "port");
            
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
