import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Uzell{
    int x;
    int y;
    String z;
    public Uzell(int x, int y, String z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class Letters{
    String[] list;
    int count = 0;
    public Letters(){
        list = new String[256];
    }
}
public class CheckNka {
    public static String line;
    public static int size;
    public static int n;
    public static int[] ends;
    public static void main(String[] args) throws IOException {
        // new InputStreamReader()
        // (new FileReader(new File("problem2.in"))
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader(new File("problem2.in")));
        //Scanner sc = new Scanner(new File("problem2.in"));
        //Scanner sc = new Scanner(System.in);
        line = reader.readLine();
        size = line.length();
        FileWriter writer = new FileWriter("problem2.out");

        n = nextInt(reader);
        int m = nextInt(reader);
        int k = nextInt(reader);
        Letters[][] perexods = new Letters[n + 1][n + 1];
        ends = new int[k];
        for (int i = 0; i < k; i++) {
            ends[i] = (nextInt(reader));
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt(reader);
            int y = nextInt(reader);
            String z = Character.toString(reader.read());
            if (perexods[x][y] == null) perexods[x][y] = new Letters();
            perexods[x][y].list[perexods[x][y].count] = z;
            perexods[x][y].count++;
            //Uzell next = new Uzell(x, y, z);
            //uzels.add(next);
        }
        /*for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (perexods[i][j] != null) {
                    for (int l = 0; l < perexods[i][j].list.size(); l++) {
                        System.out.print(perexods[i][j].list.get(l) + " " + i + " " + j);
                    }
                    System.out.println();
                }
            }
        }

         */
        boolean res = checkWord(0, 1, perexods);
        if (res){
            writer.write("Accepts");
            //System.out.println("Accepts");
        }
        else{
            writer.write("Rejects");
           //System.out.println("Rejects");
        }
       writer.close();
    }
    public static int[] contain(Letters[][] perexods, Uzell uzel){
        int[] res = new int[256];
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            //System.out.println(perexods[uzel.x][i]);
            if (perexods[uzel.x][i] == null) continue;
            //System.out.println(perexods[uzel.x][i] + " 777 " + uzel.z);

            for (int j = 0; j < perexods[uzel.x][i].count; j++) {
                if ((uzel.z).equals(perexods[uzel.x][i].list[j])) res[count++] = i;
            }
        }
       /* System.out.println("print res");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();

        */
        if (count >= 1) return res;
        return res;
    }

    public static boolean checkWord(int let, int start, Letters[][] perexods){
        if (let >= size){
            //System.out.println(let + " " + start + " " + ends.contains(start));
            for (int i = 0; i < ends.length; i++) {
                if (ends[i] == start) return true;
            }
            return false;
        }
        boolean res = false;
        Uzell next = new Uzell(start, 0, Character.toString(line.charAt(let)));
        int[] to = contain(perexods, next);
        //System.out.println("print res");
       // for (int i = 0; i < to.size(); i++) {
           // System.out.print(to.get(i) + " ");
       // }
        //System.out.println();
        for (int i = 0; i < to.length; i++) {
            if (to[i] == 0) break;
            //System.out.println(i + " i");
            res |= checkWord(let + 1, to[i], perexods);
            //System.out.println(res + " " + let);

            if (res) return true;
        }
        return res;
    }

    public static int nextInt(BufferedReader input) throws IOException {
        StringBuilder builder = new StringBuilder();
        int next;
        while ((next = input.read()) <= 40){
        }
        builder.append(Character.toString(next));
        while ((next = input.read()) > 40){
            builder.append(Character.toString(next));
        }
        return Integer.parseInt(builder.toString());
    }

}

