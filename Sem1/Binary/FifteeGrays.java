import java.io.*;
import java.util.Scanner;

public class FifteeGrays {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.in"));
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.out");
        //PrintStream writer = new PrintStream(System.out);
        int n = input.nextInt();
        int size = (int) Math.pow(2, n);
        input.close();
        //String was = "";
        //gen(n, was);
        String[] mas = new String[(int) Math.pow(2, n)];
        String[] mas1 = new String[(int) Math.pow(2, n + 1)];
        mas[0] = "0";
        mas[1] = "1";
        for (int i = 2; i < n + 1; i++) {
            System.arraycopy(mas, 0,  mas1, 0, size);
            int count1 = 0;
            int count2 = (int) Math.pow(2, i - 1);
            for (int j = (int) Math.pow(2, i - 1); j > 0; j --) {
                mas[count1] = "0" + mas1[(int) Math.pow(2, i - 1) - j];
                mas[count2] = "1" + mas1[j - 1];
                count1++;
                count2++;
            }
        }
        for (int i = 0; i < size; i++) {
            writer.write(mas[i] + "\n");
        }
        writer.close();
    }
    public static void gen(int n, String was) throws IOException{
        if (was.length() == n){
            System.out.println(was);
        }
        else {
            gen(n, was +"0");
            gen(n, was + "1");
        }
    }
}