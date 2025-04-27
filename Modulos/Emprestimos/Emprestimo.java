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
            }
        }while (opcoe!=0);
    }

    public static void cadastrarEmprestimos(){
        Scanner entrada = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = Funcionario.getFuncionarios();
        ArrayList<EPIs> EPI = EPIs.getListarEPIs();

        if (funcionarios.isEmpty()){
            System.out.println("Nenhum Funcionarios cadastrados....");
            System.out.println();
            return;
        }

        if (EPI.isEmpty()){
            System.out.println("Nenhum EPIs cadastrado....");
            System.out.println();
            return;
        }

        System.out.println("Escolha o ID EPI desejado: ");
        int indexEpi = entrada.nextInt();
        entrada.nextLine();
        indexEpi--;

        if (indexEpi >= EPI.size()){
                System.out.println("ID Invalido");
                return;
        }

        System.out.println("Escolha o ID do Funcionario: ");
        int indexFun = entrada.nextInt();
        entrada.nextLine();
        indexFun--;

        if (indexFun>=funcionarios.size()){
            System.out.println("ID funcionario Invalido");
            return;
        }

        System.out.println("Digite a quantidade: ");
        int quant = entrada.nextInt();
        Date data = new Date();

        EPIs IndexEPISelecionado = EPI.get(indexEpi);

        if (quant<= IndexEPISelecionado.getQuantidade()){
            IndexEPISelecionado.setQuantidadeEstoque(IndexEPISelecionado.getQuantidadeEstoque() - quant);
            Emprestimo novo = new Emprestimo(funcionarios.get(indexFun),EPI.get(indexEpi),quant,data);
            emprestimos.add(novo);
            System.out.println("Quantidade Estoque : "+IndexEPISelecionado.getQuantidadeEstoque());
        }else{
            System.out.println("Quantidade Insuficiente no estoque...");
        }

    }
}
