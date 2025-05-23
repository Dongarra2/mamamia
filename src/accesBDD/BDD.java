package accesBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {

        public static Connection cn = null;
        public BDD() {
        }
        public static void OuvrirConnexion() {
                String url ="jdbc:mysql://mysql02.pedagogie.enit.fr/****roguelite";
                String login = "student";
                String password ="Enit@65";
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        cn = DriverManager.getConnection(url,login,password);
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
        public static void fermerConnexion() {
                try {
                        cn.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}