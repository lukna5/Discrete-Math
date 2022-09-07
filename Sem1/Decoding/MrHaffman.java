import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MrHaffman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long result = 0;
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextLong());
        }
        while (list.size() > 1){
            /*for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
             */
            Collections.sort(list);
            long min1 = list.get(0);
            long min2 = list.get(1);
            //System.out.println(min1 + " " + min2);
            //System.out.println(ind1 + " " + ind2);
            //System.out.println(list.get(ind1) + " " + list.get(ind2));
            //System.out.println(list.toString());
            list.remove(1);
            list.remove(0);
            long added = min1 + min2;
            list.add(added);
            result+=added;
        }
        System.out.println(result);
    }
}
