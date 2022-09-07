

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class evm_dz2_1 {

    public static void main(String[] args) {
        for (int i = 1; i<3000; i*= 2){
            test(i);
        }
    }

    //кэш-НЕэффективный алгоритм
    public static long[][] noEff(long[][] a, long[][] b, int n) {
        long[][] c = new long[n][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                for (int k = 0; k<n; k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    //кэш-эффективный алгоритм
    public static long[][] eff(long[][] a, long[][] b, int n) {
        long[][] c = new long[n][n];
        for (int j = 0; j<n; j++){
            for (int i = 0; i<n; i++){
                for (int k = 0; k<n; k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    public static void test(int n){
        Random rd = new Random();
        long[][] a = new long[n][n];
        long[][] b = new long[n][n];
        for (int i = 0; i < n; i++) {//заполнение рандомными значениями
            for (int j = 0; j < n; j++) {
                a[i][j] = rd.nextInt(1000000);
                b[i][j] = rd.nextInt(1000000);
            }
        }
        long startTime1 = System.currentTimeMillis();
        eff(a, b, n);
        long spentTime1 = System.currentTimeMillis() - startTime1;

        long startTime2 = System.currentTimeMillis();
        noEff(a, b, n);
        long spentTime2 = System.currentTimeMillis() - startTime2;
        System.out.println(spentTime1 + " : " + spentTime2);
    }
}
