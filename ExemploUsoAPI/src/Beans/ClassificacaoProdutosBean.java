package Beans;

import java.util.UUID;

public class ClassificacaoProdutosBean {

    private UUID id;
    private UUID idCategoria;
    private UUID idSubCategoria;

    public ClassificacaoProdutosBean(UUID id, UUID idCategoria, UUID idSubCategoria) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.idSubCategoria = idSubCategoria;
    }

    public ClassificacaoProdutosBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(UUID idCategoria) {
        this.idCategoria = idCategoria;
    }

    public UUID getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(UUID idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    @Override
    public String toString() {
        return "ClassificacaoProdutosBean{" +
                "id=" + id +
                ", idCategoria=" + idCategoria +
                ", idSubCategoria=" + idSubCategoria +
                '}';
    }
}
