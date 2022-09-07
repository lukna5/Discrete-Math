import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewMultiki {
    public static void smena(Integer[] firstmas, Integer[] secondmas, int first, int second) {
        firstmas[first] = secondmas[second];
    }
    public static void merge (Integer[] firstmas, Integer[] left, Integer[] right) {
        int size = firstmas.length;
        int index1 = 0;
        int index2 = 0;
        int inv = 0;
        int sizel = left.length;
        int sizer = right.length;
        for (int b=0; b<2000000000; b++) {
            if ((index1 >= sizel) && (index2 >= sizer)) {
                break;
            }
            else {
                if (index1 == sizel) {
                    smena(firstmas, right, index1+index2, index2);

                    index2+=1;
                }
                else {
                    if (index2 == sizer) {
                        smena(firstmas, left, index1+index2, index1);
                        index1+=1;
                    }
                    else {
                        if (!(left[index1] > right[index2])) {
                            smena(firstmas, left, index1+index2, index1);
                            index1+=1;
                        }
                        else {
                            smena(firstmas, right, index1+index2, index2);
                            inv = inv + ((size + 1) / 2) - index1;
                            index2+=1;
                        }
                    }
                }
            }
        }
    }
    public static void mergeSort (Integer[] firstmas) {
        if (firstmas.length > 1) {
            int middle = (firstmas.length + 1) / 2;
            Integer[] left = new Integer[middle];
            Integer[] right = new Integer[firstmas.length - middle];
            for (int i = middle; i < firstmas.length; i++) {
                right[i - middle] = firstmas[i];
            }
            for (int j = 0; j < middle; j++) {
                left[j] = firstmas[j];
            }
            mergeSort(left);
            mergeSort(right);
            merge(firstmas, left, right);
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("nextmultiperm.in"));
        FileWriter writer = new FileWriter("nextmultiperm.out");
        int n = input.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = input.nextInt();
        }
        ArrayList<Integer> list = new ArrayList();
        boolean inf = true;
        for (int i = n - 1; i > 0; i--) {
            if (mas[i] > mas[i - 1]) {
                inf = false;
                int min1 = 200000000;
                //System.out.println(mas[i]);
                //System.out.println(mas[i-1]);
                list.add(mas[i]);
                for (int j = 0; j < i - 1; j++) {
                    writer.write(mas[j] + " ");
                    System.out.print(mas[j] + " ");
                }
                int index = list.size() - 1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > mas[i - 1] && list.get(j) < min1){
                        index = j;
                        min1 = list.get(j);
                    }
                }
                System.out.print(min1 + " ");
                writer.write(min1 + " ");
                //System.out.println(list.toString());
                //System.out.println(min1 + " " + index);
                list.remove(index);
                list.add(mas[i - 1]);
                //System.out.println(list.toString());
                //System.out.println(next);
                //System.out.println(list.size());
                Integer[] mas2 = list.toArray(new Integer[0]);
                mergeSort(mas2);
                int size = list.size();
                for (int j = 0; j < mas2.length; j++) {
                    System.out.print(mas2[j] + " ");
                    writer.write(mas2[j] + " ");
                    //System.out.println(list.toString());
                }
                break;
            } else {
                list.add(mas[i]);
            }
        }
        if (inf) {
            for (int i = 0; i < n; i++) {
                writer.write("0 ");
                System.out.print("0 ");
            }
        }
        writer.close();
    }
    public static int[] findMin(ArrayList<Integer> list) {
        //System.out.println(list.toString());
        int[] min = new int[2];
        min[0] = 2000000000;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min[0]) {
                min[0] = list.get(i);
                min[1] = i;
            }
        }
        //System.out.println(min[0] + " min");
        return min;
    }
}
