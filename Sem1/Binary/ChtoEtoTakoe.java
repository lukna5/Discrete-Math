import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChtoEtoTakoe {
    public static int n;
    public static int k;
    public static FileWriter writer;
    public static void main(String[] args)throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.in"));
        writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.out");
        k = input.nextInt();
        n = input.nextInt();
        boolean reversim = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(i);
            gen(builder, reversim, 1);
            builder.setLength(0);
            reversim = !reversim;
        }
        writer.close();

    }
    public static void gen(StringBuilder was, boolean Reversim, int size)throws IOException{
        boolean needReverse = Reversim;
        if (n%2==1) {
            if (size == k) {
                StringBuilder builder = new StringBuilder(was.toString());
                builder.reverse();
                writer.write(builder.toString()+"\n");
                //writer.write(was + "\n");
                //System.out.println(was +  " was");
                //for (int i = was.length() - 1; i >= 0; i--) {
                    //System.out.print(was.charAt(i));
                    //writer.write(was.charAt(i));
                //}
               // System.out.println();
                //System.out.println(was + " was");
               // writer.write("\n");
               // System.out.println();
               // return;
                //System.out.println(was + " will");
            } else if (!Reversim) {
                for (int i = 0; i < n; i++) {
                    //System.out.print(i);
                    was.append(i);
                    //System.out.println(Reversim);
                    //System.out.println(was + " was");
                    gen(was, needReverse, size + 1);
                    needReverse = !needReverse;
                    was.setLength(was.length() - 1);
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    was.append(i);
                    //System.out.print(i);
                    //System.out.println(Reversim);
                    //System.out.println(was + " was");
                    gen(was, needReverse, size + 1);
                    needReverse = !needReverse;
                    was.setLength(was.length() - 1);
                }
            }
        } else{
            if (size == k) {
                StringBuilder builder = new StringBuilder(was.toString());
                builder.reverse();
                writer.write(builder.toString() + "\n");
                //System.out.println();
                //System.out.println(was + " will");
            } else if (!Reversim) {
                for (int i = 0; i < n; i++) {
                    //System.out.print(i);
                    was.append(i);
                    //System.out.println(Reversim);
                    //System.out.println(was + " was");
                    gen(was, needReverse, size + 1);
                    needReverse = !needReverse;
                    was.setLength(was.length() - 1);
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    was.append(i);
                    //System.out.print(i);
                    //System.out.println(Reversim);
                    //System.out.println(was + " was");
                    needReverse = !needReverse;
                    gen(was, needReverse, size + 1);
                    was.setLength(was.length() - 1);
                }
            }
        }
    }
}
