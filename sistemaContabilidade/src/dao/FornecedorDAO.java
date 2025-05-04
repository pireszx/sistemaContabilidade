package DAO;

import conexao.Conexao;
import beans.Fornecedor;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    private Conexao conexao;
    private Connection conn;

    public FornecedorDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (nome, cnpj, estado) VALUES (?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEstado());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir fornecedor: " + ex.getMessage());
        }
    }

    public void editar(Fornecedor fornecedor) {
        try {
            String sql = "UPDATE Fornecedor SET nome=?, cnpj=?, estado=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEstado());
            stmt.setInt(4, fornecedor.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar fornecedor: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Fornecedor WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir fornecedor: " + ex.getMessage());
        }
    }

    public List<Fornecedor> getFornecedores() {
        String sql = "SELECT * FROM Fornecedor";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Fornecedor> listaFornecedores = new ArrayList();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEstado(rs.getString("estado"));
                listaFornecedores.add(f);
            }
            return listaFornecedores;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar fornecedores: " + ex.getMessage());
            return null;
        }
    }

    public Fornecedor getFornecedor(int id) {
        String sql = "SELECT * FROM Fornecedor WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Fornecedor f = new Fornecedor();

            rs.first();
            f.setId(id);
            f.setNome(rs.getString("nome"));
            f.setCnpj(rs.getString("cnpj"));
            f.setEstado(rs.getString("estado"));
            return f;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar fornecedor:" + ex.getMessage());
            return null;
        }
    }
  
}