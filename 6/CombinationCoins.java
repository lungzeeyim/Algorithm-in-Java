/*
coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

]
 */

import java.util.*;

public class CombinationCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // 每个组合以列表cur来表示
        // coins[i]的银币数 = cur.get(i) Returns the element at the specified position in this list.
        // 所有的组合都被存入result, result是用List<Intger>
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(target, coins, 0, cur, result);
        return result;
    }

    // 目标：完成剩低的cent计算
    // coins: 所有可能的不同的银币
    // index: 需要多少coins用于coins[index]
    private void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
        // 中止： index == coins.length
        // 更好的方法是在前面的层里面减少冇必要的DFS分支数
        // coins.length - 1 是最后一个我地使用的银币，并且我所做是为了得到target/coins[coins.length - 1]
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        // 对于coins[index], target/coins[index] 个coins
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            // 修改剩下的额度用于下一层
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationCoins cc = new CombinationCoins();
        int target = 4; // 4 cents
        int[] coins = new int[2];
        coins[0] = 2;
        coins[1] = 1;
        System.out.println(cc.combinations(target, coins));
        
        /* output:
             2  1
           [[0, 4], [1, 2], [2, 0]]
         */

    }
}
