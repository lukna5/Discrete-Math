import java.util.Scanner;

public class SochetFromNumber {
    public static void gen(int[][] C, int n){
        for (int i = 0; i < n+1; i++) {
            C[i][0] = 1;
            C[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int factorial(int number){
        int result = 1;
        while (number > 0 ){
            result *= number;
            number--;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] C = new int[n+1][n+1];
        gen(C, n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

            }
        }

    }
}
