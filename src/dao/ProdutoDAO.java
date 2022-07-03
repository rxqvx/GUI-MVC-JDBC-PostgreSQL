package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Produto;
import java.sql.ResultSet;

/**
 *
 * @author Henrique Kenji Konishi
 */
public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO products(nome, valor, quantidade, id)"
                + "values('" + produto.getNome() + "', '" + produto.getValor() + "', '" + produto.getQuantidade()
                + "', '" + produto.getId() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }

    public ResultSet consultar(Produto produto) throws SQLException {
        String sql = "SELECT * FROM products WHERE nome=? " +
                "AND Id=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getId());
        statement.execute();
        // statement.getResultSet();
        ResultSet resultado = statement.getResultSet();
        conn.close();
        return resultado;

    }

    public void delete(Produto produto) throws SQLException {

        String sql = "DELETE FROM products WHERE id= ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, produto.getId());
        statement.execute();
        conn.close();
    }

    public void Update(Produto produto, Produto produto1) throws SQLException {
        String sql = "UPDATE products SET Id = ? WHERE nome = ? AND Id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, produto.getId());// new password
        statement.setString(2, produto.getNome());// user
        statement.setString(3, produto1.getId());// older password
        statement.execute();
        conn.close();
    }

}
