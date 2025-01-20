package com.loja.modelo.Produto;

import java.util.Objects;

public class Produto {
    private int ID;
    private  String nome;
    private double preco;
    private  int quantidadeEstoque;
    private String categoria ;

    public Produto (String nome,double preco, int quantidadeEstoque,String categoria){
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    // metodos Getters and Setters
    public int getID () {
        return ID;
    }
    public void setID (int ID){
        this.ID = ID;
    }

    public String getNome (){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public  double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQuantidadeEstoque(){
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque){
      this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria ;
    }

    // Metodo toString
    public String toString(){
        return "Produto "+ "\n" +
                "ID                = " + ID + "\n" +
                "Nome              = " + nome + "\n" +
                "Preco             = " + preco + "\n" +
                "QuantitadeEstoque = " + quantidadeEstoque + "\n" +
                "Categoria         = " + categoria ;
    }

    public boolean equals(Object o){
        if(this == o ) return true;
        if (o== null ||  getClass() != o.getClass()) return false;
        Produto produto = (Produto) o ;
        return  this.ID == produto.ID;
    }

    public int hashCode(){
     return Objects.hashCode(ID);
    }
}
