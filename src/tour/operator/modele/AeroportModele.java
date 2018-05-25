package tour.operator.modele;

import tour.operator.*;
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

    public List<Aeroport> rechercheAeroport(String id) {
        List<Aeroport> listAeroport = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstm1 = null,pstm2 = null,pstm3 = null,pstm4 = null,pstm5 = null,pstm6 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "SELECT * FROM lieu where id_lieu like ?";
            String query2 = "SELECT * FROM lieu where nom like ?";
            String query3 = "SELECT * FROM lieu where ville like ?";
            String query4 = "SELECT * FROM lieu where pays like ?";
            String query5 = "SELECT * FROM lieu where type like ?";

            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm1.setString(1, "%" + id + "%");
            rs = pstm1.executeQuery();
            while (rs.next()) {
                Aeroport aerp = new Aeroport(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                listAeroport.add(aerp);
            }
            pstm2 = dbConnect.prepareStatement(query2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm2.setString(1, "%" + id + "%");
            rs = pstm1.executeQuery();
            while (rs.next()) {
                Aeroport aerp = new Aeroport(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                listAeroport.add(aerp);
            }
            pstm3 = dbConnect.prepareStatement(query3, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm3.setString(1, "%" + id + "%");
            rs = pstm1.executeQuery();
            while (rs.next()) {
                Aeroport aerp = new Aeroport(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                listAeroport.add(aerp);
            }
            pstm4 = dbConnect.prepareStatement(query4, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm4.setString(1, "%" + id + "%");
            rs = pstm1.executeQuery();
            while (rs.next()) {
                Aeroport aerp = new Aeroport(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                listAeroport.add(aerp);
            }
            pstm5 = dbConnect.prepareStatement(query5, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm5.setString(1, "%" + id + "%");
            rs = pstm1.executeQuery();
            while (rs.next()) {
                Aeroport aerp = new Aeroport(rs.getString("id_lieu"), rs.getString(2), rs.getString(3), rs.getString(4));
                listAeroport.add(aerp);
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

        return listAeroport;

    }

    public void moidifierAeroport(Aeroport aeroport) {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect
                == null) {
            System.exit(0);
        }

        System.out.println(
                "connexion établie");
        try {
            String query1 = "UPDATE lieu set nom = ? ,ville = ? , pays = ?, type = ? where id_lieu = ? ";

            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm1.setString(1, aeroport.getNom());
            pstm1.setString(2, aeroport.getVille());
            pstm1.setString(3, aeroport.getPays());
            pstm1.setString(4, "aeroport");
            pstm1.setString(5, aeroport.getIdAeroport());
            int nl = pstm1.executeUpdate();

            System.out.println(nl + "ligne modifier");

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
            String query1 = "DELETE FROM lieu where id_lieu = ?";

            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

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

    /* public void saveInFile(Aeroport A) {
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
    }*/
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

            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
