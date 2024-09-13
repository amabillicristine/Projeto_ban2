package Beans;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemPedidoBean {

    private UUID idPedido;
    private UUID idProduto;
    private int quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    public ItemPedidoBean(UUID idPedido, UUID idProduto, int quantidade, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public ItemPedidoBean() {}

    public UUID getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
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
        return "ItensPedidoBean{" +
                "idPedido=" + idPedido +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
