import java.util.LinkedList;
import java.util.Scanner;

public class MTFPog {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int n = line.length();
        LinkedList<String> mas = new LinkedList<>();
        for (int i = 97; i < 123; i++) {
            mas.add(Character.toString(i));
        }
        for (int i = 0; i < n; i++) {
            String letter = Character.toString(line.charAt(i));
            int code = takeCode(mas, letter);
            System.out.print(code + 1 + " ");
            mas.remove(code);
            mas.addFirst(letter);

        }
    }
    public static int takeCode(LinkedList<String> mas, String symb){
        for (int i = 0; i < mas.size(); i++) {
            if (mas.get(i).equals(symb)) {
                return i;
            }
        }
        return mas.size()+1;
    }
}
