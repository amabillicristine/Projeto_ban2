package Beans;

import java.util.UUID;

public class ContatoBean {

    private UUID id;
    private String email;
    private String telefones;
    private UUID idEndereco;

    public ContatoBean(UUID id, String email, String telefones, UUID idEndereco) {
        this.id = id;
        this.email = email;
        this.telefones = telefones;
        this.idEndereco = idEndereco;
    }

    public ContatoBean() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public UUID getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(UUID idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", telefones='" + telefones + '\'' +
                ", idEndereco=" + idEndereco +
                '}';
    }
}
