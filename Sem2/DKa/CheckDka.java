import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Uzel{
    int x;
    int y;
    String z;
    public Uzel(int x, int y, String z){
      this.x = x;
      this.y = y;
      this.z = z;
    }
}
public class CheckDka {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("problem1.in"));
        String line = sc.nextLine();
        FileWriter writer = new FileWriter("problem1.out");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList <Integer> ends = new ArrayList<>();
        ArrayList<Uzel> uzels = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ends.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            Uzel next = new Uzel(sc.nextInt(), sc.nextInt(), sc.next());
            uzels.add(next);
        }
        int first = 1;
        int second;
        boolean stop = false;
        for (int i = 0; i < line.length(); i++) {
            Uzel next = new Uzel(first, 0, Character.toString(line.charAt(i)));
            int command = contain(uzels, next);
            if (command == 10000000) {
                writer.write("Rejects");
                //System.out.println("Rejects");
                stop = true;
                break;
            }
            first = command;
        }
        if (!stop){
            if (ends.contains(first)){
                writer.write("Accepts");
                System.out.println("Accepts");
            }
            else {
                writer.write("Rejects");
                System.out.println("Rejects");
            }
        }
        writer.close();
    }
    public static int contain(ArrayList<Uzel> uzels, Uzel uzel){
        Uzel next;
        for (int i = 0; i < uzels.size(); i++) {
            next = uzels.get(i);
            if (next.x == uzel.x && next.z.equals(uzel.z)) return next.y;
        }
        return 10000000;
    }
}
