package com.redesocial.ui;

import com.redesocial.gerenciador.GerenciadorUsuarios.GerenciadorUsuarios;
import com.redesocial.modelo.Post.Post;
import com.redesocial.modelo.Usuario.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        // Criação de uma instância do Scanner dentro do método main
        Scanner scanner = new Scanner(System.in);

        // Cria uma instância do MenuPrincipal
        MenuPrincipal menu = new MenuPrincipal();

        // Exibe o menu
        menu.exibirMenu(scanner);
    }

    // Metodo exibir Menu
    public void exibirMenu(Scanner scanner) {
        System.out.println("=== Sistema de Rede Social ===");
        System.out.println("1. Fazer Login");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                fazerLogin(scanner);
                break;
            case 2:
                cadastrarUsuario();
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                exibirMenu(scanner);
                break;
        }
    }

    // Metodo Fazer Login
    private void fazerLogin(Scanner scanner) {


        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();


        Usuario usuarioLogado = GerenciadorUsuarios.buscarPorUsername(username);

        if (usuarioLogado != null && usuarioLogado.getSenha().equals(senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome());
            exibirMenuLogado(scanner ,usuarioLogado);
        } else {
            System.out.println("Username ou senha inválidos. Tente novamente.");
            fazerLogin(scanner);
        }
    }

    // Metodo cadastrar Usuario
    private void cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Verifica se o username já existe
        if (GerenciadorUsuarios.buscarPorUsername(username) != null) {
            System.out.println("Esse username já está em uso. Tente outro.");
            cadastrarUsuario();
            return;
        }

        exibirMenu(scanner);
    }

    // Metodo Exibir Menu Logado
    private void exibirMenuLogado(Scanner scanner ,Usuario usuario) {
        System.out.println("=== Menu do Usuário ===");
        System.out.println("1. Visualizar Perfil");
        System.out.println("2. Fazer um Post");
        System.out.println("3. Adicionar Amigo");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                visualizarPerfil(usuario);
                break;
            case 2:
                fazerPost(usuario);
                break;
            case 3:
                Usuario.adicionarAmigo(usuario);
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                exibirMenuLogado(scanner,usuario);
                break;
        }
    }

    // Metodo Visualizar Perfil
    private void visualizarPerfil(Usuario usuario) {
        System.out.println("=== Perfil de " + usuario.getNome() + " ===");
        System.out.println("Username: " + usuario.getUsername());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Data de Cadastro: " + usuario.getDataCadastro());
        System.out.println("Amigos: " + usuario.getAmigos().size());
    }

    // Metodo Fazer Post
    private void fazerPost(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o conteúdo do post: ");
        String conteudo = scanner.nextLine();

        // Cria um novo post e adiciona à lista de posts do usuário
        Post novoPost = new Post(usuario, conteudo);
        usuario.adicionarPost(novoPost);
        System.out.println("Post feito com sucesso!");
    }
}
