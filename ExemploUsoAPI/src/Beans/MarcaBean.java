package Beans;

import java.util.UUID;

public class MarcaBean {

    private UUID id;
    private String nome;

    public MarcaBean(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public MarcaBean() {}

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

    @Override
    public String toString() {
        return "MarcasBean{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
