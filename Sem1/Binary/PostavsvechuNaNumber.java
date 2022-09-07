import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PostavsvechuNaNumber {
    public static void main(String[] args)throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("perm2num.in"));
        FileWriter writer = new FileWriter("perm2num.out");
        int n = input.nextInt();
        int n1 = n;
        input.nextLine();
        int[] col = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            col[i] = i;
        }
        String[] mas = input.nextLine().split(" ");
        int[] results = new int[n];
        for (int i = 0; i < n1; i++) {
            n--;
            for (int j = n1; j > Integer.parseInt(mas[i]); j--) {
                col[j]--;
            }
            results[i] = col[Integer.parseInt(mas[i])] - 1;
        }
        long sum = 0;
        for (int i = 0; i < n1; i++) {
            sum+=factorial(n1 - i - 1) * results[i];
        }
        writer.write(Long.toString(sum));
        writer.close();
        //System.out.println(sum);
    }
    public static long factorial(int number){
        long result = 1;
        while (number > 0 ){
            result *= number;
            number--;
        }
        return result;
    }
}
