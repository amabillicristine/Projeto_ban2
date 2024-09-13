package Beans;

import java.util.UUID;

public class CategoriasBean {

    private UUID id;
    private String nome;
    private String rotulo;

    public CategoriasBean(UUID id, String nome, String rotulo) {
        this.id = id;
        this.nome = nome;
        this.rotulo = rotulo;
    }

    public CategoriasBean() {}

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

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    @Override
    public String toString() {
        return "CategoriasBean{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rotulo='" + rotulo + '\'' +
                '}';
    }
}
