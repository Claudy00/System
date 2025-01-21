package com.loja.gerenciador.GerenciadorProdutos ;

import com.loja.modelo.Produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
    // Attributos
  private List<Produto>produtos ;
  private int proximoID ;

    // Construtor que inicializa a lista de produtos e o contador de ID
public GerenciadorProdutos(){
    this.produtos = new ArrayList<>();
    this.proximoID = 1 ;
  }

  //Metodo Criar Produto
public void criar(Produto produto){
    produto.setID(proximoID);
    if (produto.getNome()== null || produto.getNome().isEmpty()
            || produto.getPreco()<=0)
        throw new IllegalArgumentException("Dados Invalidos");

    produtos.add(produto);

    proximoID++;
}

//Metodo buscar Produto por ID
public  Produto buscarPorId(int Id){
    for (Produto prod : produtos){
        if (prod.getID()==Id ){
            return prod ;
        }
    }
    return null ;
}

}
