import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class F {
    private static class Reader {

        //static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static BufferedReader reader;

        static {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public static String readLine() throws IOException {
            return reader.readLine();
        }
        public static String readSymb() throws IOException {
            return Character.toString(reader.read());
        }
        public static int readInt() throws IOException { // readlong
            StringBuilder builder = new StringBuilder();
            int symb;
            while(!Character.isDigit(symb = reader.read()) && (symb != '-'));
            if (symb == '-') {
                builder.append('-');
                symb = reader.read();
            }
            while(symb < 58 && symb > 47){
                builder.append(Character.toString(symb));
                symb = reader.read();
            }
            try {
                return Integer.parseInt(builder.toString());
            }
            catch (NumberFormatException e){
                System.out.println("Can't Convert String into Integer");
                return -1;
            }
        }
        public static String readNext() throws IOException {
            int symb;
            StringBuilder builder = new StringBuilder();
            while ((symb = reader.read()) < 32 || symb > 122);
            builder.append(Character.toString(symb));
            while (!((symb = reader.read()) < 32 || symb > 122)){
                builder.append(Character.toString(symb));
            }
            return builder.toString();
        }
        public static void close() throws IOException {
            reader.close();
        }
    }

    private static long normalMod(long num){
        if (num < 0) {
            return ((MOD + (num % MOD)) % MOD);
        }
        return (num % MOD);
    }

    private static final int MOD = 1000000007;
    private static int k;
    private static int m;
    private static TreeSet<Integer> c1;
    private static ArrayList<Integer> c;

    private static long[] calculateTrees(){
        long[] t = new long[m + 1];
        t[0] = 1;
        long[] res = new long[m + 1];
        res[0] = 1;
        for (int i = 1; i < m + 1; i++) {
            long num = 0;
            for (long w : c) {
                if (w > i) break;
                num = normalMod(num + t[i - (int) w]);
            }
            res[i] = num;
            for (int j = 0; j < i + 1; j++) {
                t[i] = normalMod(t[i] + normalMod(res[j] * res[i - j]));
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        k = Reader.readInt();
        m = Reader.readInt();
        c1 = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            c1.add(Reader.readInt());
        }
        c = new ArrayList<>(c1);
        long[] res = calculateTrees();
        for (int i = 1; i < m + 1; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
