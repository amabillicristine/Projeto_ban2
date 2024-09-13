package Beans;

import java.util.UUID;

public class PagamentoCompraBean {

    private UUID id;
    private UUID idCompra;
    private UUID idPagamento;

    public PagamentoCompraBean(UUID id, UUID idCompra, UUID idPagamento) {
        this.id = id;
        this.idCompra = idCompra;
        this.idPagamento = idPagamento;
    }

    public PagamentoCompraBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(UUID idCompra) {
        this.idCompra = idCompra;
    }

    public UUID getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(UUID idPagamento) {
        this.idPagamento = idPagamento;
    }

    @Override
    public String toString() {
        return "PagamentoCompraBean{" +
                "id=" + id +
                ", idCompra=" + idCompra +
                ", idPagamento=" + idPagamento +
                '}';
    }
}
