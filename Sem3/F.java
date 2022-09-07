import java.io.*;
import java.util.*;

public class F {
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
    static TreeSet<Integer> set;
    static ArrayDeque<Integer> code;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        n = Reader.readInt();
        //n = sc.nextInt();
        set = new TreeSet<>();
        code = new ArrayDeque<>();
        sizes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sizes[i] = 1;
            set.add(i);
        }
        for (int i = 0; i < n - 2; i++) {
            int a = Reader.readInt();
            sizes[a]++;
            code.add(a);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!code.isEmpty()){
            int a = getMin();
            int b = code.poll();
            sizes[b]--;
            writer.write(a + " " + b + "\n");
        }
        writer.write(set.first() + " " + set.higher(set.first()));
        writer.close();
        //findHam();
        //sc.close();
        Reader.reader.close();
    }
    public static int getMin(){
        int min = 0;
        for (int i = 1; i < n + 1; i++) {
            if (sizes[i] == 1){
                set.remove(i);
                sizes[i]--;
                min = i;
                break;
            }
        }
        return min;
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
}
