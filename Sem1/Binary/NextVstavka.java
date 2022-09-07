import java.util.Scanner;

public class NextVstavka {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int size = factorial(n);
        String[] mas = input.nextLine().split(" ");
        int number = -1;
        for (int i = 0; i < n; i++) {
            System.out.println(Integer.parseInt(mas[i])%(n + 1) - 1 + " next");
            System.out.println(factorial(n-i) + " factorial");
            number += (factorial(n - i))*(Integer.parseInt(mas[i])%(n + 1) - 1);;
            System.out.println(number + " number");
        }
        System.out.println(number);
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
