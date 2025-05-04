package DAO;

import conexao.Conexao;
import beans.Cliente;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Conexao conexao;
    private Connection conn;

    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, cpf, estado) VALUES (?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEstado());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir cliente: " + ex.getMessage());
        }

    }

    public void editar(Cliente cliente) {
        try {
            String sql = "UPDATE Cliente SET nome=?, cpf=?, estado=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEstado());
            stmt.setInt(4, cliente.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar cliente: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Cliente WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
        }

    }

    public List<Cliente> getCliente() {
        String sql = "SELECT * FROM Cliente";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Cliente> listaUsuarios = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEstado(rs.getString("estado"));
                listaUsuarios.add(c);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            System.out.println("Erro ai : " + ex.getMessage());
            return null;
        }
    }

    public Cliente getCliente(int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Cliente p = new Cliente();

            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("matricula"));
            p.setEstado(rs.getString("estado"));
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuario:" + ex.getMessage());
            return null;
        }
    }
}
