package com.redesocial.ui.Util ;

import com.redesocial.gerenciador.GerenciadorPosts.GerenciadorPosts;
import com.redesocial.gerenciador.GerenciadorUsuarios.GerenciadorUsuarios;
import com.redesocial.modelo.Post.Post;
import com.redesocial.modelo.Usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuUsuario {

    private Usuario usuarioLogado;
    private GerenciadorUsuarios gerenciadorUsuarios;
    private GerenciadorPosts gerenciadorPosts;
    private Scanner scanner;

    // Metodo Menu Usuario
    public MenuUsuario(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        this.gerenciadorUsuarios = new GerenciadorUsuarios();
        this.gerenciadorPosts = new GerenciadorPosts();
        this.scanner = new Scanner(System.in);
    }

    // Método principal para exibir o menu do usuário
    public void exibirMenu() {
        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu do Usuário ===");
            System.out.println("1. Criar Post");
            System.out.println("2. Ver Perfil");
            System.out.println("3. Buscar Usuários");
            System.out.println("4. Gerenciar Amigos");
            System.out.println("5. Ver Feed de Notícias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a linha em branco

            switch (opcao) {
                case 1:
                    criarPost();
                    break;
                case 2:
                    verPerfil();
                    break;
                case 3:
                    buscarUsuarios();
                    break;
                case 4:
                    gerenciarAmizades();
                    break;
                case 5:
                    verFeedNoticias();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // Método para criar um novo post
    private void criarPost() {
        System.out.print("Digite o conteúdo do post: ");
        String conteudo = scanner.nextLine();

        Post post = new Post(usuarioLogado, conteudo);
        gerenciadorPosts.criar(post);
        System.out.println("Post criado com sucesso!");
    }

    // Método para visualizar o perfil do usuário
    private void verPerfil() {
        System.out.println("=== Perfil de " + usuarioLogado.getNome() + " ===");
        System.out.println("Username: " + usuarioLogado.getUsername());
        System.out.println("Email: " + usuarioLogado.getEmail());
        System.out.println("Data de Cadastro: " + usuarioLogado.getDataCadastro());
        System.out.println("Amigos: " + usuarioLogado.getAmigos().size());
        System.out.println("Posts: " + usuarioLogado.getPosts().size());
    }

    // Método para buscar usuários
    private void buscarUsuarios() {
        System.out.print("Digite o nome ou username do usuário que deseja buscar: ");
        String nomeOuUsername = scanner.nextLine();

        List<Usuario> usuarios = gerenciadorUsuarios.buscarPorNome(nomeOuUsername);
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado com esse nome ou username.");
        } else {
            System.out.println("Usuários encontrados:");
            for (Usuario u : usuarios) {
                System.out.println("- " + u.getNome() + " (" + u.getUsername() + ")");
            }
        }
    }

    // Método para gerenciar amizades
    private void gerenciarAmizades() {
        System.out.println("1. Adicionar Amigo");
        System.out.println("2. Remover Amigo");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha em branco

        switch (opcao) {
            case 1:
                adicionarAmigo();
                break;
            case 2:
                removerAmigo();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    // Método para adicionar um amigo
    private void adicionarAmigo() {
        System.out.print("Digite o username do amigo que deseja adicionar: ");
        String usernameAmigo = scanner.nextLine();

        Usuario amigo = gerenciadorUsuarios.buscarPorUsername(usernameAmigo);
        if (amigo != null) {
            usuarioLogado.adicionarAmigo(amigo);
            System.out.println(amigo.getNome() + " foi adicionado como amigo.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    // Método para remover um amigo
    private void removerAmigo() {
        System.out.print("Digite o username do amigo que deseja remover: ");
        String usernameAmigo = scanner.nextLine();

        Usuario amigo = gerenciadorUsuarios.buscarPorUsername(usernameAmigo);
        if (amigo != null) {
            usuarioLogado.removerAmigo(amigo);
            System.out.println(amigo.getNome() + " foi removido da lista de amigos.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    // Método para visualizar o feed de notícias
    private void verFeedNoticias() {
        List<Post> posts = gerenciadorPosts.listarPorUsuario(usuarioLogado.getId());
        if (posts.isEmpty()) {
            System.out.println("Não há posts para exibir.");
        } else {
            System.out.println("=== Feed de Notícias ===");
            for (Post post : posts) {
                System.out.println(post.getConteudo());
                System.out.println("Publicado por: " + post.getAutor().getNome());
                System.out.println("Data: " + post.getDataPublicacao());
                System.out.println("------------------------------");
            }
        }
    }
}
