import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class perestavfromNumber {
    public static void main(String[] args)throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("num2perm.in"));
        FileWriter writer = new FileWriter("num2perm.out");
        int n = input.nextInt();
        int n1 = n;
        long number = input.nextLong();
        int[] mas = new int[n];
        boolean[] was = new boolean[n+1];
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            numbers.add(i);
        }
        int count = 0;
        String next;
        while (n>0){
            n--;
            mas[count] = (int) (number/factorial(n));
            count++;
            number %= factorial(n);
        }
        for (int i = 0; i < n1; i++) {
            //System.out.print(numbers.get(mas[i]) + " ");
            writer.write(Integer.toString(numbers.get(mas[i])) + " ");
            numbers.remove(numbers.lastIndexOf(numbers.get(mas[i])));
        }
        writer.close();
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
