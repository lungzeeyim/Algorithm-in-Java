/*
coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

]
 */

 /*

target = 3
coins [2,1]

                                   helper(3, [2,1], 0, [], [[]])
                                   /                        <----[[0,3][1,1]]
                 max = 3/2 = 1
                 for 2次
                    1次         ------------------------------------>> |              2次
                    cur[0]                                             | i = 1
                    ...[[0,3]]                                         | cur[1]
                    cur[]                                              | helper(3-1*2 = 1, [2,1], 1, [1], [[0,3]])  
                                                                                            cur[] <--- [[0,3][1,1]]
                                                                       |           |
                        |                                                          |
                 helper(3,[2,1], 1, [0], [[]])                                     |
                        index == coins.length - 1 == 1 T                           | 1 == 1 T
                        3%1 == 0 T                                                 | 1 % 1 = 0
                        3/1 = 3, cur[0,3]                                          | cur.add(1/1) => cur[1,1]
                        [[0,3]]                                                    | result[[0,3][1,1]]
                        [0]                                                        | cur[1,]


result = [[0,3][1,1]]

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
        if (index == coins.length - 1) {                    // length - 1
            if (target % coins[coins.length - 1] == 0) {    // 能不能整除？
                cur.add(target / coins[coins.length - 1]);  // 可以整除，就除吧
                result.add(new ArrayList<Integer>(cur));    // 注意result添加一个List<Integer>的方式
                cur.remove(cur.size() - 1);                 // List的大小用size()
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
        int target = 4;
        //target = 3; // easy for flow graph
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
