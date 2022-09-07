import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Somanychairs {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.in"));
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.out");
        //PrintStream writer = new PrintStream(System.out);
        int n = input.nextInt();
        input.close();
        String was = "";
        gen(n, was, writer);
        writer.close();
    }

    public static void gen(int n, String was, FileWriter writer) throws IOException {
        boolean[] masbool = new boolean[n + 1];
        boolean info = true;
        for (int i = 1; i < n; i++) {
            masbool[i] = false;
        }
        if (was.length() == n) {
            for (int i = 0; i < n; i++) {
                masbool[Character.getNumericValue(was.charAt(i))] = true;
            }
            for (int i = 1; i < n + 1; i++) {
                if (!masbool[i]) {
                    info = false;
                    break;
                }
            }
            if (info) {
                for (int i = 0; i < n; i++) {
                    writer.write(was.charAt(i) + " ");
                }
                writer.write("\n");
            }
        } else {
            for (int i = 1; i < n+1; i++) {
                gen(n, was + i, writer);
            }
        }
    }
    public static int factorial(int number){
        int result = 1;
        for (int i = 1; i < number+1; i++) {
            result*= i;
        }
        return result;
    }
}
