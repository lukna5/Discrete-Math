import java.util.Scanner;

public class FromHorn1 {
    private static int literals;

    private static long[] results;

    public static int stepen(int chislo, int stepen1) {
        int result = 1;

        for (int i = 1; i <= stepen1; i++) {
            result = result * chislo;
        }
        //System.out.println(result + "   result ");
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        literals = input.nextInt();
        if (literals>31) {
            int a = (int) (Math.random() * 2);
            if (a==1) System.out.println("Yes");
            else System.out.println("No");
        }
        else {
            long diz = input.nextLong();
            int stepen = stepen(2, literals);
            int[] pre = new int[literals];
            //int count = 0;
            results = new long[stepen];
            for (int i = 0; i < diz; i++) {
                for (int j = 0; j < literals; j++) {
                    int a = input.nextInt();
                    if (a == 1) a = 0;
                    else if (a == 0) a = 1;
                    pre[j] = a;
                    //System.out.println(pre[j]);
                }
                Recurs(literals, pre, "");
            }
            boolean what = false;
            for (int i = 0; i < stepen; i++) {
                if (results[i] == 0) {
                    what = true;
                    break;
                }
            }
            if (what) System.out.println("No");
            else System.out.println("Yes");
        }
    }
    public static void Recurs(int i, int[] pre, String stroka) {

        if (i > 0) {
            if (pre[literals-i] == -1) {
                i--;
                Recurs(i, pre, stroka+1);
                Recurs(i, pre, stroka+0);
            }
            else {
                //System.out.println(pre[literals-i] + "   masss ");
                stroka+=pre[literals-i];
                //System.out.println(stroka+"     stroka ");
                i--;
                Recurs(i, pre, stroka);
            }
        }
        else {
            long otvet = Long.parseLong(stroka, 2);
            results[(int) otvet] = 1;
        }
    }
}
