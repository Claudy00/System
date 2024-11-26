package com.redesocial.gerenciador.GerenciadorPosts;

import com.redesocial.gerenciador.GerenciadorUsuarios.GerenciadorUsuarios;
import com.redesocial.modelo.Comentario.Comentario;
import com.redesocial.modelo.Post.Post;
import com.redesocial.modelo.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPosts {
    private List<Post> posts = new ArrayList<>();
    private int proximoId = 1;


    // Método para criar um post
    public void criar(Post post) {
        validarPost(post);
        post.setId(proximoId++);
        posts.add(post);
    }

    private void validarPost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("O post não pode ser nulo.");
        }

        // Verifica se o conteúdo do post não é vazio ou nulo
        if (post.getConteudo() == null || post.getConteudo().isEmpty()) {
            throw new IllegalArgumentException("Conteúdo do post não pode ser vazio.");
        }

        // Verifica se o autor do post existe
        if (post.getAutor() == null) {
            throw new IllegalArgumentException("O autor do post não pode ser nulo.");
        }
    }

    // Método para buscar um post pelo ID
    public Post buscarPorId(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    // Método para listar posts de um usuário específico
    public List<Post> listarPorUsuario(int idUsuario) {
        List<Post> postsUsuario = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAutor().getId() == idUsuario) {
                postsUsuario.add(post);
            }
        }
        return postsUsuario;
    }

    // Método para curtir um post
    public void curtir(int idPost, int idUsuario) {
        Post post = buscarPorId(idPost);
        if (post != null) {
            // Método para buscar usuário pelo ID
            Usuario usuario = GerenciadorUsuarios.buscarPorId(idUsuario);
            if (usuario != null) {
                post.adicionarCurtida(usuario);
            }
        }
    }


    // Método para descurtir um post
    public void descurtir(int idPost, int idUsuario) {
        Post post = buscarPorId(idPost);
        if (post != null) {
            // Método para buscar usuário pelo ID
            Usuario usuario = GerenciadorUsuarios.buscarPorId(idUsuario);
            if (usuario != null) {
                post.removerCurtida(usuario);
            }
        }
    }

    // Método para comentar em um post
    public void comentar(Comentario comentario) {
        Post post = buscarPorId(comentario.getPost().getId());
        if (post != null) {
            post.adicionarComentario(comentario);
        }
    }

    // Método para deletar um post
    public boolean deletar(int id) {
        Post post = buscarPorId(id);
        if (post != null) {
            posts.remove(post);
            return true;
        }
        return false;
    }

}
