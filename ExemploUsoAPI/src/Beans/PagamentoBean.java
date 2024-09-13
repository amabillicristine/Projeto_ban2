package Beans;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoBean {

    private UUID id;
    private UUID idUsuario;
    private BigDecimal valor;
    private String metodoPagamento;
    private LocalDateTime dataPagamento;
    private String statusPagamento;
    private UUID transacaoId;
    private String tipoPagamento;

    public PagamentoBean(UUID id, UUID idUsuario, BigDecimal valor, String metodoPagamento, LocalDateTime dataPagamento, String statusPagamento, UUID transacaoId, String tipoPagamento) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
        this.transacaoId = transacaoId;
        this.tipoPagamento = tipoPagamento;
    }

    public PagamentoBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public UUID getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(UUID transacaoId) {
        this.transacaoId = transacaoId;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "PagamentosBean{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", valor=" + valor +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", dataPagamento=" + dataPagamento +
                ", statusPagamento='" + statusPagamento + '\'' +
                ", transacaoId=" + transacaoId +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                '}';
    }
}
