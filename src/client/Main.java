package client;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("abcd");
        list.add("bcd");
        List<String> result = new ArrayList<String>();
        backtrack(list,"",result,20);
        /*for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i) + " (" + result.get(i).length() + ")");*/
        isWordIn("abcdbcd",result);
    }
    private static void isWordIn(String s,List<String> list){
        System.out.println("Is (\""+ s +"\") in ? : " + list.contains(s));
    }
    private static void backtrack(List<String> strings, String current, List<String> result, int maxLength) {
        if (current.length() <= maxLength) {
            result.add(current);
        }

        if (current.length() > maxLength) {
            return;
        }

        for (String str : strings) {
            for (int i = 0; i < str.length(); i++) {
                String newCombination = current + str;
                if (newCombination.length() <= maxLength) {
                    backtrack(strings, newCombination, result, maxLength);
                }
            }
        }
    }
}
