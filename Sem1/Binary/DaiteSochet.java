import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DaiteSochet {
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
        //for (int i = 0; i < n + 1; i++) {
            //for (int j = 0; j < i; j++) {
                //System.out.print(C[i][j]+" ");
            //}
            //System.out.println();
        //}
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("nextmultiperm.in"));
        //FileWriter writer = new FileWriter("nextmultiperm.out");
        int n = input.nextInt();
        int k = input.nextInt();
        int number = input.nextInt();
        int[][] C = new int[n + 2][n + 2];
        StringBuilder sochet = new StringBuilder();
        int forAdd = 0;
        gen(C, n + 1);
        /*for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
         */
        //System.out.println(C[n+1][k]);
        for (int i = k; i > 0 ; i--) {
            forAdd++;
            while (number >= C[n][k - 1]){
                //System.out.println(sochet);
                n--;
                number -= C[n + 1][k];
                forAdd++;
            }
            sochet.append(forAdd + " ");
            n--;
        }
        System.out.println(sochet);
    }
}
