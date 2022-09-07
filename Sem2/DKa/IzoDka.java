import java.io.*;
import java.util.ArrayList;

public class IzoDka {
    static BufferedReader reader;
    static PrintWriter writer;
    static int n1;
    static int m1;
    static int k1;
    static int n2;
    static int m2;
    static int k2;
    static int[][] per1;
    static int[][] per2;
    static ArrayList<Integer> ends1;
    static ArrayList<Integer> ends2;
    static ArrayList<String> letters;
    static int[] equals;
    static boolean[] was1;
    static boolean[] was2;
    static int nextInt() throws IOException {
        StringBuilder builder = new StringBuilder();
        int symb = reader.read();
        while(symb < 40){
            symb = reader.read();
        }
        while (symb > 47 && symb < 58){
            builder.append(Character.toString(symb));
            symb = reader.read();
        }
        //System.out.println(builder);
        return Integer.parseInt(builder.toString());
    }

    static String next() throws IOException {
        StringBuilder builder = new StringBuilder();
        int symb = reader.read();
        while(symb < 33){
            symb = reader.read();
        }
        while (symb >= 33){
            builder.append(Character.toString(symb));
            symb = reader.read();
        }
        //System.out.println(builder + " string");
        return builder.toString();
    }
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new FileReader("isomorphism.in"));
        writer = new PrintWriter("isomorphism.out");
        ends1 = new ArrayList<>();
        n1 = nextInt();
        m1 = nextInt();
        k1 = nextInt();
        letters = new ArrayList<>();
        for (int i = 0; i < k1; i++) {
            ends1.add(nextInt());
        }
        ArrayList<Integer> cond1 = new ArrayList<>();
        cond1.add(1);
        per1 = new int[n1 + 1][33];
        for (int i = 0; i < m1; i++) {
            int first = nextInt();
            int second = nextInt();
            String symb11 = next();
            if (!letters.contains(symb11)) letters.add(symb11);
            per1[first][(int) symb11.charAt(0) - 95] = second;
            //System.out.println("from " + first + " to " + (int) symb1.charAt(0) + " by " + second);
        }
        ends2 = new ArrayList<>();
        n2 = nextInt();
        m2 = nextInt();
        k2 = nextInt();
        for (int i = 0; i < k2; i++) {
            ends2.add(nextInt());
        }
        ArrayList<Integer> cond2 = new ArrayList<>();
        cond2.add(1);
        per2 = new int[n2 + 1][33];
        for (int i = 0; i < m2; i++) {
            int first = nextInt();
            int second = nextInt();
            String symb11 = next();
            if (!letters.contains(symb11)) letters.add(symb11);
            per2[first][(int) symb11.charAt(0) - 95] = second;
            //System.out.println("from " + first + " to " + (int) symb1.charAt(0) + " by " + second);
        }
        equals = new int[Math.max(n1, n2) + 1];
        was1 = new boolean[n1 + 1];
        if (checkIz(1, 1)){
            writer.write("YES");
            //System.out.println("Yes");
        }
        else{
            writer.write("NO");
            //System.out.println("No");
        }
        writer.close();
    }
    static boolean checkIz(int first, int second){
        if (ends1.contains(first) != ends2.contains(second)) return false;
        equals[first] = second;
        was1[first] = true;
        int first1 = 0;
        int second1 = 0;
        for (int i = 0; i < letters.size(); i++) {
            first1 = per1[first][letters.get(i).charAt(0) - 95];
            second1 = per2[second][letters.get(i).charAt(0) - 95];
            if (first1 != second1 && (first1 == 0 || second1 == 0)){
                return false;
            }
        }
        if (was1[first1]){
            return second1 == equals[first1];
        }
        else{
            return checkIz(first1, second1);
        }
    }
}
