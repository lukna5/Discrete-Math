import java.io.*;
import java.util.ArrayList;

public class CheckEq {
    public static class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static class Stack{
        int[] list1 = new int[4];
        int[] list2 = new int[4];
        int size = 0;
        int realSize = 4;
        public Pair pop(){
            int res1 = list1[size - 1];
            int res2 = list2[size - 1];
            size--;
            return new Pair(res1, res2);
        }
        public void put(int x, int y){
            list1[size] = x;
            list2[size] = y;
            size++;
            if (size >= realSize - 1){
                realSize *= 2;
                int[] list11 = new int[realSize];
                int[] list22 = new int[realSize];
                for (int i = 0; i < size; i++) {
                    list11[i] = list1[i];
                    list22[i] = list2[i];
                }
                list1 = list11;
                list2 = list22;
                list11 = null;
                list22 = null;

            }
        }
    }
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
    static int[] was1;
    static boolean[][] was2;
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
        reader = new BufferedReader(new FileReader("equivalence.in"));
        //reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter("equivalence.out");
        ends1 = new ArrayList<>();
        n1 = nextInt();
        m1 = nextInt();
        k1 = nextInt();
        letters = new ArrayList<>();
        for (int i = 0; i < k1; i++) {
            ends1.add(nextInt());
        }

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
        per2 = new int[n2 + 1][33];
        for (int i = 0; i < m2; i++) {
            int first = nextInt();
            int second = nextInt();
            String symb11 = next();
            if (!letters.contains(symb11)) letters.add(symb11);
            per2[first][(int) symb11.charAt(0) - 95] = second;
            //System.out.println("from " + first + " to " + (int) symb1.charAt(0) + " by " + second);
        }
        //was1 = new int[n1 + 1];
        was2 = new boolean[n1 + 1][n2 + 1];

        if (checkEq(1, 1)){
            writer.write("YES");
            //System.out.println("Yes");
        }
        else{
            writer.write("NO");
            //System.out.println("No");
        }
        writer.close();
    }
    public static boolean checkEq(int first, int second){
        Stack stack = new Stack();
        stack.put(first, second);
        while (stack.size > 0){
            Pair next = stack.pop();
            first = next.first;
            second = next.second;
            was2[first][second] = true;
            boolean contain1 = ends1.contains(first);
            boolean contain2 = ends2.contains(second);

            if ((contain1 && !contain2) || (!contain1 && contain2)){
                return false;
            }
            for (int i = 0; i < letters.size(); i++) {
                int first1 = per1[first][letters.get(i).charAt(0) - 95];
                int second1 = per2[second][letters.get(i).charAt(0) - 95];
                if (!was2[first1][second1]) stack.put(first1, second1);
            }
        }
        return true;


    }


}
