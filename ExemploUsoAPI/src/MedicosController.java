
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rebeca
 */
public class MedicosController {
    public void createMedico(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novo Médico: ");
        System.out.print("codm: ");
        int codm = input.nextInt();
        System.out.print("nome: ");
        String nome = input.next();
        System.out.print("idade: ");
        int idade = input.nextInt();
        System.out.print("especialidade: ");
        String especialidade = input.next();    
        System.out.print("cpf: ");
        long cpf = input.nextLong();        
        System.out.print("cidade: ");
        String cidade = input.next();         
        System.out.print("nroa: ");
        int nroa = input.nextInt();
        
        MedicosBean mb = new MedicosBean(codm, nome, idade, especialidade, cpf, cidade, nroa);
        MedicosModel.create(mb, con);
        System.out.println("Médico criado com sucesso!!");     
    }

    void listarMedicos(Connection con) throws SQLException {
        HashSet all = MedicosModel.listAll(con);
        Iterator<MedicosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarMedicosAmbulatorios(Connection con) throws SQLException {
        HashSet all = MedicosModel.listAllWithAmbulatorios(con);
        Iterator<MedicosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    public void deleteMedico(Connection con)throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o código do médico a ser excluído.");
        int codm = input.nextInt();
        MedicosModel.delete(codm, con);
        System.out.print("Médico excluído com sucesso.");
    }
    
    public void patchMedico(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o código do médico (codm) a ser alterado: ");
        int codm = input.nextInt();
        int op = patchMedicoMenu();

        switch (op) {
            case 1:
                getMedico(con, codm);
                System.out.print("Novo nome: ");
                input.nextLine();
                String novoNome = input.nextLine();
                MedicosModel.patch("nome", novoNome, codm, con);
                break;
            case 2:
                getMedico(con, codm);
                System.out.print("Nova idade: ");
                int novaIdade = input.nextInt();
                MedicosModel.patch("idade", novaIdade, codm, con);
                break;
            case 3:
                getMedico(con, codm);
                System.out.print("Nova especialidade: ");
                input.nextLine();
                String novaEspecialidade = input.nextLine();
                MedicosModel.patch("especialidade", novaEspecialidade, codm, con);
                break;
            case 4:
                getMedico(con, codm);
                System.out.print("Novo CPF: ");
                long novoCpf = input.nextLong();
                MedicosModel.patch("cpf", novoCpf, codm, con);
                break;
            case 5:
                getMedico(con, codm);
                System.out.print("Nova cidade: ");
                input.nextLine();
                String novaCidade = input.nextLine();
                MedicosModel.patch("cidade", novaCidade, codm, con);
                break;
            case 6:
                getMedico(con, codm);
                System.out.print("Novo NROA: ");
                int novoNroa = input.nextInt();
                MedicosModel.patch("nroa", novoNroa, codm, con);
                break;
        }

        System.out.println("Médico alterado com sucesso!!");
    }

    private int patchMedicoMenu() {
        System.out.println("Selecione o atributo a ser alterado:");
        System.out.println("1. Nome");
        System.out.println("2. Idade");
        System.out.println("3. Especialidade");
        System.out.println("4. CPF");
        System.out.println("5. Cidade");
        System.out.println("6. NROA");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private void getMedico(Connection con, int codm) throws SQLException {
        MedicosBean medico = MedicosModel.getById(con, codm);
        System.out.println("Detalhes do Médico: " + medico);
    }
}
