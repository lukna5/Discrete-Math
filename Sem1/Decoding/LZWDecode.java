import java.util.ArrayList;
import java.util.Scanner;

public class LZWDecode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int max = 26;
        int[] commands = new int[size];
        for (int i = 0; i < size; i++) {
            commands[i] = input.nextInt();
        }
        ArrayList<String> mas = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            mas.add(Character.toString(i));
        }
        for (int i = 0; i < size; i++) {
            System.out.print(mas.get(commands[i]));
            int index = i;
            if (i == size - 1){
                break;
            }
            StringBuilder builder = new StringBuilder(mas.get(commands[index]));
            //System.out.println(commands[index] + " " +  max);
            if (index < size - 1 && commands[index] < max && mas.contains(builder.toString())) {
                index++;
                if (commands[index] >= max) {
                    mas.add(mas.get((commands[index-1])) + mas.get((commands[index-1])).charAt(0));
                }
                else {
                    builder.append(Character.toString(mas.get(commands[index]).charAt(0)));
                    mas.add(builder.toString());
                }
            }
            //mas.add(builder.toString());
            max++;
            //i += mas.get(commands[i]).length()-1;
        }
    }
}