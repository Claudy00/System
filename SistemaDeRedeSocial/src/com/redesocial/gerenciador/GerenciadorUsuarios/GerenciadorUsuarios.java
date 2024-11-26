package  com.redesocial.gerenciador.GerenciadorUsuarios;

import com.redesocial.modelo.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {
    private static List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

// Metodo cadastrar Usuario
    public void cadastrar(Usuario usuario) {
        // Valida dados
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            return;
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            System.out.println("Email não pode ser vazio.");
            return;
        }

        // Atribui ID
        usuario.setId(proximoId);

        // Adiciona à lista
        usuarios.add(usuario);

        // Incrementa o ID para o próximo usuário
        proximoId++;

        System.out.println("Usuário cadastrado com sucesso: " + usuario);
    }

    // Método para buscar usuário por ID
    public static Usuario buscarPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    //Metodo para buscar por UserName
    public static Usuario buscarPorUsername(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null; // Retorna null se não encontrar o usuário
    }

    // Método para buscar usuários por Nome
    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> resultados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }

    // Metodo Atualizar Usuario
     public boolean Atualizar (Usuario usuario){
        for (Usuario pessoal : usuarios){
            if (pessoal.getId()== usuario.getId()){
                pessoal.setNome(usuario.getNome());
                pessoal.setEmail(usuario.getEmail());
                return  true;
            }
        }
        return false;
     }

     // Metodo Deletar por ID
    public  boolean Deletar (int id){
        for (Usuario pessoal : usuarios){
            if (pessoal.getId()== id){
                usuarios.remove(pessoal);
                return true ;
            }
        }
        return  false ;
    }

    //Metodo para adicionar Amizade
    public void adicionarAmizade(int idUsuario1, int idUsuario2){
        Usuario usuario1 = null ;
        Usuario usuario2 = null ;

        for (Usuario pessoal : usuarios){
            if (pessoal.getId() == idUsuario1){
                usuario1 = pessoal ;
            }

            if (pessoal.getId() == idUsuario2){
                usuario2 = pessoal;
            }
        }
        if (usuario1!=null && usuario2!=null){
            usuario1.adicionarAmigo(usuario1);
            usuario2.adicionarAmigo(usuario2);
            System.out.println("Amizade entre " + usuario1.getNome() + " e " + usuario2.getNome() + " foi criada com sucesso!");
        } else {
            System.out.println("Um ou ambos os usuários não foram encontrados.");
        }

    }

    // Metodo para remover Amizade
    public void remover (int idUsuario1, int idUsuario2){
        Usuario usuario1 = null ;
        Usuario usuario2 = null ;

        for (Usuario amigo : usuarios){
            if (amigo.getId()== idUsuario1){
                usuario1 = amigo;
            }

            if (amigo.getId()== idUsuario2){
                usuario2 = amigo ;
            }
        }
        if (usuario1!=null && usuario2!=null){
            usuario1.removerAmigo(usuario1);
            usuario2.removerAmigo(usuario2);
            System.out.println("Amizade removida com sucesso.");
        } else {
            System.out.println("Os usuários não são amigos.");
        }
    }
    // Método privado para validar um usuário
    private void validarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }

        // Verifica se o nome é válido
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio.");
        }

        // Verifica se o username é válido
        if (usuario.getUsername() == null || usuario.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username não pode ser vazio.");
        }

    }


    }
