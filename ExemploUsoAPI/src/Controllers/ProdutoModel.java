package Controllers;

import Beans.ProdutoBean;
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

public class ProdutoModel {

    public static void create(UsuarioBean u, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO usuarios (id, cpf, nome, sobrenome, data_cadastro, data_nascimento, id_contato, genero, status, tipo) VALUES (?,?,?,?,?,?,?,?,?,?)");
        st.setInt(1, u.getId());
        st.setString(2, u.getCpf());
        st.setString(3, u.getNome());
        st.setString(4, u.getSobrenome());
        st.setString(5, u.getDataCadastro().toString());
        st.setString(6, u.getDataNascimento().toString());
        st.setInt(7, u.getIdContato());
        st.setString(8, u.getGenero().name());
        st.setString(9, u.getStatus().name());
        st.setString(10, u.getTipo().name());
        st.execute();
        st.close();
    }

    public static HashSet<ProdutoBean> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<ProdutoBean> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT nome, valor, quantidade_estoque FROM \"Produtos\" ";
        
        ResultSet result = st.executeQuery(sql);
        
        while (result.next()) {
            ProdutoBean produto = new ProdutoBean();
            produto.setNome(result.getString("nome"));
            produto.setValor(result.getBigDecimal("valor"));
            produto.setQuantidadeEstoque(result.getInt("quantidade_estoque"));
            list.add(produto);
        }
        return list;
    }

    public static void patch(String coluna, String valor, int id, Connection con) throws SQLException {
        PreparedStatement st;
        String query = "UPDATE usuarios SET " + coluna + " = ? WHERE id = ?";
        st = con.prepareStatement(query);
        st.setString(1, valor);
        st.setObject(2, id);
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            String query = "DELETE FROM usuarios WHERE id = ?";
            st = con.prepareStatement(query);
            st.setObject(1, id);
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public static UsuarioBean getById(Connection con, int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        UsuarioBean usuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            result = st.executeQuery();
            if (result.next()) {
                usuario = new UsuarioBean();
                usuario.setId(result.getInt("id"));
                usuario.setCpf(result.getString("cpf"));
                usuario.setNome(result.getString("nome"));
                usuario.setSobrenome(result.getString("sobrenome"));
                usuario.setDataCadastro(result.getDate("data_cadastro").toLocalDate());
                usuario.setDataNascimento(result.getDate("data_nascimento").toLocalDate());
                usuario.setIdContato(result.getInt("id_contato"));
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
