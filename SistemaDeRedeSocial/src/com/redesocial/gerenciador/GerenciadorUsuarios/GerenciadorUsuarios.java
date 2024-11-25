package  com.redesocial.gerenciador.GerenciadorUsuarios;

import com.redesocial.modelo.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();
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
    public Usuario buscarPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    //Metodo para buscar por UserName
    public Usuario buscarPorUsername(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null; // Retorna null se não encontrar o usuário
    }
}
