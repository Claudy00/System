package Modulos.Funcionarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Funcionario {
   static ArrayList<Funcionario>funcionarios = new ArrayList<>();
    String nome ;
    String setor ;
    String funcao ;
    Date data;

    public Funcionario (String nome,String setor,String funcao,Date data){
        this.nome = nome;
        this.setor = setor;
        this.funcao = funcao;
        this.data = new Date();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        Funcionario.funcionarios = funcionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public static void ModuloFuncionario(){
        Scanner entrada = new Scanner(System.in);
        int opcoe;
        do {
            System.out.println("======= Modulo Funcionarios ========");
            System.out.println("1.Cadastrar Funcionario");
            System.out.println("2.Listar Funcionario");
            System.out.println("3.Atualizar Funcionario");
            System.out.println("4.Remover Funcionario");
            System.out.println("0.Voltar...");
            System.out.println("Escolha: ");
            opcoe = entrada.nextInt();
            entrada.nextLine();

            switch (opcoe){
                case 1: cadastrarFuncionario();
                    System.out.println();
                    break;
            }
        } while (opcoe!=0);
    }

    public static void cadastrarFuncionario(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("Digite seu Setor: ");
        String setor = entrada.nextLine();
        System.out.println("Digite a sua Funcão: ");
        String funcao = entrada.nextLine();

        Funcionario fun = new Funcionario(nome,setor,funcao,new Date());
        funcionarios.add(fun);

        System.out.println("======== Funcionario cadastrado com sucesso =======");
        System.out.println("Nome   : " + nome);
        System.out.println("Setor  : " + setor);
        System.out.println("Funcao : " + funcao);
        System.out.println("Data   : " + new Date());
        System.out.println();
    }
}
