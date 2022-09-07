import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Sailas {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.in")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Андрей\\IdeaProjects\\Лаба по дискретке\\src\\allvectors.out")));
        //PrintStream writer = new PrintStream(System.out);
        Map<String, String> map = new HashMap<>();
        String line = input.readLine();
        int n = Integer.parseInt(line);
        //int n = input.nextInt();
        input.close();
        String last = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            last = last + "0";
        }
        writer.write(last + "\n");
        System.out.println(last);
        map.put(last, "");
        while (true) {
            count++;
            String suspect = sdvigvlevo(last);
            if (!map.containsKey(suspect + 1)) {
                suspect = suspect + "1";
            }
            else if (!map.containsKey(suspect + 0)){
                suspect = suspect + 0;
            }
            else break;
            writer.write(suspect + "\n");
            System.out.println(suspect);
            map.put(suspect, "");
            last = suspect;
            }
            writer.close();
            //gen(n, was, writer);
    }
    public static String sdvigvlevo (String was) {
        StringBuilder builder = new StringBuilder(was);
        builder.deleteCharAt(0);
        return builder.toString();
    }
}

