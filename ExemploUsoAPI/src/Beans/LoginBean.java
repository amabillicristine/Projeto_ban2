import java.util.UUID;

public class LoginBean {

    private UUID idUsuario;
    private String senha;

    public LoginBean(UUID idUsuario, String senha) {
        this.idUsuario = idUsuario;
        this.senha = senha;
    }

    public LoginBean() {}

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" +
                "idUsuario=" + idUsuario +
                ", senha='" + senha + '\'' +
                '}';
    }
}
