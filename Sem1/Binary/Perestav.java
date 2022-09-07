import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Perestav {
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

        public static int n;
        public static FileWriter writer;
        public static void main(String[] args)throws IOException {
            //Scanner input = new Scanner(System.in);
            Scanner input = new Scanner(new File("nextperm.in"));
            writer = new FileWriter("nextperm.out");
            n = input.nextInt();
            input.nextLine();
            String line;
            line = input.nextLine();
            String[] mas = line.split(" ");
            ArrayList<Integer> est = new ArrayList<>(); // arraylist
            ArrayList<Integer> netu = new ArrayList<>();
            int max = Integer.parseInt(mas[mas.length-1]);
            int min = Integer.parseInt(mas[mas.length-1]);
            int realmax = n+1;
            int realmin = 0;
            boolean inf = false;        
            for (int i = mas.length-1; i >= 0; i--) {
                int number = Integer.parseInt(mas[i]);
                netu.add(number);
                if (number > min){
                    //System.out.println(number + " number");
                    for (int j = 0; j < i; j++) {
                        est.add(Integer.parseInt(mas[j]));
                    }
                    for (int j = 0; j < netu.size(); j++) {
                        if (netu.get(j) < number && realmin < netu.get(j)) realmin = netu.get(j);
                    }
                    netu.remove(netu.lastIndexOf(realmin));
                    est.add(realmin);
                    Integer[] mas2 = netu.toArray(new Integer[0]);
                    mergeSort(mas2);
                    for (int j = 0; j < est.size(); j++) {
                        //System.out.print(est.get(j)+" ");
                        writer.write(est.get(j)+" ");
                    }
                    for (int j = mas2.length-1; j >= 0; j--) {
                        //System.out.print(mas1[j]+" ");
                        writer.write(mas2[j]+" ");
                    }
                    //System.out.println("start2");
                    //System.out.println(Arrays.toString(est.toArray()));
                    //System.out.println(Arrays.toString(netu.toArray()));
                    //gen(est, netu, i + 1, n - i - 1, true);
                    inf = true;
                    break;
                } else {
                    min = number;
                }
            }
            if (!inf) {
                for (int i = 0; i < n; i++) {
                    //  System.out.print(0 + " ");
                    writer.write(0 + " ");
                }
                //System.out.println();
            }
            est = new ArrayList<>();
            netu = new ArrayList<>();
            //System.out.println();
            writer.write("\n");
            inf = false;
            for (int i = mas.length-1; i >= 0; i--) {
                int number = Integer.parseInt(mas[i]);
                netu.add(number);
                if (number < max){
                    for (int j = 0; j < i; j++) {
                        est.add(Integer.parseInt(mas[j]));
                    }
                    for (int j = 0; j < netu.size(); j++) {
                        if (netu.get(j) > number && realmax > netu.get(j)) realmax = netu.get(j);
                    }
                    netu.remove(netu.lastIndexOf(realmax));
                    est.add(realmax);
                    Integer[] mas1 = netu.toArray(new Integer[0]);
                    mergeSort(mas1);
                    for (int j = 0; j < est.size(); j++) {
                        //System.out.print(est.get(j)+" ");
                        writer.write(est.get(j)+" ");
                    }
                    for (int j = 0; j < mas1.length; j++) {
                        //System.out.print(mas1[j]+" ");
                        writer.write(mas1[j]+" ");
                    }
                    //System.out.println(Arrays.toString(est.toArray()));
                    //System.out.println(Arrays.toString(netu.toArray()));
                    //gen(est, netu, i + 1, n - i - 1, false);
                    inf = true;
                    break;
                } else {
                    max = number;
                }
            }
            //if (!inf) for (int i = 0; i < n; i++) System.out.print(0 + " ");
            if (!inf) for (int i = 0; i < n; i++) {
                writer.write(0 + " ");
            }
            writer.close();
        }
    }
