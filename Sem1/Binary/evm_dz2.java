import java.util.Random;
import java.util.Scanner;

public class evm_dz2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Enter size");
        int n = in.nextInt();
        in.close();
        System.out.println("Comparison of speeds in ms");
        System.out.println("Slow : Fast");
        for (int k = 100; k<n; k+= 100){
            long[][] first = new long[k][k];
            long[][] second = new long[k][k];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    first[i][j] = rd.nextInt(3000);
                    second[i][j] = rd.nextInt(3000);
                }
            }
            long time = System.currentTimeMillis();
            //Slow algorithm
            long[][] mas1 = new long[k][k];
            for (int j = 0; j<k; j++){
                for (int i = 0; i<k; i++){
                    for (int l = 0; l<k; l++){
                        mas1[i][j]+=first[i][l]*second[l][j];
                    }
                }
            }
            long time1 = System.currentTimeMillis() - time;
            //Fast algorithm
            long[][] mas2 = new long[k][k];
            for (int i = 0; i<k; i++){
                for (int j = 0; j<k; j++){
                    for (int l = 0; l<k; l++){
                        mas2[i][j]+=first[i][l]*second[l][j];
                    }
                }
            }
            long time2 = System.currentTimeMillis() - time - time1;
            System.out.println(time1 + " : " + time2);
        }
    }
}
