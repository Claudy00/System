package Modulos.EPIs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EPIs {
    static ArrayList<EPIs>listarEPIs = new ArrayList<>();
    String nome;
    int quantidade;
    int quantidadeEstoque;
    Date data;

    public EPIs(String nome, int quantidade,int quantidadeEstoque, Date data) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public int getQuantidadeEstoque() { return quantidadeEstoque; }

    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

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
              case 3 : atualizarEPIs();
                  System.out.println();
              break;
              case 4: removerEPIs();
                  System.out.println();
                  break;
              default:
                  System.out.println("Opcoe Invalida....");
                  System.out.println();
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
        EPIs novoEPI = new EPIs(nome,quant,quant,dataCadastrado);
        listarEPIs.add(novoEPI);
        System.out.println("~~~~~~ EPI cadastrado com sucesso~~~~~~");
        System.out.println("Nome           : " +nome);
        System.out.println("Quantidade     : " +quant);
        System.out.println("Quantidade Est.: " +quant);
        System.out.println("Date      : " +dataCadastrado);
        System.out.println();
    }

    public static void ListarEPIs(){
        if (listarEPIs.isEmpty()){
            System.out.println("Nenhum EPI cadastrado...");
            System.out.println();
            return;
        }

        System.out.println("======= Lista De EPIs =======");
        for (int i=0; i<listarEPIs.size();i++){
            System.out.println("ID:"+(i+1) + listarEPIs.get(i));
        }
    }

    @Override
    public String toString(){
        return "        ✳Nome: " + nome + "       ✳Quantidade Estoque: " + quantidade + "         ✳Data: " + data;
    }

    public static void atualizarEPIs(){
        Scanner entrada = new Scanner(System.in);
        int ID;
        if (listarEPIs.isEmpty()){
            System.out.println("Nenhum EPI cadastrado...");
            System.out.println();
            return;
        }

        for (int i=0; i<listarEPIs.size();i++){
            System.out.println("Digite o ID do EPI: ");
            ID = entrada.nextInt();
            entrada.nextLine();
            ID--;

            EPIs EPI = listarEPIs.get(i);

            if (ID>=listarEPIs.size()){
                System.out.println("ID Invalido....");
                System.out.println();
                return;
            }
            System.out.println("Digite o novo nome do EPI: ");
            String novoNome = entrada.next();

            System.out.println("Digite a nova quantidade : ");
            int novaQuantidade = entrada.nextInt();

            EPI.setNome(novoNome);
            EPI.setQuantidade(novaQuantidade);
            EPI.setData(new Date());

            System.out.println("===== EPI atualizado com sucesso ===== ");
            System.out.println("ID: "+(ID+1));
            System.out.println("Novo nome      : "+EPI.getNome());
            System.out.println("Quantidade Est.: "+EPI.getQuantidade());
            System.out.println("Data da Atual..: "+new Date());
            System.out.println();
            break;
        }
    }

    public static void removerEPIs(){
        Scanner entrada = new Scanner(System.in);
        if (listarEPIs.isEmpty()){
            System.out.println("Nenhum EPI cadastrado...");
            System.out.println();
            return;
        }

            System.out.println("Digite o ID do EPI a remover: ");
            int ResetID = entrada.nextInt();
            ResetID--;
            if (ResetID>=listarEPIs.size()){
                System.out.println("ID Invalido...");
                System.out.println();
                return;
            }
        EPIs removido = listarEPIs.remove(ResetID);
        System.out.println("EPI removido com sucesso...✅✅✅");
        System.out.println("Nome : "+ removido.getNome());
    }

}
