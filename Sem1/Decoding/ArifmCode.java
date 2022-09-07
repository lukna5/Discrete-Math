import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class ArifmCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        System.out.println(size);
        ArrayList<String> alf = new ArrayList<>();
        long[] kol = new long[size];
        BigDecimal[] p = new BigDecimal[size];
        BigDecimal[] lefts = new BigDecimal[size];
        BigDecimal[] rights = new BigDecimal[size];
        BigDecimal[] lefts1 = new BigDecimal[size];
        BigDecimal[] rights1 = new BigDecimal[size];
        long sum = 0;
        String line = input.next();
        for (int i = 0; i < size; i++) {
            alf.add(Character.toString(97+i));
        }
        for (int i = 0; i < line.length(); i++) {
            //kol[i] = input.nextLong(); // количество каждой буквы
            kol[line.charAt(i)-97] +=1;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(kol[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            BigDecimal c = BigDecimal.valueOf(kol[i]);
            BigDecimal d = BigDecimal.valueOf(line.length());
            //System.out.println(c);
            //System.out.println(d);
            p[i] = c.divide(d, 50, RoundingMode.HALF_DOWN);
            //p[i] = new BigDecimal(kol[i] / sum); // вероятности каждой буквы
        }
        //double num = Math.pow(2, line.length());
        //BigDecimal d1 = new BigDecimal(num);
        //System.out.println(c1 + "c1");
        //System.out.println(d1 + "d1");a
        //BigDecimal number = c1.divide(d1,200, RoundingMode.HALF_DOWN);
        //BigDecimal first = new BigDecimal(0);
        //BigDecimal second = p[0];
        BigDecimal verh = new BigDecimal(0);
        for (int i = 0; i < size; i++) {
            lefts[i] = verh;
            lefts1[i] = verh;
            rights[i] = p[i].add(verh);
            rights1[i] = p[i].add(verh);
            //System.out.println(lefts[i] + " " + rights[i]);
            verh = rights[i];
        }
        /*for (int i = 0; i < size; i++) {
            System.out.print(lefts[i] + " " + rights[i]);
            System.out.println();
        }

         */


        //System.out.println(number);
        BigDecimal left = new BigDecimal(0);
        BigDecimal right = new BigDecimal(0);
        for (int i = 0; i < line.length(); i++) {
            //System.out.println(number);
            //System.out.println(lefts1[j] + " " + number + " " + rights1[j]);
            //System.out.println(number.compareTo(lefts1[j]) + "   " + number.compareTo(rights1[j]));
            //System.out.println(number + " numberrrrrrr ");
            int index = line.charAt(i) - 97;

            //if (number >= lefts[j] && number < rights[j]){
            //BigDecimal a = number.subtract(lefts[j]);
            //BigDecimal b = rights[j].subtract(lefts[j]);
            left = lefts1[index];
            right = rights1[index];
            for (int k = 0; k < size; k++) {
                BigDecimal a1 = right.subtract(left);
                BigDecimal b1 = a1.multiply(lefts[k]);
                BigDecimal b2 = a1.multiply(rights[k]);
                lefts1[k] = b1.add(left);
                rights1[k] = b2.add(left);
            }
            //BigDecimal sum1 = left.add(right);
            //BigDecimal tochka = sum1.divide(new BigDecimal(2));
            //number = a.divide(b, 300, RoundingMode.CEILING);
            //System.out.println(number);
        }
        long l = 0;
        long r = (long) Math.pow(2, line.length()) - 1;
        BigDecimal q = new BigDecimal(0);
        BigDecimal q1 = new BigDecimal(0);
        BigDecimal number = new BigDecimal(0);
        //double niz = Math.pow(2, q);
        //while (number.compareTo(new BigDecimal(right)) < 0){

        //}
    }
}