package Menu;

import java.util.Scanner;
import Modulos.EPIs.EPIs;
import Modulos.Emprestimos.Emprestimo;
import Modulos.Funcionarios.Funcionario;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcoe;
        do {
            System.out.println("====== Sistema de Gerenciamento ======");
            System.out.println("1.Modulo EPIs");
            System.out.println("2.Modulo Funcionarios");
            System.out.println("3.Modulo Emprestimo");
            System.out.println("0.Sair");
            System.out.println("Escolha: ");
            opcoe = entrada.nextInt();
            entrada.nextLine();

            switch (opcoe) {
                case 1:
                    EPIs.MenuEPIs();
                    System.out.println();
                    break;
                case 2:
                    Funcionario.ModuloFuncionario();
                    System.out.println();
                    break;
                case 3:
                    Emprestimo.ModuloEmprestimo();
                    System.out.println();
                    break;
            }
        } while (opcoe != 0);
    }
}