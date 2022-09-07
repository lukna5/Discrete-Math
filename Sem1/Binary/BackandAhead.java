import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BackandAhead {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("nextvector.in"));
        FileWriter writer = new FileWriter("nextvector.out");
        String number = input.next();
        StringBuilder builder = new StringBuilder();
        boolean have0 = false;
        boolean have1 = false;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0'){
                have0 = true;
                break;
            }
        }
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '1'){
                have1 = true;
                break;
            }
        }
        if (!have0){
            for (int i = 0; i < number.length() - 1; i++) {
                //System.out.print("1");
                writer.write("1");
            }
            //System.out.println("0");
            writer.write("0"+"\n");
            //System.out.print("-");
            writer.write("-");
        }
        else if (!have1){
            //System.out.println("-");
            writer.write("-" + "\n");
            for (int i = 0; i < number.length() - 1; i++) {
                //System.out.print("0");
                writer.write("0");
            }
            writer.write("1");
            //System.out.println(1);
        }
        else {
            for (int i = number.length() - 1; i >= 0; i--) {
                if (number.charAt(i) == '1') {
                    builder.append(0);
                    for (int j = i - 1; j >= 0; j--) {
                        builder.append(number.charAt(j));
                    }
                    break;
                } else {
                    builder.append(1);
                }
            }
            builder.reverse();
            writer.write(builder.toString()+"\n");
            //System.out.print(builder.reverse() + "\n");
            builder.setLength(0);
            boolean inf = true;
            for (int i = number.length() - 1; i >= 0; i--) {
                if (number.charAt(i) == '0') {
                    inf = false;
                    builder.append(1);
                    for (int j = i - 1; j >= 0; j--) {
                        builder.append(number.charAt(j));
                    }
                    break;
                } else {
                    builder.append(0);
                }
            }
            if (inf) builder.append(1);
            writer.write(builder.reverse().toString()+"\n");
            //System.out.print(builder.reverse() + "\n");
        }
        writer.close();
    }
}
