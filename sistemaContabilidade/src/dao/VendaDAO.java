package DAO;

import beans.Venda;
import beans.Produto;
import beans.Cliente;
import beans.Fornecedor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Conexao conexao;
    private Connection conn;

    public VendaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Venda venda) {
        String sql = "INSERT INTO Venda (id_Fornecedor, id_Cliente, id_Produto, preco, pagamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venda.getFornecedor().getId());
            stmt.setInt(2, venda.getCliente().getId());
            stmt.setInt(3, venda.getProduto().getId());
            stmt.setString(4, venda.getPreco());
            stmt.setString(5, venda.getPagamento());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir venda: " + ex.getMessage());
        }
    }

    public void editar(Venda venda) {
        String sql = "UPDATE Venda SET id_Fornecedor=?, id_Cliente=?, id_Produto=?, preco=?, pagamento=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venda.getFornecedor().getId());
            stmt.setInt(2, venda.getCliente().getId());
            stmt.setInt(3, venda.getProduto().getId());
            stmt.setString(4, venda.getPreco());
            stmt.setString(5, venda.getPagamento());
            stmt.setInt(6, venda.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar venda: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Venda WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir venda: " + ex.getMessage());
        }
    }

    public List<Venda> getVendas() {
        String sql = "SELECT id, id_Fornecedor, id_Cliente, id_Produto, preco, pagamento FROM Venda";
        List<Venda> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setPreco(rs.getString("preco"));
                v.setPagamento(rs.getString("pagamento"));

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_Fornecedor"));
                v.setFornecedor(f);

                Cliente c = new Cliente();
                c.setId(rs.getInt("id_Cliente"));
                v.setCliente(c);

                Produto p = new Produto();
                p.setId(rs.getInt("id_Produto"));
                v.setProduto(p);

                lista.add(v);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar vendas: " + ex.getMessage());
        }
        return lista;
    }

    public Venda getVenda(int id) {
        String sql = "SELECT id, id_Fornecedor, id_Cliente, id_Produto, preco, pagamento FROM Venda WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setPreco(rs.getString("preco"));
                v.setPagamento(rs.getString("pagamento"));

                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_Fornecedor"));
                v.setFornecedor(f);

                Cliente c = new Cliente();
                c.setId(rs.getInt("id_Cliente"));
                v.setCliente(c);

                Produto p = new Produto();
                p.setId(rs.getInt("id_Produto"));
                v.setProduto(p);

                return v;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar venda: " + ex.getMessage());
        }
        return null;
    }

    public void inserir(view.Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
