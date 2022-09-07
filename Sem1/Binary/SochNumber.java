import java.util.Scanner;

public class SochNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int ost;
        int next;
        for (int i = 0; i < n; i++) {
            next = k / (factorial(n - i));
            k = k % (n-i);
        }
    }
    public static int factorial(int number){
        int result = 1;
        while (number!=0){
            result *= number;
            number--;
        }
        return result;
    }
}
