package geekbrains.dfprojectJava.lesson5;

import java.util.ArrayList;
import java.util.List;

public class BackpackApp {

    static int[] weights = {21, 8, 6, 5, 1};
    static ArrayList<Integer> backPack;
    static int capacity = 30;

    public static void main(String[] args) {
        if(pack(0,new ArrayList<Integer>()) == 1) {
            System.out.println(backPack);
        }else {
            System.out.println("Решений нет");
        }
    }

    static int pack(int count, List<Integer> list) {
        int sum = result(list);
        if (sum == capacity) {
            backPack = new ArrayList<Integer>(list);
            return 1;
        }
        if (sum > capacity) {
            return 0;
        }
        while (count < weights.length) {
            List<Integer> nextList = new ArrayList<Integer>(list);
            nextList.add(weights[count++]);
            if (pack(count,nextList) == 1) {
                return 1;
            }
        }
        return 0;
    }

    static int result(List<Integer> list) {
        int sum = 0;
        for (Integer listInt : list) {
            sum += listInt;
        }
        return sum;
    }
}
