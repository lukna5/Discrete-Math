import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class I {
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
        public static long readInt() throws IOException { // readlong
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
                return Long.parseLong(builder.toString());
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
            return (num + MOD) % MOD;
        }
        return (num % MOD);
    }

    private static void filter(long[] r, long n){
       for (int i = 0; i <= k; i++) {
            q[i] = r[i * 2];
        }

        int start = 0;
        if (isOdd) start++;
        int ind = 0;
        for (int i = 0; i < 2 * k; i++) {
            if (n % 2 == i % 2) {
                a[ind++] = a[i];
            }
        }
        ;
    }
    private static long fastSearchingN(long n){
        long[] r;
        long[] antiQ;
        n--;
        while (n >= k) {
            for (int i = k; i < 2 * k; i++) {
                a[i] = 0;
                for (int j = 1; j < k + 1; j++) {
                    if (j > k || i - j < 0 || i - j > 2 * k) continue;
                    a[i] = normalMod(a[i] - normalMod(q[j] * a[i - j]));
                }
            }
            antiQ = getAntiQ();
            r = multiply(antiQ);
            filter(r, n);
            n /= 2;
        }
        if (n >= k) return 0;
        return a[(int) n];
    }
    
    private static long[] multiply(long[] antiQ) {
        long[] res = new long[4 * k + 10];
        for (int i = 0; i <= 2 * k; i += 2) {
            long num = 0;
            for (int j = 0; j < i + 1; j++) {
                if (j > k || i - j > k || i - j > 2 * k || i - j < 0 || j > k + 1) continue;
                num = normalMod(num + normalMod(q[j] * antiQ[i - j]));
            }
            res[i] = num;
        }
        return res;
    }

    private static long[] getAntiQ() {
        long[] res = new long[2 * k + 10];
        for (int i = 1; i <= k; i += 2) {
            res[i] = normalMod(-1 * q[i]);
        }
        for (int i = 0; i <= k; i += 2) {
            res[i] = q[i];
        }
        return res;
    }

    private static final int MOD = 104857601;
    private static long[] c;
    private static long[] a;
    private static long[] q;
    private static int k;
    private static boolean isOdd;
    public static void main(String[] args) throws IOException {
        k = (int) Reader.readInt();
        long n = Reader.readInt();
        a = new long[2 * k + 30];
        //c = new long[k + 1];
        q = new long[2 * k + 10];
        if (n % 2 == 1) isOdd = true;
        else isOdd = false;
        for (int i = 0; i < k; i++) {
            a[i] = Reader.readInt();
        }
        for (int i = 1; i <= k; i++) {
            q[i] = normalMod(-1 * Reader.readInt());
        }
        q[0] = 1;
        System.out.println(fastSearchingN(n));
    }
}
