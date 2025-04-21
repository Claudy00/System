public class ArrayInvertido {
    public static void main(String[] args) {
        // Array original
        int[] numeros = {1, 2, 3, 4, 5};

        // Inverter o array
        for (int i = 0; i < numeros.length / 2; i++) {
            int temp = numeros[i];
            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = temp;
        }

        // Imprimir o array invertido
        System.out.print("Array invertido: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}
