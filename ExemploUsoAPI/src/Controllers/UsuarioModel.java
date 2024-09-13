package Controllers;

import Beans.UsuarioBean;
import Enums.GeneroEnum;
import Enums.StatusEnum;
import Enums.TipoEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class UsuarioModel {

    public static void create(UsuarioBean u, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO usuarios (id, cpf, nome, sobrenome, data_cadastro, data_nascimento, id_contato, genero, status, tipo) VALUES (?,?,?,?,?,?,?,?,?,?)");
        st.setObject(1, u.getId());
        st.setString(2, u.getCpf());
        st.setString(3, u.getNome());
        st.setString(4, u.getSobrenome());
        st.setString(5, u.getDataCadastro().toString());
        st.setString(6, u.getDataNascimento().toString());
        st.setObject(7, u.getIdContato());
        st.setString(8, u.getGenero().name());
        st.setString(9, u.getStatus().name());
        st.setString(10, u.getTipo().name());
        st.execute();
        st.close();
    }

    public static HashSet<UsuarioBean> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<UsuarioBean> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT id, cpf, nome, sobrenome, data_cadastro, data_nascimento, id_contato, genero, status, tipo FROM usuarios";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            UsuarioBean usuario = new UsuarioBean();
            usuario.setId(result.getObject("id", java.util.UUID.class));
            usuario.setCpf(result.getString("cpf"));
            usuario.setNome(result.getString("nome"));
            usuario.setSobrenome(result.getString("sobrenome"));
            usuario.setDataCadastro(result.getDate("data_cadastro").toLocalDate());
            usuario.setDataNascimento(result.getDate("data_nascimento").toLocalDate());
            usuario.setIdContato(result.getObject("id_contato", java.util.UUID.class));
            usuario.setGenero(GeneroEnum.valueOf(result.getString("genero")));
            usuario.setStatus(StatusEnum.valueOf(result.getString("status")));
            usuario.setTipo(TipoEnum.valueOf(result.getString("tipo")));
            list.add(usuario);
        }
        return list;
    }

    public static void patch(String coluna, String valor, String id, Connection con) throws SQLException {
        PreparedStatement st;
        String query = "UPDATE usuarios SET " + coluna + " = ? WHERE id = ?";
        st = con.prepareStatement(query);
        st.setString(1, valor);
        st.setObject(2, java.util.UUID.fromString(id));
        st.execute();
        st.close();
    }

    public static void delete(String id, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            String query = "DELETE FROM usuarios WHERE id = ?";
            st = con.prepareStatement(query);
            st.setObject(1, java.util.UUID.fromString(id));
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public static UsuarioBean getById(Connection con, String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        UsuarioBean usuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            st = con.prepareStatement(sql);
            st.setObject(1, java.util.UUID.fromString(id));
            result = st.executeQuery();
            if (result.next()) {
                usuario = new UsuarioBean();
                usuario.setId(result.getObject("id", java.util.UUID.class));
                usuario.setCpf(result.getString("cpf"));
                usuario.setNome(result.getString("nome"));
                usuario.setSobrenome(result.getString("sobrenome"));
                usuario.setDataCadastro(result.getDate("data_cadastro").toLocalDate());
                usuario.setDataNascimento(result.getDate("data_nascimento").toLocalDate());
                usuario.setIdContato(result.getObject("id_contato", java.util.UUID.class));
                usuario.setGenero(GeneroEnum.valueOf(result.getString("genero")));
                usuario.setStatus(StatusEnum.valueOf(result.getString("status")));
                usuario.setTipo(TipoEnum.valueOf(result.getString("tipo")));
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
        return usuario;
    }
}
