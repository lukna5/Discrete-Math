import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class D {
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
                    matrix[j + 1][i] = false;
                }
                else {
                    matrix[i][j + 1] = false;
                    matrix[j + 1][i] = true;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> res = findCycle(findPath());
        for (int i = 0; i < res.size(); i++) {
            writer.write(res.get(i) + " ");
        }
        writer.close();
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
    public static ArrayList<Integer> findPath() throws IOException {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = res.size() - 1; j >= 0; j--) {
                if (matrix[res.get(j)][i]){
                    max = j + 1;
                    break;
                }
            }
            res.add(max, i);
        }
        return res;
    }
    public static ArrayList<Integer> findCycle(ArrayList<Integer> path){
        int start = 0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(path.get(0));
        res.add(path.get(1));
        path.remove(0);
        path.remove(0);
        while (true){
            if (!matrix[path.get(0)][res.get(0)]){
                break;
            }
            res.add(path.get(0));
            path.remove(0);
            if (path.size() == 0) {
                return res;
            }
        }
        int count = 0;
        while (!path.isEmpty()) {
            boolean found = false;
            for (int i = 1; i < res.size(); i++) {
                if (matrix[path.get(start)][res.get(i)]) {
                    res.add(i, path.get(start));
                    path.remove(start);
                    found = true;
                    count = 0
                    break;
                }
            }
            if (!found) {
                start = (start + 1) % res.size();
            }
        }
        return res;
    }
}
