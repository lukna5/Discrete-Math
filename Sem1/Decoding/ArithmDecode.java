import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class ArithmDecode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        ArrayList<String> alf = new ArrayList<>();
        long[] kol = new long[size];
        BigDecimal[] p = new BigDecimal[size];
        BigDecimal[] lefts = new BigDecimal[size];
        BigDecimal[] rights = new BigDecimal[size];
        BigDecimal[] lefts1 = new BigDecimal[size];
        BigDecimal[] rights1 = new BigDecimal[size];
        long sum = 0;
        for (int i = 0; i < size; i++) {
            alf.add(Character.toString(i + 97));
            kol[i] = input.nextLong(); // количество каждой буквы
            sum += kol[i]; // общее количество букв
        }
        for (int i = 0; i < size; i++) {
            BigDecimal c = BigDecimal.valueOf(kol[i]);
            BigDecimal d = BigDecimal.valueOf(sum);
            //System.out.println(c);
            //System.out.println(d);
            p[i] = c.divide(d, 50, RoundingMode.HALF_DOWN);
            //p[i] = new BigDecimal(kol[i] / sum); // вероятности каждой буквы
        }
        String line = input.next();
        BigDecimal c1 = fromBinary(line);
        double num = Math.pow(2, line.length());
        BigDecimal d1 = new BigDecimal(num);
        //System.out.println(c1 + "c1");
        //System.out.println(d1 + "d1");
        BigDecimal number = c1.divide(d1,200, RoundingMode.HALF_DOWN);
        BigDecimal first = new BigDecimal(0);
        BigDecimal second = p[0];
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
        BigDecimal left;
        BigDecimal right;
        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < size; j++) {
                //System.out.println(number);
                //System.out.println(lefts1[j] + " " + number + " " + rights1[j]);
                //System.out.println(number.compareTo(lefts1[j]) + "   " + number.compareTo(rights1[j]));
                //System.out.println(number + " numberrrrrrr ");

                if (number.compareTo(lefts1[j]) >=0 && number.compareTo(rights1[j]) < 0){
                    //if (number >= lefts[j] && number < rights[j]){
                    System.out.print(alf.get(j));
                    //BigDecimal a = number.subtract(lefts[j]);
                    //BigDecimal b = rights[j].subtract(lefts[j]);
                    left = lefts1[j];
                    right = rights1[j];
                    for (int k = 0; k < size; k++) {
                        BigDecimal a1 = right.subtract(left);
                        BigDecimal b1 = a1.multiply(lefts[k]);
                        BigDecimal b2 = a1.multiply(rights[k]);
                        lefts1[k] = b1.add(left);
                        rights1[k] = b2.add(left);
                    }
                    //number = a.divide(b, 300, RoundingMode.CEILING);
                    break;
                    //System.out.println(number);
                }
            }
        }
    }
    public static BigDecimal fromBinary(String binar){
        BigDecimal result = new BigDecimal(0);
        BigDecimal stepen = new BigDecimal(1);
        for (int i = binar.length() - 1; i >=0 ; i--) {
            //result += Character.getNumericValue(binar.charAt(i)) * stepen;
            BigDecimal i1 = new BigDecimal(Character.getNumericValue(binar.charAt(i)));
            BigDecimal stepen1 = stepen.multiply(i1);
            BigDecimal result1 = result;
            result = result1.add(stepen1);
            BigDecimal stepen2 = stepen;
            stepen = stepen2.multiply(new BigDecimal(2));
            //stepen *= 2;
        }
        return result;
    }
}