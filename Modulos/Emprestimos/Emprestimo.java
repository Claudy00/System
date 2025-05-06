package Modulos.Emprestimos;

import Modulos.EPIs.EPIs;
import Modulos.Funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Emprestimo {
   static ArrayList<Emprestimo>emprestimos = new ArrayList<>();
    Funcionario fun1;
    EPIs EPI;
    int quantidade;
    Date date;

    public Emprestimo(Funcionario fun1,EPIs EPI, int quantidade, Date data){
        this.fun1 = fun1;
        this.EPI =EPI;
        this.quantidade = quantidade;
        this.date = data;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Funcionario getFun1() {
        return fun1;
    }

    public void setFun1(Funcionario fun1) {
        this.fun1 = fun1;
    }

    public EPIs getEPI() {
        return EPI;
    }

    public void setEPI(EPIs EPI) {
        this.EPI = EPI;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void ModuloEmprestimo(){
        Scanner entrada = new Scanner(System.in);
        int opcoe;

        do {
            System.out.println("======= Emprestimo de EPIS =======");
            System.out.println("1.cadastrar Emprestimos");
            System.out.println("2.Listar Emprestimos");
            System.out.println("3.Atualizar Emprestimos");
            System.out.println("4.Remover Emprestimos");
            System.out.println("0.Voltar...");
            System.out.println("Escolha: ");
            opcoe = entrada.nextInt();
            entrada.nextLine();

            switch (opcoe){
                case 1:cadastrarEmprestimos();
                    System.out.println();
                    break;
                case 2:listarEmprestimos();
                    System.out.println();
                    break;
            }
        }while (opcoe!=0);
    }

    public static void cadastrarEmprestimos(){
        ArrayList<Funcionario> funcionarios = Funcionario.getFuncionarios();
        ArrayList<EPIs> EP1 = EPIs.getListarEPIs();
        Scanner entrada = new Scanner(System.in);
        if (funcionarios.isEmpty()){
            System.out.println("Nenhum funcionario cadastrado...");
            return;
        }

        if (EP1.isEmpty()){
            System.out.println("Nenhum EPI cadastrado...");
            return;
        }

        System.out.println("Digite o ID do Funcionario: ");
        int IndexFun = entrada.nextInt();
        IndexFun--;
        entrada.nextLine();
        System.out.println();

        if (IndexFun>=funcionarios.size() || IndexFun<0){
            System.out.println("ID invalido....");
            System.out.println();
            return;
        }

        System.out.println("===== Lista De EPIs =====");
       for (int i=0; i< EP1.size(); i++){
           System.out.println("ID: "+(i+1) + "      ✳Nome: "
                   + EP1.get(i).getNome() + "       ✳Quantidade Estoque: "
                   + EP1.get(i).getQuantidadeEstoque());

       }

        System.out.println("Digite o ID do EPI: ");
        int indexEPI = entrada.nextInt();
        indexEPI--;

        if (indexEPI>=EP1.size() || indexEPI<0){
            System.out.println("ID EPI invalido.... ");
            System.out.println();
            return;
        }

        System.out.println("Digite a quantidade : ");
        int quant = entrada.nextInt();

        EPIs EpiSelecionado = EP1.get(indexEPI);

        if (EpiSelecionado.getQuantidadeEstoque()>=quant){
            EpiSelecionado.setQuantidadeEstoque(EpiSelecionado.getQuantidadeEstoque() - quant);
            Emprestimo novo = new Emprestimo(Funcionario.getFuncionarios().get(IndexFun),EPIs.getListarEPIs().get(indexEPI),quant, new Date());
            emprestimos.add(novo);

            System.out.println();
            System.out.println("====== Emprestimom realizado com sucesso ====");
            for (int i=0 ; i< emprestimos.size(); i++){
                Emprestimo dados = Emprestimo.emprestimos.get(i);
                System.out.println("Nome do Fun: "+ dados.getFun1().getNome());
                System.out.println("Nome do EPI: "+dados.getEPI().getNome());
                System.out.println("Quantidade : "+dados.getEPI().getQuantidade());
                System.out.println("Quant. estoque: "+EpiSelecionado.getQuantidadeEstoque());
                System.out.println("Data       : "+dados.date);
                System.out.println();
                break;
            }
        }else {
            System.out.println("Quantidadde Selecionado Insuficiente..");
            System.out.println("Quantidade Estoque : " + EpiSelecionado.getQuantidadeEstoque());
            System.out.println();
        }
    }

    public static void listarEmprestimos(){
        ArrayList<Funcionario> fun1 = Funcionario.getFuncionarios();
        ArrayList<EPIs> EP1 = EPIs.getListarEPIs();

        System.out.println("====== Lista De Emprestimos =====");
        for (int i=0; i< emprestimos.size(); i++){
            Emprestimo e = Emprestimo.emprestimos.get(i);
            System.out.println("ID: " +(i+1) + "      ✳Funcionario: " + e.fun1.getNome()
                    +"      ✳EPI: " + e.getEPI().getNome()
                    +"      ✳Quantida: " + e.getQuantidade()
                    +"      ✳Data: " + e.date);
            System.out.println();
        }
    }
}
