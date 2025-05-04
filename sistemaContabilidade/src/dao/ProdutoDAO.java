package DAO;

import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Conexao conexao;
    private Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO Produto (nome, preco, pagamento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());      // preco como String
            stmt.setString(3, produto.getPagamento());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }

    public void editar(Produto produto) {
        String sql = "UPDATE Produto SET nome=?, preco=?, pagamento=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());     // preco como String
            stmt.setString(3, produto.getPagamento());
            stmt.setInt(4, produto.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Produto WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        String sql = "SELECT id, nome, preco, pagamento FROM Produto";
        List<Produto> listaProdutos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getString("preco"));       // preco como String
                p.setPagamento(rs.getString("pagamento"));
                listaProdutos.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
        return listaProdutos;
    }

    public Produto getProduto(int id) {
        String sql = "SELECT id, nome, preco, pagamento FROM Produto WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getString("preco"));       // preco como String
                p.setPagamento(rs.getString("pagamento"));
                return p;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produto: " + ex.getMessage());
        }
        return null;
    }
}



/*

public class ProdutoDAO {

    private Conexao conexao;
    private Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO Produto (nome, precoCompra, precoVenda, icms, credito, debito) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setDouble(4, produto.getIcms());
            stmt.setDouble(5, produto.getCredito());
            stmt.setDouble(6, produto.getDebito());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }

    public void editar(Produto produto) {
        try {
            String sql = "UPDATE Produto SET nome=?, precoCompra=?, precoVenda=?, icms=?, credito=?, debito=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setDouble(4, produto.getIcms());
            stmt.setDouble(5, produto.getCredito());
            stmt.setDouble(6, produto.getDebito());
            stmt.setInt(7, produto.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Produto WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }

    public List<Produto> getProdutos() {
        String sql = "SELECT * FROM Produto";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Produto> listaProdutos = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPrecoCompra(rs.getDouble("precoCompra"));
                p.setPrecoVenda(rs.getDouble("precoVenda"));
                p.setIcms(rs.getDouble("icms"));
                p.setCredito(rs.getDouble("credito"));
                p.setDebito(rs.getDouble("debito"));
                listaProdutos.add(p);
            }
            return listaProdutos;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
            return null;
        }
    }

    public Produto getProduto(int id) {
        String sql = "SELECT * FROM Produto WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produto p = new Produto();

            if (rs.first()) {
                p.setId(id);
                p.setNome(rs.getString("nome"));
                p.setPrecoCompra(rs.getDouble("precoCompra"));
                p.setPrecoVenda(rs.getDouble("precoVenda"));
                p.setIcms(rs.getDouble("icms"));
                p.setCredito(rs.getDouble("credito"));
                p.setDebito(rs.getDouble("debito"));
            }
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produto: " + ex.getMessage());
            return null;
        }
    }
}

*/