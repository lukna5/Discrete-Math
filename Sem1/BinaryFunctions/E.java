import java.util.*;

public class E {

    public static void main (String[] args)

    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow *= 2;
        }
        int[] mas = new int[pow];
        String[] pos = new String[pow];
        int[] mas1 = new int[pow];
        for (int j = 0; j < pow; j++) {
            pos[j] = in.next();
            mas[j] = in.nextInt();
        }
//int[] pol = new int[pow];
        int tempow = pow;
        for (int k = 0; k < pow; k++) {
            tempow -= 1;
            int[] pol = new int[tempow];
            mas1[k]= mas[0];
            for (int t = 0; t < tempow ; t++) {
                //System.out.println(mas.length);
                if (mas[t] != mas[t + 1]) {
                    pol[t] = 1;
                } else {
                    pol[t] = 0;
                }
                //System.out.println(pol[t] + "   pog ");
            }
                mas = pol;


        }
        for (int l = 0; l < pow; l++) {
            System.out.print(pos[l] + " " + mas1[l]);
            System.out.println();
        }
    }
}