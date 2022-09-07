import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RazbitShiti {
    public static int n;
    public static int k;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("subsets.in"));
        FileWriter writer = new FileWriter("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\File.txt");
        n = input.nextInt();
        k = input.nextInt();
        input.close();
        ArrayList<Integer> line = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            line.add(i);
        }
        genmn("", line, 0);
        writer.write("\n");
        writer.close();
    }
    public static void genmn(String was, ArrayList<Integer> newas, int size){
        for (int i = 1; i < n/2 + 1; i++) {
            System.out.println(i);
            newas.remove(newas.lastIndexOf(i));
            genpodmn(was + i, newas,  0);
            newas.add(i);
            System.out.println();
        }
    }
    public static void genpodmn(String was, ArrayList<Integer> newas, int size){
        if (size >= n){
            System.out.println(was + " was");
            System.out.println(newas.toString());
            return;
        }
        for (int i = size+1; i < k + 1; i++) {
            //System.out.println(i + " i");
            //System.out.println(newas.size()+" size");
            for (int j = Character.getNumericValue(was.charAt(was.length()-1)) + 1; j < newas.size(); j++) {
                if (newas.contains(j)) {
                    newas.remove(newas.lastIndexOf(j));
                    genpodmn(was + j, newas, size);
                    newas.add(j);
                }
            }
        }
    }
    
}
