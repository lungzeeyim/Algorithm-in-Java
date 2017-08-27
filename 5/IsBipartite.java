/* 检查一个 undirected graph(双向的图) 是否是bipartite/bai-pa-tai-t/(就是节点可以分成两组，自己组内的节点是不能连到自己组里面的点) */

import java.util.*;

public class IsBipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // use 0 and 1 to denote 2 different groups 使用0和1去【表示】2个不同组
        // the map maintains for each node which group it belongs to 对于每个组的节点
        HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();

        // 那个图可以通过一组节点来表示。我们必须从每个节点来用BFS
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) { return false; } // 如果不是BFS，返回false
        }
        return true;
    }
    
    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        // 如果这个节点已经被检查过，冇必要去再做BFS多次
        if (visited.containsKey(node)) { return true; }
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);

        // 开始宽度优先搜索。因为节点未被访问，所以我们能分配这个节点到任何一组。我们默认放入0组。
        visited.put(node,0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            // 为当前节点分配组
            int curGroup = visited.get(cur);  // HashMap字典.get(key) 得到 value
            // 为当前节点的邻居分配一个组
            int neiGroup = curGroup == 0 ? 1 : 0; // 组的值是0, neiGroup就是1
            for (GraphNode nei : cur.neighbors) {
                // 如果邻居neighbor未被检查，那么就把邻居放入队列并且选择正确组
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    // 如果neighbor未被检查，组未匹配到正确的，返回false
                    return false;
                }
            }

        }
        return true;
    }
    
    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        n1.neighbors.add(n2);
        n2.neighbors.add(n3);
        n3.neighbors.add(n4);
        List<GraphNode> no = new LinkedList<GraphNode>();
        no.add(n1);
        no.add(n2);
        no.add(n3);
        no.add(n4);
        IsBipartite is = new IsBipartite();
/*
Examples

1  --   2

    /   

3  --   4

is bipartite (1, 3 in group 1 and 2, 4 in group 2).
*/
        
        System.out.println(is.isBipartite(no)); // True
        
//---------------------------------------------------------        
        n2.neighbors.add(n4);
/*
1  --   2

    /   |

3  --   4

is not bipartite.
*/

        System.out.println(is.isBipartite(no)); // False
    }
}
