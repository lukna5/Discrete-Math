import java.io.*;
import java.util.*;

public class E {
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

    private static class Vertex{
        int num;
        ArrayList<Vertex> sons = new ArrayList<>();
        public Vertex(int num) {
            this.num = num;
        }
    }
    static int[] sizes;
    static Vertex[] graph;
    static boolean ded[];
    static int n;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        n = Reader.readInt();
        //n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        ded = new boolean[n + 1];
        sizes = new int[n + 1];
        graph = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            ded[i] = false;
            graph[i] = new Vertex(i);
            sizes[i] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            int a = Reader.readInt();
            int b = Reader.readInt();
            sizes[a] += 1;
            sizes[b] += 1;
            graph[a].sons.add(graph[b]);
            graph[b].sons.add(graph[a]);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (sizes[i] == 1){
                set.add(i);
            }
        }
        int size = n;
        while (size > 2){
            size--;
            int b = set.first();
            set.remove(b);
            ded[b] = true;
            int res = 0;
            for (int i = 0; i < graph[b].sons.size(); i++) {
                if(!ded[graph[b].sons.get(i).num]){
                    res = graph[b].sons.get(i).num;
                }
            }
            sizes[res]--;
            if (sizes[res] == 1) set.add(res);
            writer.write(res + " ");
        }
        writer.close();
        //findHam();
        //sc.close();
        Reader.reader.close();
    }
    public static void removeValue(ArrayList<Vertex> list, int value){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).num == value) list.remove(i);
        }
    }
    public static Vertex removeList(){
        Vertex res = null;
        for (int i = 1; i <= n; i++) {
            if (graph[i] != null && graph[i].sons.size() == 1){
                res = graph[i];
                //removeValue(graph[i].sons.get(0).sons, res.num);
                break;
            }
        }
        return res;
    }
    public static int removeListt(){
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (sizes[i] == 1){
                sizes[i]--;
                res = graph[i].num;
                removeValue(graph[i].sons.get(0).sons, res);
                break;
            }
        }
        return res;
    }
/*
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

 */
    /*public static void findHam() throws IOException {
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

     */
}
