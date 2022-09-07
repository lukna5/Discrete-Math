import javax.management.Query;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class A {
    private static class Reader {

        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        public static String readLine() throws IOException {
            return reader.readLine();
        }
        public static String readSymb() throws IOException {
            return Character.toString(reader.read());
        }
        public static int readInt() throws IOException {
            StringBuilder builder = new StringBuilder();
            int symb;
            while(!Character.isDigit(symb = reader.read()));
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
            builder.append(Charac   ter.toString(symb));
            while (!((symb = reader.read()) < 32 || symb > 122)){
                builder.append(Character.toString(symb));
            }
            return builder.toString();
        }
        public static void close() throws IOException {
            reader.close();
        }


    }
    static boolean[][] matrix;
    static ArrayDeque<Integer> deque = new ArrayDeque();
    public static int getSecond(){
        int first = deque.removeFirst();
        int second = deque.getFirst();
        deque.addFirst(first);
        return second;
    }
    public static int getDeq(int index){
        ArrayDeque<Integer> deque2 = new ArrayDeque();
        for (int i = 0; i < index; i++) {
            deque2.addFirst(deque.removeFirst());
        }
        int res = deque.getFirst();
        while (!deque2.isEmpty()){
            deque.addFirst(deque2.removeFirst());
            ;
        }
        if (deque.size() != n) try {
            throw new Exception("Pizdec");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    static int n;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        n = Reader.readInt();
        //n = sc.nextInt();
        matrix = new boolean[n+1][n+1];
        for (int i = 2; i <= n; i++) {
            //String line = sc.next();
            String line = Reader.readNext();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '1'){
                    matrix[i][j + 1] = true;
                    matrix[j + 1][i] = true;
                }
                else {
                    matrix[i][j + 1] = false;
                    matrix[j + 1][i] = false;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            deque.addLast(i);
        }
        findHam();
        //sc.close();
        Reader.reader.close();
    }

    public static void reverse(int first, int second){
        ArrayDeque<Integer> deque1 = new ArrayDeque();
        ArrayDeque<Integer> start = new ArrayDeque();
        for (int i = 0; i < first; i++) {
            start.addLast(deque.removeFirst());
        }
        for (int i = first; i < second + 1; i++) {
            deque1.addFirst(deque.removeFirst());
        }
        for (int i = first; i < second + 1; i++) {
            deque.addFirst(deque1.removeLast());
        }
        for (int i = 0; i < first; i++) {
            deque.addFirst(start.removeLast());
        }
        //System.out.println();
    }
    public static void findHam() throws IOException {
        for (int i = 0; i < n * (n - 1); i++) {
            if (matrix[deque.getFirst()][getDeq(1)]){
                deque.addLast(deque.removeFirst());
            } else {
                int revers = 2;
                for (; (!matrix[deque.getFirst()][getDeq(revers)] || !matrix[getDeq(1)][getDeq(revers + 1)]); revers++) {
                }
                reverse(1, revers);
                deque.addLast(deque.removeFirst());
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!deque.isEmpty()){
           writer.write(deque.removeFirst().toString() + " ");
        }
        writer.close();
    }
}
