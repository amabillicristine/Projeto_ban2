
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rebeca
 */
public class MedicosModel {

    static void create(MedicosBean m, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO medicos (codm, nome, idade, especialidade, cpf, cidade, nroa) "
                    + "VALUES (?,?,?,?,?,?,?)");
            st.setInt(1, m.getCodm());
            st.setString(2, m.getNome());
            st.setInt(3, m.getIdade());
            st.setString(4, m.getEspecialidade());
            st.setLong(5, m.getCpf());
            st.setString(6, m.getCidade());
            st.setInt(7, m.getNroa());
            st.execute();
            st.close();
    }
    
    public static void delete(int codm, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            String deleteConsultasQuery = "DELETE FROM consultas WHERE codm = ?";
            st = con.prepareStatement(deleteConsultasQuery);
            st.setInt(1, codm);
            st.executeUpdate();
            st.close();
            
            String query = "DELETE FROM medicos WHERE codm = ?";
            st = con.prepareStatement(query);
            st.setInt(1, codm);
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
    }
}

    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT codm, nome, idade, especialidade, cpf, cidade, nroa FROM medicos";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new MedicosBean(result.getInt(1), result.getString(2), result.getInt(3), 
                result.getString(4), result.getLong(5), result.getString(6), result.getInt(7)));
            }
        return list;
    }    

    static HashSet listAllWithAmbulatorios(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codm, nome, idade, especialidade, cpf, cidade, medicos.nroa, andar, capacidade FROM medicos NATURAL JOIN ambulatorios";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            MedicosBean mb = new MedicosBean(result.getInt(1), result.getString(2), result.getInt(3),
                    result.getString(4), result.getLong(5), result.getString(6), result.getInt(7));
            AmbulatoriosBean a = new AmbulatoriosBean(result.getInt(7), result.getInt(8), result.getInt(9));
            mb.setAmbulatorio(a);
            list.add(mb);
        }
        return list;
    }
    
    public static MedicosBean getById(Connection con, int codm) throws SQLException {
    PreparedStatement st = null;
    ResultSet result = null;
    MedicosBean medico = null;
    try {
        String sql = "SELECT * FROM medicos WHERE codm = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, codm);
        result = st.executeQuery();
        if (result.next()) {
            medico = new MedicosBean(
                result.getInt("codm"), 
                result.getString("nome"), 
                result.getInt("idade"), 
                result.getString("especialidade"), 
                result.getLong("cpf"), 
                result.getString("cidade"), 
                result.getInt("nroa")
            );
        }
    } finally {
        if (result != null) {
            result.close();
        }
        if (st != null) {
            st.close();
        }
    }
    return medico; 
    }
    public static void patch(String coluna, Object valor, int codm, Connection con) throws SQLException {
    PreparedStatement st = null;
    try {
        String query = "UPDATE medicos SET " + coluna + " = ? WHERE codm = ?";
        st = con.prepareStatement(query);

        if (valor instanceof Integer) {
            st.setInt(1, (Integer) valor);
        } else if (valor instanceof Long) {
            st.setLong(1, (Long) valor);
        } else if (valor instanceof String) {
            st.setString(1, (String) valor);
        } else {
            throw new IllegalArgumentException("Unsupported data type for the value");
        }

        st.setInt(2, codm);
        st.executeUpdate();
    } finally {
        if (st != null) {
            st.close();
        }
    }
}


}
