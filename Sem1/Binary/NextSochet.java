import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NextSochet {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        //FileWriter writer = new FileWriter("nextchoose.out");
        int n = input.nextInt();
        int k = input.nextInt();
        int[] mas = new int[k];
        for (int i = 0; i < k; i++) {
            mas[i] = input.nextInt();
        }
        if (mas[mas.length - 1] < n){
            mas[mas.length - 1]++;
            for (int i = 0; i < mas.length; i++) {
                //writer.write(mas[i] + " ");
                System.out.print(mas[i] + " ");
            }

        } else{
            boolean inf = false;
            for (int i = mas.length - 1; i > 0 ; i--) {
                if (mas[i] > mas[i - 1] + 1){
                    mas[i - 1]++;
                    int count = mas[i - 1] + 1;
                    inf = true;
                    for (int j = i; j < mas.length; j++) {
                        mas[j] = count;
                        count++;
                    }
                    break;
                }
            }
            if (inf){
                for (int j = 0; j < k; j++) {
                    System.out.print(mas[j] + " ");
                    //writer.write(mas[j] + " ");
                }
            } else {
                //writer.write("-1");
                System.out.println(-1);
                //System.out.println(-1);
            }
        }
        //writer.close();
    }
}

