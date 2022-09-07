import java.io.*;
import java.util.Scanner;

public class Sochetaiivlastvui {
    public static int n;
    public static int k;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("choose.in"));
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\File.txt");
        //PrintStream writer = new PrintStream(System.out);
        n = input.nextInt();
        k = input.nextInt();
        input.close();
        String was = "";
        gen(was, writer, 1, 0);
        writer.close();
    }
    public static void gen(String was, FileWriter writer, int last, int size) throws IOException{
        if (size == k){
            //System.out.println(was);
            System.out.println(was);
            //writer.print("\n");
            writer.write(was);
            writer.write("\n");
            //writer.write(was+"\n");
        }
        else {
            if (was.length()!=0) {
                if (was.length()>=3) {
                    if (Character.isDigit(was.charAt(was.length() - 3))) {
                        last = 10 * Character.getNumericValue(was.charAt(was.length() - 3)) + Character.getNumericValue(was.charAt(was.length() - 2));
                    } else last = Character.getNumericValue(was.charAt(was.length() - 2));
                }
                else last = Character.getNumericValue(was.charAt(was.length() - 2));
                for (int i = 0; i < n + 1; i++) {
                    int newSize = size;
                    if (last < i) {
                        newSize++;
                        //System.out.println(was + i);
                        gen(was + i + " ", writer, last, newSize);
                    }
                }
            }
            else{
                size++;
                for (int i = 1; i < n + 1; i++) {
                    //System.out.println(was + i);
                    gen(was + i + " ", writer, i, size);
                }
            }
        }
    }
}

