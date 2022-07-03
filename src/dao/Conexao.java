
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Henrique Kenji Konishi
 */
public class Conexao {
    public Connection getConexao() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/produtos",
                "postgres", "123");
        return conn;

    }
}
