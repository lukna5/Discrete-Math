import java.io.*;
import java.util.Scanner;

public class Microplus {
    public static int n;
    //public static PrintStream writer;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("partition.in"));
        //writer = new PrintStream(System.out);
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\File.txt");
        n = input.nextInt();
        input.close();
        gen("", 0, writer);
        writer.write(Integer.toString(n));
        System.out.print(n);
        writer.close();

    }
    public static void gen(String was, int lastnumber, FileWriter writer) throws IOException{
        int sum = 0;
        for (int i = 0; i < was.length()-1; i++) {
            if (Character.isDigit(was.charAt(i))) {
                if (Character.isDigit(was.charAt(i + 1))) {
                    sum += 10 * Character.getNumericValue(was.charAt(i)) + Character.getNumericValue(was.charAt(i + 1));
                    i++;
                }
                else sum += Character.getNumericValue(was.charAt(i));
            }
        }
        if (sum == n){
            was = was.substring(0, was.length()-1);
            System.out.print(was+"\n");
            writer.write(was);
            writer.write("\n");
        }
        else {
            for (int i = 1; i < n - sum + 1 ; i++) {
                if (was.length()>0){
                    if (((lastnumber <= i))) {
                        lastnumber = i;
                        gen(was + i + "+", lastnumber, writer);
                    }
                }
                else {
                    if (i<=n/2) {
                        gen(was + i + "+", i, writer);
                    }
                }
            }
        }
    }
}
