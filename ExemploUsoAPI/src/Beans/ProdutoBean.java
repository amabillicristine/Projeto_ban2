package Beans;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoBean {

    private UUID id;
    private String nome;
    private UUID idClassificacaoProduto;
    private UUID idMarca;
    private UUID idFornecedor;
    private BigDecimal valor;
    private int quantidadeEstoque;

    public ProdutoBean(UUID id, String nome, UUID idClassificacaoProduto, UUID idMarca, UUID idFornecedor, BigDecimal valor, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.idClassificacaoProduto = idClassificacaoProduto;
        this.idMarca = idMarca;
        this.idFornecedor = idFornecedor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public ProdutoBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getIdClassificacaoProduto() {
        return idClassificacaoProduto;
    }

    public void setIdClassificacaoProduto(UUID idClassificacaoProduto) {
        this.idClassificacaoProduto = idClassificacaoProduto;
    }

    public UUID getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(UUID idMarca) {
        this.idMarca = idMarca;
    }

    public UUID getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(UUID idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "ProdutoBean{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idClassificacaoProduto=" + idClassificacaoProduto +
                ", idMarca=" + idMarca +
                ", idFornecedor=" + idFornecedor +
                ", valor=" + valor +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
}
