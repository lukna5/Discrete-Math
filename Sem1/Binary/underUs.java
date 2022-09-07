import java.io.*;
import java.util.Scanner;

public class underUs {
    public static int n;
    public static BufferedWriter writer;
    //public static PrintStream writer;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("subsets.in"));
        //writer = new PrintStream(System.out);
        //writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("subsets.out")));
        n = input.nextInt();
        input.close();
        //writer.write("\n");
        System.out.print("\n");
        gen("", 0, false);
        writer.close();
    }
    public static void gen(String was, int size, boolean have) throws IOException {
        if(size<=n) {
            if(was.length()!=0) {
                int number;
                if (Character.getNumericValue(was.charAt(was.length() - 1)) == 0) number = 10;
                else number = Character.getNumericValue(was.charAt(was.length() - 1));
                for (int i = number+1; i < n + 1; i++) {
                    int newSize = size;
                    if (i == 10) have = true;
                    if (have){
                        for (int j = 0; j < newSize; j++) {
                            if (j+1!=was.length()&&Character.getNumericValue(was.charAt(j + 1)) == 0) {
                                j++;
                                //writer.write(10 + " ");
                                System.out.print(10 + " ");
                            } else {
                                //writer.write(was.charAt(j) + " ");
                                System.out.print(was.charAt(j) + " ");
                            }
                        }
                    }
                    else {
                        for (int j = 0; j < newSize; j++) {
                            System.out.print(was.charAt(j) + " ");
                            //writer.write(was.charAt(j) + " ");
                        }
                    }
                    System.out.print(i + "\n");
                    //writer.write(i + "\n");
                    newSize++;
                    gen(was + i, newSize, have);
                }
            }
            else {
                for (int i = 1; i < n + 1; i++) {
                    if(i==10) have = true;
                    //writer.write(was + i + "\n");
                    System.out.print(was + i + "\n");
                    gen(was + i, size+1, have);
                }
            }
        }
    }
}
