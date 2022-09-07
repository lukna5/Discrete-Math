import java.util.*;

public class MrBarouseDecode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int n = line.length();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add("");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.set(j, line.charAt(j) + list.get(j));
            }
            Collections.sort(list);
        }
        System.out.println(list.get(0));
    }
}
