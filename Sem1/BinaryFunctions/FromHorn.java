import java.util.Scanner;
public class FromHorn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int literals = input.nextInt();
        int diz = input.nextInt();
        int[][] mas = new int[diz][literals];
        int count = 0;
        for (int i = 0; i < diz; i++) {
            for (int j = 0; j < literals; j++) {
                mas[i][j] = input.nextInt();
                if (mas[i][j] == -1) count++;
            }
        }
        if (count == diz * literals) {
            System.out.println("Yes");
        } else {
            boolean what = true;
            for (int i = 0; i < diz; i++) {
                what = false;
                int shet = 0;
                for (int j = 0; j < literals; j++) {
                    if (mas[i][j] == 0) {
                        what = true;
                        break;
                    }
                    if (mas[i][j] == -1) {
                        shet++;
                    }
                }
                if (shet == literals) what = true;

                if (!what) {
                    System.out.println("Yes");
                    break;
                }
            }
            if (what) {
                System.out.println("No");
            }
        }
    }
}

