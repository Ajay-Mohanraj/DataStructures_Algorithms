package Unit3.day4;

import java.util.ArrayList;
import java.util.Arrays;

public class Day4_Practice2_RemoveDups {

    public static void removeConsecutiveDuplicates(ArrayList<Integer> a) {
        // TODO: removeConsecutiveDuplicates
        int i = 0;
        while (i < a.size() - 1) {
            if (a.get(i).equals(a.get(i + 1))) {
                a.remove(i+1);
            }
            else {
                i++;
            }
        }


    }

    public static void main(String[] args) {
        ArrayList<Integer> arg1 = new ArrayList<>();

        arg1.addAll(Arrays.asList(1, 2, 2, 2, 3, 2, 2, 3));


        // TODO: Call removeConsecutiveDuplicates and then print result
    }
}
