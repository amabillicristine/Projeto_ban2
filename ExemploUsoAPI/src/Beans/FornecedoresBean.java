package Beans;

import java.util.UUID;

public class FornecedoresBean {

    private UUID id;
    private UUID idEndereco;
    private String nome;

    public FornecedoresBean(UUID id, UUID idEndereco, String nome) {
        this.id = id;
        this.idEndereco = idEndereco;
        this.nome = nome;
    }

    public FornecedoresBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(UUID idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "FornecedoresBean{" +
                "id=" + id +
                ", idEndereco=" + idEndereco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
