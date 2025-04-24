package Modulos.EPIs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EPIs {
    static ArrayList<EPIs>listarEPIs = new ArrayList<>();
    String nome;
    int quantidade;
    Date data;

    public EPIs(String nome, int quantidade, Date data) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.data = data;
    }

    public static ArrayList<EPIs> getListarEPIs() {
        return listarEPIs;
    }

    public static void setListarEPIs(ArrayList<EPIs> listarEPIs) {
        EPIs.listarEPIs = listarEPIs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public static void MenuEPIs(){
        Scanner entrada = new Scanner(System.in);
        int opcoe;
      do {
          System.out.println("===== Menu EPIs =====");
          System.out.println("1.Cadastrar EPIs");
          System.out.println("2.Listar EPIs");
          System.out.println("3.Atualizar EPIs");
          System.out.println("4.Remover EPIs");
          System.out.println("0.Sair");
          System.out.println("Escolha: ");
          opcoe = entrada.nextInt();
          entrada.nextLine();

          switch (opcoe){
              case 1 : cadastrarEPIs();
                  System.out.println();
              break;
              case 2 : ListarEPIs();
                  System.out.println();
              break;
          }

         }while (opcoe!=0);
    }

    public static void cadastrarEPIs(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do EPI: ");
        String nome = entrada.nextLine();
        System.out.println("Digite a quantidade: ");
        int quant = entrada.nextInt();
        Date dataCadastrado = new Date();
        EPIs novoEPI = new EPIs(nome,quant,dataCadastrado);
        listarEPIs.add(novoEPI);
        System.out.println("~~~~~~EPI cadastrado com sucesso~~~~~~");
        System.out.println("Nome      : " +nome);
        System.out.println("Qunatidade: " +quant);
        System.out.println("Date      : " +dataCadastrado);
        System.out.println();
    }

    public static void ListarEPIs(){
        if (listarEPIs.isEmpty()){
            System.out.println("Nenhum EPI cadastrado...");
            System.out.println();
            return;
        }
        for (int i=0; i<listarEPIs.size();i++){
            System.out.println("======= Lista De EPIs =======");
            System.out.println((i+1)+ "-" + listarEPIs.get(i));
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "       ✳Quantidade: " + quantidade + "         ✳Data: " + data;
    }
}
