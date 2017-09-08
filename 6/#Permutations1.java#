/*
 
permutations
一组事物可能的序列
Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 
*/

import java.util.*;

public class Permutations1 {
    // 1.DFS 解法，通过交换大法
    public  List<String> permutations(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // 选字符串在指针数的位置
    // 被选择的位置是(0, index - 1)
    // 所有的待字符串被放在index的位置，待字符串是在(index, array.length -1)面的子数组
    private void helper(char[] array, int index, List<String> result) {
        // 中止：只有当我们选择左所有位置的字符串之后，我地先完成左permuation
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // 所有的可能字符串会被放置到指针数的位置
        // 使用可能的字符串会在(index, array.length - 1)的子字符串里面
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            // 当重检之前的层数时候，交换翻来
            swap(array,index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    
    public static void main(String[] args) {
        String st = "abc";
        Permutations1 pe = new Permutations1();
        System.out.println(pe.permutations(st));
    }
}

