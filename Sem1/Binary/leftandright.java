import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class leftandright {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("brackets.in"));
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\File.txt");
        int n = input.nextInt();
        gen(n, "", writer);
        writer.close();
    }
    public static void gen(int n, String was, FileWriter writer) throws IOException{
        int count = 0;
        boolean inf = true;
        if (was.length() == 2*n){
            for (int i = 0; i < 2*n; i++) {
                if (was.charAt(i) == '(') count++;
                else count --;
                if (count < 0) {
                    inf = false;
                }
            }
            if(inf && count == 0) {
                writer.write(was + "\n");
            }
        }
        else {
            gen(n, was +"(", writer);
            gen(n, was + ")", writer);
        }
    }
}
