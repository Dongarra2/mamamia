package accesBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDD {

        public static Connection cn = null;
        public BDD() {
        }
        public static void OuvrirConnexion() {
                String url ="jdbc:mysql://mysql02.pedagogie.enit.fr/Game";
                String login = "student";
                String password ="Enit@65";
                
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        cn = DriverManager.getConnection(url,login,password);
                        System.out.println("Connexion réussie");
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
        
        public static void insertScore(String playerName, int score) throws SQLException{
            BDD.OuvrirConnexion();
            String sql = "INSERT INTO Score (playerName, score)"+ "VALUES (?, ?)";
            
            PreparedStatement preparedStmt_insert = BDD.cn.prepareStatement(sql);
            preparedStmt_insert.setString(1,playerName);
            preparedStmt_insert.setInt(2,score);
            preparedStmt_insert.execute();
            BDD.fermerConnexion();
    }

}