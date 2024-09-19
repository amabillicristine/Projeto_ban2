package Beans;

//import java.util.UUID;
import Enums.GeneroEnum;
import Enums.StatusEnum;
import Enums.TipoEnum;
import java.time.LocalDate;
import Controllers.AtomicIDGenerator;

public class UsuarioBean {
    private int id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataCadastro;  
    private LocalDate dataNascimento;  
    private int idContato;  
    private GeneroEnum genero;
    private StatusEnum status;
    private TipoEnum tipo;

    public UsuarioBean() {
        this.id = AtomicIDGenerator.generateID();
        this.idContato = AtomicIDGenerator.generateID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "UsuarioBean{" +
               "id=" + id +
               ", cpf='" + cpf + '\'' +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", dataCadastro='" + dataCadastro + '\'' +
               ", dataNascimento='" + dataNascimento + '\'' +
               ", idContato=" + idContato +
               ", genero=" + genero +
               ", status=" + status +
               ", tipo=" + tipo +
               '}';
    }
}
