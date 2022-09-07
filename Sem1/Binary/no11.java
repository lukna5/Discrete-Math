import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class no11 {
    public static String[] mas;
    public static int count;
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("vectors.in"));
        //PrintStream writer = new PrintStream(System.out);
        FileWriter writer = new FileWriter("vectors.out");
        int n = input.nextInt();
        count = 0;
        int size = (int) Math.pow(2,n);
        mas = new String[size];
        gen(n, "");
        //writer.println(mas[0]);
        writer.write(count+"\n");
        for (int i = 0; i < count; i++) {
            writer.write(mas[i]+"\n");
        }
        writer.close();
    }
    public static void gen(int n, String was) throws IOException {
        boolean inf = true;
        if (was.length() == n){
            for (int i = 1; i < was.length(); i++){
                /*writer.println(Character.toString(was.charAt(i)));
                writer.println("char = " + was.charAt(i-1));
                writer.println(was.charAt(i)==1);
                 */
                if ((was.charAt(i)==was.charAt(i-1))&&(Character.toString(was.charAt(i)).equals("1"))){
                    inf = false;
                }
            }
            if (inf) {
                mas[count] = was;
                count++;
            }
        }
        else {
            gen(n, was +"0");
            gen(n, was + "1");
        }
    }
}
