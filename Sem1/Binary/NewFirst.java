import java.io.*;
import java.util.Scanner;

public class NewFirst {
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
    public static void gen(int n, String was, FileWriter writer) throws IOException{
        if (was.length() == n){
            writer.write(was+"\n");
        }//
        else {
            gen(n, was +"0", writer);
            gen(n, was + "1", writer);
        }
    }
}
