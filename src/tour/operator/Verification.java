package tour.operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;
import myconnection.DBConnection;

public class Verification {

    private Scanner sc = new Scanner(System.in);

    public boolean verifIdAeroport(String id) {
        boolean verif = false;

        int n = 0, i = 0;
        verif = false;
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

        //  affMsg(c.length);
        if (n == c.length) {
            verif = true;
            affMsg("verification ok");
        } else {
            affMsg("erreur");
        }

        return verif;

    }

    public boolean verifIdPort(String id) {
        boolean verif = false;

        int n = 0, i = 0;
        verif = false;
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
        affMsg(c.length);
        if (n == c.length) {
            verif = true;
        } else {
            affMsg("erreur");
        }
        return verif;
    }

    public boolean verifIdVoyage(String id) {
        boolean verif = false;
        int n = 0;
        verif = false;
        char[] c = id.toLowerCase().toCharArray();
        for (char l : c) {
            if (l >= '0' && l <= '9') {
                n++;
            }
        }
        if (n == c.length) {
            verif = true;
        }
        return verif;
    }

    public boolean ifIdLieuExist(String id) {
        boolean verif = false;
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "select * from lieu";
            pstm1 = dbConnect.prepareStatement(query1);
            rs = pstm1.executeQuery();
            while (rs.next()) {
                if (id.equals(rs.getString("id_lieu"))) {
                    verif = true;
                }
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
        return verif;
    }
     public boolean ifIdVoyageExist(String id) {
        boolean verif = false;
        ResultSet rs = null;
        PreparedStatement pstm1 = null;
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(0);
        }
        System.out.println("connexion établie");
        try {
            String query1 = "select * from voyage";
            pstm1 = dbConnect.prepareStatement(query1);
            rs = pstm1.executeQuery();
            while (rs.next()) {
                if (id.equals(rs.getString("id_voyage"))) {
                    verif = true;
                }
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
        return verif;
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
}
