
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
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
public class AmbulatoriosModel {

    public static void create(AmbulatoriosBean a, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO ambulatorios (nroa, capacidade, andar) VALUES (?,?,?)");
            st.setInt(1, a.getNroa());
            st.setInt(2, a.getCapacidade());
            st.setInt(3, a.getAndar());
            st.execute();
            st.close();  
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT nroa, capacidade, andar FROM ambulatorios";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new AmbulatoriosBean(result.getInt(1), result.getInt(2), result.getInt(3)));
            }
        return list;
    }
    
    public static void patch(String coluna, int valor, int idNroa, Connection con) throws SQLException {
        PreparedStatement st;
            String query = "UPDATE ambulatorios SET " + coluna + " = ? WHERE nroa = ?";
            st = con.prepareStatement(query);
            st.setInt(1, valor);
            st.setInt(2, idNroa);
            st.execute();
            st.close();  
    }
    
    public static void delete(int nroa, Connection con) throws SQLException {
        PreparedStatement st = null;
        try {
            String query = "DELETE FROM ambulatorios WHERE nroa = ?";
            st = con.prepareStatement(query);
            st.setInt(1, nroa);
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    
    public static AmbulatoriosBean getById(Connection con, int nroaId) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        AmbulatoriosBean ambulatorio = null;
        try {
            String sql = "SELECT * FROM ambulatorios WHERE nroa = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, nroaId);
            result = st.executeQuery();
            if (result.next()) {
                ambulatorio = new AmbulatoriosBean(result.getInt("nroa"), result.getInt("capacidade"), result.getInt("andar"));
            }
        } finally {
            if (result != null) {
                result.close();  
            }
            if (st != null) {
                st.close();  
            }
        }
        return ambulatorio; 
    }
}
