import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MrBarouseCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ArrayList<String> mas = new ArrayList<>();
        int n = line.length();
        for (int i = 0; i < line.length(); i++) {
            mas.add(line);
            line = sdvig(line);
        }
        Collections.sort(mas);
        for (int i = 0; i < n; i++) {
            System.out.print(mas.get(i).charAt(n-1));
        }
    }
    public static String sdvig(String line){
        char first = line.charAt(0);
        StringBuilder builder = new StringBuilder(line);
        for (int i = 0; i < line.length()-1; i++) {
            builder.setCharAt(i, builder.charAt(i + 1));
        }
        builder.setCharAt(builder.length()-1, first);
    return builder.toString();
    }
}
