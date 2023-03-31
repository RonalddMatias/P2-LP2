import java.util.Scanner;

public class Expressoes {
    /**
     * Laboratório de Programação 2 - Lab 1
     *
     * Ronaldd Feliph Matias Costa - 122110574
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num = sc.nextInt();

        double dobro = num * 2;
        double triplo = num * 3;
        sc.close();

        System.out.print("dobro: " + dobro);
        System.out.print(", triplo: " + triplo);

    }

}
