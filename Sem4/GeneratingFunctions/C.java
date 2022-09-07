import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
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
    private static long[] a;
    private static long[] c;
    private static int k;
    private static long[] findP(){
        long[] res = new long[k + 1];
        long[] left = new long[k];
        for (int i = 0; i < k; i++) {
            left[i] = a[i];
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; i + j < k; j++) {
                res[i + j] += left[i] * (-1 * c[j]);
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        k = Reader.readInt();
        long[] q = new long[k + 1];
        a = new long[k];
        c = new long[k + 1];
        for (int i = 0; i < k; i++) {
            a[i] = Reader.readInt();
        }
        for (int i = 1; i <= k; i++) {
            c[i] = Reader.readInt();
        }
        c[0] = -1;
        q[0] = 1;
        for (int i = 1; i <= k; i++) {
            q[i] = -1 * c[i];
        }
        long[] p = findP();
        int size = 0;
        for (int i = k; i >= 0; i--) {
            if (p[i] != 0) {
                size = i;
                break;
            }
        }
        System.out.println(size);
        for (int i = 0; i <= size; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();

        size = 0;
        for (int i = k; i >= 0; i--) {
            if (q[i] != 0){
                size = i;
                break;
            }
        }
        System.out.println(size);
        for (int i = 0; i <= size; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }
}
