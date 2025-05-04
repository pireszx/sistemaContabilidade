package beans;

public class Produto {
    private int id;
    private String nome;
    private double precoCompra;
    private double precoVenda;
    private double icms;
    private double credito;
    private double debito;
    
    private String preco;
    private String pagamento;

    public Produto() {
    }

    public Produto(String nome,double precoCompra, double precoVenda, double icms, double credito, double debito, String preco, String pagamento) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.icms = icms;
        this.credito = credito;
        this.debito = debito;
        this.preco = preco;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
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

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", icms=" + icms +
                ", credito=" + credito +
                ", debito=" + debito + 
                ", pagamento= " + 
                "}" ;
    }
}

/*

package beans;

public class Produto {
    private int id;
    private String nome;
    private double precoCompra;
    private double precoVenda;
    private double icms;
    private double credito;
    private double debito;

    public Produto() {
    }

    public Produto(String nome,double precoCompra, double precoVenda, double icms, double credito, double debito) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.icms = icms;
        this.credito = credito;
        this.debito = debito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", icms=" + icms +
                ", credito=" + credito +
                ", debito=" + debito +
                '}';
    }
}

*/