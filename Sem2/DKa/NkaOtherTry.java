import java.io.*;
import java.util.ArrayList;

public class NkaOtherTry {
    static class Lets{
        ArrayList<Integer> list = new ArrayList<>();
        boolean created = false;
        public Lets(ArrayList<Integer> list){
            this.list = list;
        }
        public Lets(){

        }
    }
    static BufferedReader reader;
    static PrintWriter writer;
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new FileReader("problem2.in"));
        writer = new PrintWriter("problem2.out");
        ArrayList<Integer> ends = new ArrayList<>();
        String word = next();
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        for (int i = 0; i < k; i++) {
            ends.add(nextInt());
        }
        ArrayList<Integer> cond1 = new ArrayList<>();
        ArrayList<Integer> cond2;
        cond1.add(1);
        Lets[][] per = new Lets[n + 1][128];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 128; j++) {
                per[i][j] = new Lets();
            }
        }
        for (int i = 0; i < m; i++) {
            int first = nextInt();
            int second = nextInt();
            String symb1 = next();
            if (per[first][(int) symb1.charAt(0)] == null){
                per[first][(int) symb1.charAt(0)] = new Lets();
                per[first][(int) symb1.charAt(0)].list.add(second);
            }
            else per[first][(int) symb1.charAt(0)].list.add(second);
            //System.out.println("from " + first + " to " + (int) symb1.charAt(0) + " by " + second);
        }
        boolean contain = false;
        boolean stop = false;
        for (int i = 0; i < word.length(); i++) {
           // for (int j = 0; j < cond1.size(); j++) {
            //    System.out.print(cond1.get(j) + " ");
           // }
            //System.out.println();
            contain = false;
            cond2 = new ArrayList<>();
            for (int j = 0; j < cond1.size(); j++) {
                //System.out.println(word.charAt(i) + " " + (int) word.charAt(i));
                for (int l = 0; l < per[cond1.get(j)][(int) word.charAt(i)].list.size(); l++) {
                    int next = per[cond1.get(j)][(int) word.charAt(i)].list.get(l);
                    if (!(cond2.contains(next))){
                        contain = true;
                        cond2.add(next);
                    }
                }

            }
            if (!contain){
                stop = true;
                writer.write("Rejects");
                //System.out.println("Rejects");
                break;
            }
            cond1 = cond2;
        }
        if (contain && !stop) {
            contain = false;
            for (int i = 0; i < cond1.size(); i++) {
                //System.out.println(cond1.get(i));
                if (ends.contains(cond1.get(i))) {
                    contain = true;
                    writer.write("Accepts");
                    //System.out.println("Accepts");
                    break;
                }
            }
        }
        if (!contain && !stop){
            writer.write("Rejects");
            //System.out.println("“Rejects");
        }
        writer.close();
    }
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
}
