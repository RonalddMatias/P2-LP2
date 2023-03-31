import java.util.Scanner;

public class DoisMaioresNumeros {
    /**
     * Laboratório de Programação 2 - Lab 1
     *
     * Ronaldd Feliph Matias Costa - 122110574
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int primeiroMaior = 0;
        int segundoMaior = 0;

        String[] entrada = sc.nextLine().split(" ");
        int[] arrayConvertido = new int[entrada.length];

        // Passando String para inteiros
        for (int i = 0; i < entrada.length; i++) {
            arrayConvertido[i] = Integer.parseInt(entrada[i]);
        }

        //Ordenando a lista
        for (int j = 0; j < arrayConvertido.length - 1; j++) {
            for (int q = j + 1; q < arrayConvertido.length; q++) {
                if (arrayConvertido[j] > arrayConvertido[q]) {
                    int value = arrayConvertido[j];
                    arrayConvertido[j] = arrayConvertido[q];
                    arrayConvertido[q] = value;
                }
            }
        }

        // System.out.println(segundoMaior);
        primeiroMaior = arrayConvertido[arrayConvertido.length - 1];
        segundoMaior = arrayConvertido[arrayConvertido.length - 2];

        System.out.println(primeiroMaior + segundoMaior);

        sc.close();

    }
}
