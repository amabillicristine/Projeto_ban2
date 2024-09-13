package Beans;

import java.util.UUID;

public class PedidoBean {

    private UUID id;
    private UUID idFornecedor;
    private UUID idProduto;
    private int quantidadeEstoqueAtual;
    private int quantidade;

    public PedidoBean(UUID id, UUID idFornecedor, UUID idProduto, int quantidadeEstoqueAtual, int quantidade) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.idProduto = idProduto;
        this.quantidadeEstoqueAtual = quantidadeEstoqueAtual;
        this.quantidade = quantidade;
    }

    public PedidoBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(UUID idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeEstoqueAtual() {
        return quantidadeEstoqueAtual;
    }

    public void setQuantidadeEstoqueAtual(int quantidadeEstoqueAtual) {
        this.quantidadeEstoqueAtual = quantidadeEstoqueAtual;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "PedidosBean{" +
                "id=" + id +
                ", idFornecedor=" + idFornecedor +
                ", idProduto=" + idProduto +
                ", quantidadeEstoqueAtual=" + quantidadeEstoqueAtual +
                ", quantidade=" + quantidade +
                '}';
    }
}
