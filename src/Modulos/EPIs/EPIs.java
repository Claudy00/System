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


    }
}
