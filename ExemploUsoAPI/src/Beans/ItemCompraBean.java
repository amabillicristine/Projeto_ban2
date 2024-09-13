package Beans;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemCompraBean {

    private UUID idCompra;
    private UUID idProduto;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    public ItemCompraBean(UUID idCompra, UUID idProduto, int quantidade, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.idCompra = idCompra;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public ItemCompraBean() {}

    public UUID getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(UUID idCompra) {
        this.idCompra = idCompra;
    }

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "ItemCompraBean{" +
                "idCompra=" + idCompra +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
