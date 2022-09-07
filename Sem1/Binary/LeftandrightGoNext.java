import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeftandrightGoNext {
    public static void main(String[] args)throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("nextbrackets.in"));
        FileWriter writer = new FileWriter("nextbrackets.out");
        String[] mas = input.nextLine().split("");
        int high = 0;
        int right = 0;
        int left = 0;
        //for (int j = 0; j < mas.length; j++) {
            //System.out.print(j);
        //}
        //System.out.println();
        for (int i = mas.length-1; i >= 0  ; i--) {
            if (mas[i].equals(")")){
                right++;
                high++;
            }
            else{
                left++;
                high--;
            }
            if (high > 1){
                while(mas[i].equals(")")){
                    right++;
                    i--;
                }
                right-=2;
                mas[i]=")";
                mas[i+1] = "(";
                i+=2;
                //System.out.println(left + " left");
                //System.out.println(right + " right");
                //System.out.println(i);
                for (int j = 0; j < left; j++) {
                    mas[i] = "(";
                    i++;
                }
                for (int j = 0; j < right; j++) {
                    mas[i] = ")";
                    i++;
                }
                for (int j = 0; j < mas.length; j++) {
                    writer.write(mas[j]);
                    //System.out.print(mas[j]);
                }
                break;
            }
            if (i == 0){
                writer.write("-");
                //System.out.println("-");
            }
        }
        writer.close();
    }
}
