import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CompraBean {

    private UUID id;
    private UUID idUsuario;
    private LocalDateTime dataCriacao;
    private int parcelas;
    private BigDecimal valorParcela;
    private BigDecimal valorTotal;

    public CompraBean(UUID id, UUID idUsuario, LocalDateTime dataCriacao, int parcelas, BigDecimal valorParcela, BigDecimal valorTotal) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataCriacao = dataCriacao;
        this.parcelas = parcelas;
        this.valorParcela = valorParcela;
        this.valorTotal = valorTotal;
    }

    public CompraBean() {}

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "CompraBean{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", dataCriacao=" + dataCriacao +
                ", parcelas=" + parcelas +
                ", valorParcela=" + valorParcela +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
