package Controllers;


import Beans.ProdutoBean;
import Beans.UsuarioBean;
import Enums.GeneroEnum;
import Enums.StatusEnum;
import Enums.TipoEnum;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

public class ProdutosController {

    public void deleteProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o ID do usuário a ser excluído: ");
        int id =Integer.parseInt(input.nextLine());
        ProdutoModel.delete(id, con);
        System.out.println("Usuário excluído com sucesso.");
    }

    public void createProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Usuário: ");
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = input.nextLine();
        System.out.print("Digite seu ano de Nascimento: ");
        int anoNascimento = Integer.parseInt(input.next());
        System.out.print("Digite seu mês de Nascimento: ");
        int mesNascimento = Integer.parseInt(input.next());
        System.out.print("Digite seu dia de Nascimento: ");
        int diaNascimento = Integer.parseInt(input.next());
        // CRIAR PARTE DE ENDEREÇO E CONTATO AQUI 
        
        System.out.print("ID Contato: ");
        String idContato = input.nextLine();
        
        System.out.print("Gênero (MASCULINO/FEMININO): ");
        String genero = input.nextLine();
        System.out.print("Status (ATIVO/INATIVO): ");
        String status = input.nextLine();
        System.out.print("Tipo (ADMIN/USER): ");
        String tipo = input.nextLine();
        
        UsuarioBean usuario = new UsuarioBean();
        usuario.setId(AtomicIDGenerator.generateID());
        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setDataCadastro(LocalDate.now());
        usuario.setDataNascimento(LocalDate.of(anoNascimento, Month.of(mesNascimento), diaNascimento));
        usuario.setIdContato(AtomicIDGenerator.generateID());
        usuario.setGenero(GeneroEnum.valueOf(genero));
        usuario.setStatus(StatusEnum.valueOf(status));
        usuario.setTipo(TipoEnum.valueOf(tipo));
        
        ProdutoModel.create(usuario, con);
        System.out.println("Usuário criado com sucesso!!");
    }

    public void patchProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o ID do usuário a ser alterado: ");
        int id = Integer.parseInt(input.nextLine());
        int op = patchMenu();
        switch (op) {
            case 1:
                getProduto(con, id);
                System.out.print("Novo CPF: ");
                String novoCpf = input.nextLine();
                ProdutoModel.patch("cpf", novoCpf, id, con);
                break;
            case 2:
                getProduto(con, id);
                System.out.print("Novo Nome: ");
                String novoNome = input.nextLine();
                ProdutoModel.patch("nome", novoNome, id, con);
                break;
            case 3:
                getProduto(con, id);
                System.out.print("Novo Sobrenome: ");
                String novoSobrenome = input.nextLine();
                ProdutoModel.patch("sobrenome", novoSobrenome, id, con);
                break;
            case 4:
                getProduto(con, id);
                System.out.print("Nova Data de Cadastro (YYYY-MM-DD): ");
                String novaDataCadastro = input.nextLine();
                ProdutoModel.patch("data_cadastro", novaDataCadastro, id, con);
                break;
            case 5:
                getProduto(con, id);
                System.out.print("Nova Data de Nascimento (YYYY-MM-DD): ");
                String novaDataNascimento = input.nextLine();
                ProdutoModel.patch("data_nascimento", novaDataNascimento, id, con);
                break;
            case 6:
                getProduto(con, id);
                System.out.print("Novo ID Contato: ");
                String novoIdContato = input.nextLine();
                ProdutoModel.patch("id_contato", UUID.fromString(novoIdContato).toString(), id, con);
                break;
            case 7:
                getProduto(con, id);
                System.out.print("Novo Gênero (MASCULINO/FEMININO): ");
                String novoGenero = input.nextLine();
                ProdutoModel.patch("genero", GeneroEnum.valueOf(novoGenero).toString(), id, con);
                break;
            case 8:
                getProduto(con, id);
                System.out.print("Novo Status (ATIVO/INATIVO): ");
                String novoStatus = input.nextLine();
                ProdutoModel.patch("status", StatusEnum.valueOf(novoStatus).toString(), id, con);
                break;
            case 9:
                getProduto(con, id);
                System.out.print("Novo Tipo (ADMIN/USER): ");
                String novoTipo = input.nextLine();
                ProdutoModel.patch("tipo", TipoEnum.valueOf(novoTipo).toString(), id, con);
                break;
        }
        System.out.println("Usuário alterado com sucesso!!");
    }

    void getProduto(Connection con, int id) throws SQLException {
        UsuarioBean usuario = ProdutoModel.getById(con, id);
        if (usuario != null) {
            System.out.println(usuario);
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }

    public void listarProdutos(Connection con) throws SQLException {
        HashSet<ProdutoBean> all = ProdutoModel.listAll(con);
        Iterator<ProdutoBean> it = all.iterator();
        int indexDoItemAtual = 0;
        
        while (it.hasNext()) {
            
            ProdutoBean produto = it.next();
            System.out.println("Item [" + indexDoItemAtual + "] - " + produto.getNome()+
                               ", Valor: R$ " + produto.getValor() +
                               ", Quantidade em Estoque: " + produto.getQuantidadeEstoque());
            indexDoItemAtual ++;
        }
        
    }

    private static int patchMenu() {
        System.out.println("");
        System.out.println("Digite as propriedades que deseja alterar: ");
        System.out.println("1 - CPF");
        System.out.println("2 - Nome");
        System.out.println("3 - Sobrenome");
        System.out.println("4 - Data de Cadastro");
        System.out.println("5 - Data de Nascimento");
        System.out.println("6 - ID Contato");
        System.out.println("7 - Gênero");
        System.out.println("8 - Status");
        System.out.println("9 - Tipo");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
