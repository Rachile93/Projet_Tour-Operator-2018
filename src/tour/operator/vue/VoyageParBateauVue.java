package tour.operator.vue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.time.format.DateTimeFormatter;
import myconnection.DBConnection;
import tour.operator.Port;
import tour.operator.VoyageParBateau;

public class VoyageParBateauVue {

    Scanner sc = new Scanner(System.in);
    private List<Port> port = new ArrayList<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyy");

    public VoyageParBateauVue() {

    }

    public VoyageParBateau ajouterVoyBateau(String id) {
        // readInFile();

        String idBateau = id;
        affMsg("port de depart : ");
        affListe(port);
        String portDepart = getChoix("choisissez un numero :  ");
        affMsg("port de destination : ");
        affListe(port);
        String portDestination = getChoix("choisissez un numero :  ");
        LocalTime heureDepart = LocalTime.parse(getMsg("heure depart du bateau (h:mm): "));
        LocalTime heureArrive = LocalTime.parse(getMsg("Heure Arrive du bateau (h:mm): "));
        LocalDate dateDepart = LocalDate.parse(getMsg("date de depart : "), dtf);
        LocalDate dateArrive = LocalDate.parse(getMsg("date arrivee : "), dtf);
        double prix = Double.parseDouble(getMsg("prix : "));
        double prixSup = Double.parseDouble(getMsg("prix supl: "));
        VoyageParBateau vBateau = new VoyageParBateau(idBateau, portDepart, portDestination, heureDepart, heureArrive, dateDepart, dateArrive, prix, prixSup);

        return vBateau;

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

    public void readInFile() {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Port.txt");
        Port p2 = new Port();
        try {
            FileReader fr = new FileReader(p);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p)));
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                //System.out.println(line);
                String[] part = line.split("/");
                p2.setIdPort(part[0]);
                p2.setNom(part[1]);
                p2.setVille(part[2]);
                p2.setPays(part[3]);
                port.add(p2);
                line = br.readLine();
                i++;
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getChoix(String s) {
        int n = 0;
        boolean verif = false;
        do {
            verif = false;
            n = Integer.parseInt(getMsg(s));
            if (n > 0 && n <= port.size()) {
                verif = true;
            }
        } while (false);

        return port.get(n - 1).getNom();
    }

    public String verifId() {
        boolean verif = false;
        String id = null;
        do {
            int n = 0, i = 0;
            verif = false;
            id = getMsg("identifiant du bateau");
            char[] c = id.toLowerCase().toCharArray();
            if (c.length == 5) {
                for (char l : c) {
                    if (i < 2) {
                        if (l >= '0' && l <= '9') {
                            n++;
                        }
                        i++;
                    } else {
                        if (i < 5) {
                            if (l >= 'a' && l <= 'z') {
                                n++;
                            }
                            i++;
                        }
                    }

                }
            }
            if (n == c.length) {
                verif = true;
            } else {
                affMsg("erreur");
            }

        } while (verif == false);

        return id;

    }
    
    public void readDBlieu() {
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "select id_lieu,nom,ville,pays  from lieu where type=?";
            pstm1 = dbConnect.prepareStatement(query1);
            pstm1.setString(1,"port");
         
            
            rs = pstm1.executeQuery();
            Port p = new Port();
            while(rs.next()){
                p.setIdPort(rs.getString("ID_LIEU"));
                p.setNom(rs.getString("NOM"));
                p.setVille(rs.getString("VILLE"));
                p.setPays(rs.getString("PAYS"));
                port.add(p);
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
