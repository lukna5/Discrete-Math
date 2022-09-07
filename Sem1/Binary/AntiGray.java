import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class AntiGray {
    public static void sdvigvlevo (String was){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < was.length(); i++) {
             if (was.charAt(i) == '0') builder.append("2");
             else if (was.charAt(i) == '1') builder.append("0");
             else builder.append("1");
        }
    }
    public static String sdvigvpravo (String was){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < was.length(); i++) {
            if (was.charAt(i) == '0') builder.append("1");
            else if (was.charAt(i) == '1') builder.append("2");
            else builder.append("0");
        }
        return builder.toString();
    }

    public static void gen(int n, String was, FileWriter writer) throws IOException{
        if (was.length() == n){
            was = "0" + was;
            writer.write(was + "\n");
            was = sdvigvpravo(was);
            writer.write(was + "\n");
            writer.write(sdvigvpravo(was) + "\n");
        }
        else {
            gen(n, was +"0", writer);
            gen(n, was + "1", writer);
            gen(n, was + "2", writer);
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("antigray.in"));
        FileWriter writer = new FileWriter("antigray.out");
        //PrintStream writer = new PrintStream(System.out);
        int n = input.nextInt();
        gen(n-1, "" , writer);
        writer.close();
        /*
        int n = input.nextInt();
        int size = (int) Math.pow(3, n);
        input.close();
        //String was = "";
        //gen(n, was);
        String[] mas = new String[(int) Math.pow(3, n)];
        String[] mas1 = new String[(int) Math.pow(3, n + 1)];
        mas[0] = "0";
        mas[1] = "1";
        mas[2] = "2";
        for (int i = 2; i < n + 1; i++) {
            System.arraycopy(mas, 0,  mas1, 0, size);
            int count1 = 0;
            int count2 = (int) Math.pow(3, i - 1);
            int count3 = (int) Math.pow(3, i - 1) * 2;
            for (int j = (int) Math.pow(3, i - 1); j > 0; j --) {
                mas[count1] = "0" + mas1[(int) Math.pow(3, i - 1) - j];
                mas[count2] = "1" + mas1[j - 1];
                mas[count3] = "2" +
                count1++;
                count2++;
            }
        }
        for (int i = 0; i < size; i++) {
            writer.print(mas[i] + "\n");
        }
        for (int i = 0; i < (int) Math.pow(2, n - 1); i++) {
            writer.print(mas[i] + "\n");
            for (int j = 0; j < n; j++) {
                if (mas[i].charAt(j) == '1')
                writer.print(0);
                else {
                    writer.print(1);
                }
            }
            writer.print("\n");
        }
        writer.close();

         */
    }
}
