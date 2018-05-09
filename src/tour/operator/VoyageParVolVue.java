package tour.operator;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.time.format.DateTimeFormatter;
import myconnection.DBConnection;

public class VoyageParVolVue {

    Scanner sc = new Scanner(System.in);
    // private List<Aeroport> a1 = new ArrayList();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");

    public VoyageParVolVue() {

    }

    public VoyageParVol ajouterVol(String id) {
        // readInFile();

        // VoyageParVol v1 = new VoyageParVol();
        String idVol = id;
        affMsg("Aeroport de depart : ");
        String AeroportDepart = readDBlieu("choisissez un numero :  ");
        affMsg("Aeroport de destination : ");
        String AeroportDestination = readDBlieu("choisissez un numero :  ");
        LocalTime heureDepart = LocalTime.parse(getMsg("heure depart du vol : "));
        LocalTime heureArrive = LocalTime.parse(getMsg("Heure Arrive du vol : "));
        LocalDate dateDepart = LocalDate.parse(getMsg("date de depart : "), dtf);
        LocalDate dateArrive = LocalDate.parse(getMsg("date arrivee : "), dtf);
        double prix = Double.parseDouble(getMsg("prix : "));

        VoyageParVol v1 = new VoyageParVol(idVol, AeroportDepart, AeroportDestination, heureDepart, heureArrive, dateDepart, dateArrive, prix);

        return v1;

    }

    public String getMsg() {
        String msg = sc.nextLine();
        return msg;
    }

    public void affMsg(Object msg) {
        System.out.println(msg);
    }

    /**
     * cette methode permet a d'effectuer une saisie clavier
     *
     * @param msg chaine de caractere passé en parametre
     * @return returne la chaine entrer au clavier
     */
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

    /*public void readInFile() {
        File p = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\TOUR-OPERATOR\\Aeroport.txt");
        Aeroport arp2 = new Aeroport();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p)));
            String line = br.readLine();

            int i = 0;
            
            while (line != null) {

                String[] part = line.split("/");
                arp2.setIdAeroport(part[0]);
                arp2.setNom(part[1]);
                arp2.setVille(part[2]);
                arp2.setPays(part[3]);
                System.out.println("");
                
                
                line = br.readLine();
                i++;
            }

            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
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

    /**
     * cette methode permet de verifier si les identifients entrer au clavier
     * son correcte
     *
     * @return elle retourne l'identifient si celui ci est correct
     */
    public String verifId() {
        boolean verif = false;
        String id = null;
        do {
            int n = 0, i = 0;
            verif = false;
            id = getMsg("identifiant du vol");
            char[] c = id.toLowerCase().toCharArray();
            if (c.length == 6) {
                for (char l : c) {
                    if (i < 3) {
                        if (l >= 'a' && l <= 'z') {
                            n++;
                        }
                        i++;
                    } else {
                        if (i < 6) {

                            if (l >= '0' && l <= '9') {
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

    public String readDBlieu(String s) {
        String nom = null;
        int i = 0;
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
            pstm1 = dbConnect.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm1.setString(1, "aeroport");

            rs = pstm1.executeQuery();
            Aeroport aep = new Aeroport();
            System.out.println("n°      id_lieu     nom     ville       pays");
            while (rs.next()) {
                System.out.println(i + 1 + "     " + rs.getString("ID_LIEU") + "     " + rs.getString("NOM") + "        " + rs.getString("VILLE") + "       " + rs.getString("PAYS"));
                i++;
            }

            rs.absolute(getChoix(s, i));
            System.out.println(i +  "     " + rs.getString("ID_LIEU") + "     " + rs.getString("NOM") + "        " + rs.getString("VILLE") + "       " + rs.getString("PAYS"));
            nom = rs.getString("NOM");
            
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
        
        return nom;

    }

}
