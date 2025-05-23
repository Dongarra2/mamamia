package accesBDD;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestRequest {
        public static void insertScore(String playerName, int score) throws SQLException{
                BDD.OuvrirConnexion();
                String sql = "INSERT INTO Scores (playerName, score)"+ "VALUES (?, ?)";
                
                PreparedStatement preparedStmt_insert = BDD.cn.prepareStatement(sql);
                preparedStmt_insert.setString(1,playerName);
                preparedStmt_insert.setInt(2,score);
                preparedStmt_insert.execute();
                BDD.fermerConnexion();
        }

}