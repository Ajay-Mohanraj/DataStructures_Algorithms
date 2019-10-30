package Unit3.day4;

import java.util.ArrayList;
import java.util.Arrays;

public class Day4_Practice1_Intersection {

    public static ArrayList<Integer> intersect(ArrayList<Integer> a, ArrayList<Integer> b) {
        // TODO : Implement intersect
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : a) {
            int temp = num;
            for (int tum : b) {
                if (tum == temp) {
                    list.add(tum);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arg1 = new ArrayList<>();
        ArrayList<Integer> arg2 = new ArrayList<>();

        arg1.addAll(Arrays.asList(1, 4, 8, 9, 11, 15, 17, 28, 41, 59));
        arg2.addAll(Arrays.asList(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81));

        // TODO : Call intersect and then print the result
        System.out.println(intersect(arg1, arg2));
    }
}
