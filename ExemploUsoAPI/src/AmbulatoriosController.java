
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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
public class AmbulatoriosController {
    
    public void deleteAmbulatorio(Connection con)throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o código do ambulatorio (NROA) a ser excluído.");
        int nroa = input.nextInt();
        AmbulatoriosModel.delete(nroa, con);
        System.out.print("Ambulatório excluído com sucesso.");
    }
    
    public void createAmbulatorio(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novo Ambulatório: ");
        System.out.print("nroa: ");
        int nroa = input.nextInt();
        System.out.print("capacidade: ");
        int capacidade = input.nextInt();
        System.out.print("andar: ");
        int andar = input.nextInt();
        AmbulatoriosBean ab = new AmbulatoriosBean(nroa, capacidade, andar);
        AmbulatoriosModel.create(ab, con);
        System.out.println("Ambulatório criado com sucesso!!");
    }
    
    public void patchAmbulatorio(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite a NROA do ambulatório a ser alterado: ");
        int nroa = input.nextInt();
        int op = patchMenu();
        switch (op) 
        {
            case 1: 
                getAmbulatorio(con, nroa);
                System.out.print("Nova Capacidade: ");
                int novaCapacidade = input.nextInt();
                AmbulatoriosModel.patch("capacidade", novaCapacidade, nroa, con);
                break;
            case 2: 
                getAmbulatorio(con, nroa);
                System.out.print("Novo Andar: ");
                int novoAndar = input.nextInt();
                AmbulatoriosModel.patch("andar", novoAndar, nroa, con);
                break;
        }
        
        System.out.println("Ambulatório alterado com sucesso!!");
    }
    
    void getAmbulatorio(Connection con, int nroaId) throws SQLException {
        AmbulatoriosBean ambulatorio = AmbulatoriosModel.getById(con, nroaId);

        if (ambulatorio != null) {
            System.out.println(ambulatorio); 
        } else {
            System.out.println("Ambulatorio with ID " + nroaId + " not found.");
        }
}
    
    void listarAmbulatorio(Connection con) throws SQLException {
        HashSet all = AmbulatoriosModel.listAll(con);
        Iterator<AmbulatoriosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    private static int patchMenu() {
        System.out.println("");
        System.out.println("Digite as propriedades que deseja alterar: ");
        System.out.println("NÃO É POSSÍVEL ALTERAR A NROA");
        System.out.println("1 - Capacidade");
        System.out.println("2 - Andar");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
