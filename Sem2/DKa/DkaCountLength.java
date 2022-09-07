import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DkaCountLength {
    static class Uzell{
        int x;
        int y;
        String z;
        public Uzell(int x, int y, String z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static ArrayList <Integer> ends;
    public static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("problem4.in"));
        //Scanner sc = new Scanner(System.in);
        FileWriter writer = new FileWriter("problem4.out");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        ends = new ArrayList<>();
        int[][] perexods = new int[n + 1][128];
        for (int i = 0; i < k; i++) {
            ends.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            char z = sc.next().charAt(0);
            perexods[x][z] = y;
        }
        int res = checkWord(l, 1, perexods);
        String res1 = Integer.toString(res);
        writer.write(res1);
        //System.out.println(res);
        writer.close();
    }
    public static int checkWord(int l, int start, int[][] perexods){
        if (l <= 0){
            //System.out.println(let + " " + start + " " + ends.contains(start));
            for (int i = 0; i < ends.size(); i++) {
                if (ends.get(i) == start) return 1;
            }
            return 0;
        }
        //System.out.println("print res");
        // for (int i = 0; i < to.size(); i++) {
        // System.out.print(to.get(i) + " ");
        // }
        //System.out.println();
        int res = 0;
        for (int i = 97; i < 122; i++) {
            if (perexods[start][i] == 0) continue;
            //System.out.println(i + " i");
            res = (res + checkWord(l - 1, perexods[start][i], perexods)) % (1000000000 + 7);
            //System.out.println(res + " " + let);
        }
        return res;
    }
    public static int contain(String[][] uzels, int start, String letter){
        for (int i = 1; i < n + 1; i++) {
            if (uzels[start][i].equals(letter)) return i;
        }
        return 0;
    }
}
