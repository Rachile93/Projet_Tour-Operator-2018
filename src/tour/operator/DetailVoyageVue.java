package tour.operator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import myconnection.DBConnection;

public class DetailVoyageVue {

    private Scanner sc = new Scanner(System.in);
    public List<VoyageParVol> vpv = new ArrayList<>();
    public List<VoyageParBateau> vpbt = new ArrayList<>();

    public DetailVoyage ajouterDetail(int idvoyage) {
        int idvg = idvoyage;
        int position = Integer.parseInt(getMsg("vueillez indique une position ?"));
        int choix = getChoix(" quelle mode de transport ? \n1-par vol \n2-par batteau ");
        String id = readDBDetail_voyage("faire un choix", choix);

        DetailVoyage dtvg = new DetailVoyage(idvg, position, id);
        return dtvg;
    }

    public String getMsg() {
        String msg = sc.nextLine();
        return msg;
    }

    public void affMsg(Object msg) {
        System.out.println(msg);
    }

    public String getMsg(String msg) {//surcharge de la méthode getMsg
        affMsg(msg);
        return getMsg();
    }

    public void affListe(Collection liste) {
        int i = 1;
        for (Object o : liste) {
            affMsg((i++) + "." + o);
        }
    }

    public int getChoix(String s) {
        int n = 0;
        boolean verif = false;
        do {
            verif = false;
            n = Integer.parseInt(getMsg(s));
            if (n > 0 && n <= 2) {
                verif = true;
            } else {
                affMsg("erreur de saisie");
            }
        } while (verif == false);

        return n;
    }

    public void readFileVoyageParVol() {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_en_vol.txt");
        VoyageParVol vpv1 = new VoyageParVol();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p)));
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                //System.out.println(line);
                String[] part = line.split("/");
                vpv1.setIdVol(part[0]);
                vpv1.setAeroportDepart(part[1]);
                vpv1.setAeroportDestination(part[2]);
                vpv1.setHeureDepart(LocalTime.parse(part[3]));
                vpv1.setHeureArrive(LocalTime.parse(part[4]));
                vpv1.setDateDepart(LocalDate.parse(part[5]));
                vpv1.setDateArrive(LocalDate.parse(part[6]));
                vpv1.setPrix(Double.parseDouble(part[7]));
                vpv.add(vpv1);
                line = br.readLine();
                i++;
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void readFileVoyageBatteau() {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\voyage_en_bateau.txt");
        VoyageParBateau vpbt1 = new VoyageParBateau();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p)));
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                //System.out.println(line);
                String[] part = line.split("/");
                vpbt1.setIdBateau(part[0]);
                vpbt1.setPortDepart(part[1]);
                vpbt1.setPortDestination(part[2]);
                vpbt1.setHeureDepart(LocalTime.parse(part[3]));
                vpbt1.setHeureArrive(LocalTime.parse(part[4]));
                vpbt1.setDateDepart(LocalDate.parse(part[5]));
                vpbt1.setDateArrive(LocalDate.parse(part[6]));
                vpbt1.setPrix(Double.parseDouble(part[7]));
                vpbt1.setPrixSup(Double.parseDouble(part[8]));
                vpbt.add(vpbt1);
                line = br.readLine();
                i++;
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String readDBDetail_voyage(String s, int n) {
        String id_transport = null;
        int i = 0;
        ResultSet rs = null;
        PreparedStatement pstm1 = null, pstm2 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "select *  from transport where type_transport=?";
            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (n == 1) {
                pstm1.setString(1, "vol");
            } else {
                pstm1.setString(1, "bateau");
            }

            rs = pstm1.executeQuery();
            Aeroport aep = new Aeroport();
            System.out.println("n°      id_transport");
            while (rs.next()) {
                System.out.println(i + 1 + "     " + rs.getString("ID_TRANSPORT"));
                i++;
            }

            rs.absolute(getChoix(s, i));
            System.out.println(rs.getString("ID_TRANSPORT"));
            id_transport = rs.getString("id_transport");

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

        return id_transport;

    }

    public int getChoix(String s, int i) {
        int n = 0;
        boolean verif = false;
        do {
            verif = false;
            n = Integer.parseInt(getMsg(s));
            ///    affMsg();
            if (n > 0 && n <= i) {
                verif = true;
            }
        } while (verif == false);
        return n;
    }
}
