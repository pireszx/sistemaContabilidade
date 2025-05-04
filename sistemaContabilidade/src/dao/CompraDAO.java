package DAO;

import beans.Compra;
import beans.Fornecedor;
import beans.Cliente;
import beans.Produto;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

    private Connection conn;

    public CompraDAO() {
        this.conn = new Conexao().getConexao();
    }

    public void inserir(Compra compra) {
        String sql = "INSERT INTO Compra (id_Fornecedor, id_Cliente, id_Produto, preco, pagamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.getFornecedor().getId());
            stmt.setInt(2, compra.getCliente().getId());
            stmt.setInt(3, compra.getProduto().getId());
            stmt.setString(4, compra.getPreco());
            stmt.setString(5, compra.getPagamento());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir compra: " + ex.getMessage());
        }
    }

    public List<Compra> getCompras() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM Compra";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt("id"));
                c.setPreco(rs.getString("preco"));
                c.setPagamento(rs.getString("pagamento"));

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_Fornecedor"));
                c.setFornecedor(f);

                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id_Cliente"));
                c.setCliente(cli);

                Produto p = new Produto();
                p.setId(rs.getInt("id_Produto"));
                c.setProduto(p);

                lista.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar compras: " + ex.getMessage());
        }
        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Compra WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir compra: " + ex.getMessage());
        }
    }

    public void editar(Compra compra) {
        String sql = "UPDATE Compra SET id_Fornecedor=?, id_Cliente=?, id_Produto=?, preco=?, pagamento=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.getFornecedor().getId());
            stmt.setInt(2, compra.getCliente().getId());
            stmt.setInt(3, compra.getProduto().getId());
            stmt.setString(4, compra.getPreco());
            stmt.setString(5, compra.getPagamento());
            stmt.setInt(6, compra.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar compra: " + ex.getMessage());
        }
    }

    public Compra getCompra(int id) {
        String sql = "SELECT * FROM Compra WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt("id"));
                c.setPreco(rs.getString("preco"));
                c.setPagamento(rs.getString("pagamento"));

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_Fornecedor"));
                c.setFornecedor(f);

                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id_Cliente"));
                c.setCliente(cli);

                Produto p = new Produto();
                p.setId(rs.getInt("id_Produto"));
                c.setProduto(p);

                return c;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar compra: " + ex.getMessage());
        }
        return null;
    }
}
