package beans;

import java.util.Objects;

public class Venda {
    private int id;
    private String preco;
    private String pagamento;

    private Produto produto;
    private Cliente cliente;
    private Fornecedor fornecedor;

    private Cliente id_cliente;
    private Produto id_produto;
    private Fornecedor id_fornecedor;

    public Venda() {
    }

    public Venda(int id, String preco, String pagamento, Produto produto, Cliente cliente, Fornecedor fornecedor) {
        this.id = id;
        this.preco = preco;
        this.pagamento = pagamento;
        this.produto = produto;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    public Fornecedor getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Fornecedor id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preco, pagamento, produto, cliente, fornecedor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Venda)) return false;
        Venda other = (Venda) obj;
        return id == other.id &&
               Objects.equals(preco, other.preco) &&
               Objects.equals(pagamento, other.pagamento) &&
               Objects.equals(produto, other.produto) &&
               Objects.equals(cliente, other.cliente) &&
               Objects.equals(fornecedor, other.fornecedor);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", preco='" + preco + '\'' +
                ", pagamento='" + pagamento + '\'' +
                ", produto=" + produto +
                ", cliente=" + cliente +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
