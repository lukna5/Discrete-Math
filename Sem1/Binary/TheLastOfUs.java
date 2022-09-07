import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TheLastOfUs {
    public static int n;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("nextpartition.in"));
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\File.txt");
        String line = input.nextLine();
        String number = "";
        int nchar = 0;
        while(line.charAt(nchar) != '='){
            number+=line.charAt(nchar);
            nchar++;
        }
        line = line.substring(nchar+1);
        n = Integer.parseInt(number);
        int[] mas = new int[n];
        int size = 0;
        StringBuilder builder = new StringBuilder();
        int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    builder.append(line.charAt(i));
                } else {
                    mas[count] = Integer.parseInt(builder.toString());
                    count++;
                    builder.setLength(0);
                    size++;
                }
            }
            mas[count] = Integer.parseInt(builder.toString());
            size++;
        if (size!=1) {
            if ((mas[size - 1] - 1)/(mas[size - 2] + 1) >= 1 && (mas[size - 1] - 1)/(mas[size - 2] + 1) < 2) {
                mas[size - 1]--;
                mas[size - 2]++;
                writer.write(Integer.toString(n) + "=");
                //System.out.print(n + "=");
                for (int i = 0; i < size; i++) {
                    writer.write(Integer.toString(mas[i]));
                    //System.out.print(mas[i]);
                    if (i != size - 1) writer.write("+");
                }
            } else if ((mas[size - 1] - 1)/(mas[size - 2] + 1) < 1) {
                mas[size - 2] += mas[size - 1];
                size--;
                writer.write(Integer.toString(n) + "=");
                //System.out.print(n + "=");
                for (int i = 0; i < size; i++) {
                    writer.write(Integer.toString(mas[i]));
                    //System.out.print(mas[i]);
                    if (i!=size-1) writer.write("+");
                }
            } else {
                mas[size - 1]--;
                mas[size - 2]++;
                gen(mas, size, writer);
            }
        } else{
            writer.write("No solution");
            //System.out.print("No solution");
        }
        writer.close();
    }
    public static void gen(int[] mas, int size, FileWriter writer) throws IOException{
        while (mas[size - 1] >= 2 * mas[size - 2]){
            size++;
            mas[size - 1] = mas[size - 2] - mas[size - 3];
            mas[size - 2] = mas[size - 3];
        }
        writer.write(Integer.toString(n) + "=");
        //System.out.print(n + "=");
        for (int i = 0; i < size; i++) {
            writer.write(Integer.toString(mas[i]));
            //System.out.print(mas[i]);
            if (i!=size-1) writer.write("+");
        }
    }
}
