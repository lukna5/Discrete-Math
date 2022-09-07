import java.io.*;
import java.util.ArrayList;

public class CountDkas {
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
        reader = new BufferedReader(new FileReader("problem4.in"));
        //reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter("problem4.out");
        ends1 = new ArrayList<>();
        n1 = nextInt();
        m1 = nextInt();
        k1 = nextInt();
        int l1 = nextInt();
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
        int kol[][] = new int[l1 + 1][n1 + 1];
        kol[0][1] = 1;
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < n1 + 1; j++) {
                for (int k = 0; k < letters.size(); k++) {
                    //boolean havePer = ((per1[j][letters.get(k).charAt(0) - 95]) != 0);
                    kol[i][per1[j][letters.get(k).charAt(0) - 95]] = (kol[i][per1[j][letters.get(k).charAt(0) - 95]] + kol[i - 1][j]) % (1000000000 + 7);

                    // System.out.println("i " + i + " per " + per1[j][letters.get(k).charAt(0) - 95] + " res " + kol[i - 1][j]);
                }
            }
            //System.out.println();
        }
       // printMatrix(kol, l1 + 1, n1 + 1);
        //System.out.println(sumRow(l1, kol));
        writer.write(Integer.toString(sumRow(l1, kol)));
        writer.close();
    }

    private static int sumRow(int r, int[][] mas){
        int res = 0;
        for (int i = 0; i < ends1.size(); i++) {
            //System.out.println(ends1.get(i) + " ends");
            res = (res + mas[r][ends1.get(i)]) % (1000000000 + 7);
        }
        return res;
    }

    private static void printMatrix(int mas[][], int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
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
