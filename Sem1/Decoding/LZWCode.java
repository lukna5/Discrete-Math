import java.util.ArrayList;
import java.util.Scanner;

public class LZWCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        ArrayList<String> mas = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            mas.add(Character.toString(i));
        }
        //System.out.println(mas.toString());
        StringBuilder builder = new StringBuilder();
        boolean inf = false;
        for (int i = 0; i < line.length(); i++) {
            builder.append(line.charAt(i));
            if (mas.contains(builder.toString())) {
                while (mas.contains(builder.toString())) {
                    //System.out.println(i);
                    if (i >= line.length()-1){
                        i++;
                        inf = true;
                        break;
                    }
                    i++;
                    builder.append(line.charAt(i));
                }
                i--;
                mas.add(builder.toString());
                if (!inf){
                    builder.setLength(builder.length()-1);
                }
            }

            //System.out.println(builder.toString());
            //System.out.println(mas.toString());
            //System.out.println(builder.toString());
            System.out.print(takeCode(mas, builder.toString()) + " ");
            builder.setLength(0);
        }
        //System.out.println(mas.toString());
    }
    public static int takeCode(ArrayList<String> mas, String symb){
        for (int i = 0; i < mas.size(); i++) {
            if (mas.get(i).equals(symb)) {
                return i;
            }
        }
        return mas.size()+1;
    }
}
