import java.io.IOException;
import java.util.Scanner;

public class Classes {
    private static int[] mas;
    private static boolean bool = true;

    public static int stepen(int chislo, int stepen1) {
        int result = 1;
        for (int i = 1; i <= stepen1; i++) {
            result = result * chislo;
        }
        //System.out.println(result + "   result ");
        return result;
    }

    public static void main(String[] args) throws IOException {
        int[] result = new int[5];
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        char n1 = line.charAt(0);
        int n = n1 - '0';
        //System.out.println(n);
        int size = 32;
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            char s1 = line.charAt(0);
            int s = s1 - '0';
            //System.out.println(s);
            size = stepen(2, s);
            // System.out.println(size);
            mas = new int[size];
            for (int j = 2; j < size + 2; j++) {
                char b = line.charAt(j);
                mas[j - 2] = b - '0';

                //System.out.println(mas[j-2]);
            }
            if (mas[0] == 1) result[0] = 1;
            if (mas[size - 1] == 0) result[1] = 1;


            boolean what = true;
            for (int j = 0; j < size / 2; j++) {
                //System.out.println(mas[j] + "   " + mas[size-j-1]);
                if (mas[j] == mas[size - j - 1]) {
                    //System.out.println("Yeaaaaaa");
                    what = false;
                    break;
                }
            }
            if (!what) result[2] = 1;
//System.out.println(size+ " sizeeee ");
            int[] mas1 = new int[size];
            for (int k = 0; k<size;k++)  mas1[k]=mas[k];
            //for (int j = 0; i<size;i++) System.out.println(mas1[i]);
            //for (int j = 0; i<size;i++) System.out.println(mas[i]);
            boolean what1=false;
            if (s>1) {
                 what1 = ForHorn.check(s, mas1);
            }
            else what1 = true;
            //for (int j = 0; i<size;i++) System.out.println(mas[i]);
            if (!what1) result[4] = 1;
            //for (int j = 0; i<size;i++) System.out.println(mas[i]);
            if (!thisshi(0, size)) result[3] = 1;
            //System.out.println(result[4]);
            //for (int k=0;k<5; k++) System.out.println(result[k]);
        }
        int count=0;
        for (int i = 0;i<5;i++){
            if (result[i]==1)  count++;
        }
        if (count==5) System.out.println("Yes");
        else System.out.println("No");
    }


    public static boolean thisshi(int firsti, int secondi) {
        boolean stop = false;
        if ((secondi == 1) || (bool == false) || (secondi-1 == firsti)) {
            //if(firsti== secondi-1) System.out.println("smorc");
            return bool;

        } else {
            for (int i = firsti; i < secondi / 2; i++) {
                //System.out.println(mas[i]+ "    "+mas[i+(firsti+secondi)/2]);
                if (mas[i] > mas[i + (firsti+secondi) / 2]) {
                    bool = false;
                    stop = true;
                    //System.out.println("bool = "+bool+ " stop = "+stop);
                    break;
                }
            }
            if (!stop) {
                bool = thisshi(firsti, (firsti + secondi) / 2);
                bool = thisshi((firsti + secondi) / 2, secondi);
            }
            //System.out.println(" lasttttt " +bool);
            return bool;
        }
    }
}
class ForHorn {
    public static boolean check(int n1, int[] mas1) {
        int n = n1;
        int kol = Classes.stepen(2, n);
        int[] result = new int[kol];
        int[] mas2 = mas1;
        //System.out.println(kol+ "    kollll ");
            //System.out.println(mas[i]);
        for (int j = kol; j > 0; j--) {
            //System.out.println(j+"    j ");
            //System.out.println(n-(j/2) + "   ost ");

            result[kol-j]=mas2[0];

            for (int i = 0; i < j - 1; i++) {
                //System.out.println(i);
                mas2[i] = (mas2[i] + mas2[i + 1]) % 2;
                //System.out.print(mas[i]);
            }
            //System.out.println("    " +j + " jjjjjjj ");
            //System.out.println(Integer.toBinaryString(7));
        }
        //for (int i=0; i<kol;i++) System.out.print(" "+ result[i]+"  res   ");
        for(int i=0; i<kol; i++){
            if ((result[i]==1)&(i!=1)&(i!=2)&(i!=4)&(i!=8)&(i!=16)&(i!=0)){
                return false;
            }
        }
        return true;
    }

    public static int log(int chislo, int stepen){
        int chislo1 = chislo;
        int result = 0;
        while (chislo1>0) {
            result++;
            chislo1 = chislo1/2;
        }
        return result;
    }
}
