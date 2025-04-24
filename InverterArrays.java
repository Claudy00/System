import java.util.Scanner;

public class InverterArrays {
    //Inverter array
    //Dado um array, crie um novo array com os valores invertidos.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[5];

        System.out.println("Digite 5 numeros : ");
        for (int i =0 ; i< num.length; i++){
            num[i] = input.nextInt();
            System.out.println((i+1));
        }

        System.out.println("Voce digitou : ");
        for(int numeros : num){
            System.out.println(numeros);
        }
    }
}
