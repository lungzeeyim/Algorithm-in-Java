/* given a set of characters, return a list contaning all subsets of characters.
   Set = "abc" ["","a","ab","abc","ac","b","bc","c"] 
*/




/*
 
                                    helper([a,b], [], 0, []) -----------> ['',b',a,ab]
                                    / ['',b]              \['',b',a,ab]
                 helper([a,b],[],1,[])                     helper([a,b],[a],1,['',b])
                 /['']           \['',b] del[b]                  /['',b,a]          \['',b',a,ab]
helper([a,b],[],2,[])   helper([a,b],[b],2,[''])   helper([a,b],[a],2,['',b])        helper([a,b],[ab],2,['',b',a])
                  |                          |                          |                                 |
                 ['']                    ['',b]                     ['',b,a]                             ['',b',a,ab]




 */
import java.util.*;

public class AllSubsets1 {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }

        char[] arraySet = set.toCharArray(); // 字符串->字符数组
        // 记录目前的子集
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // 结束状态：当我们处理了所有字符的选择，之后我们后一个完整的子集
        if (index == set.length) {          // wtf! char[]的长度没有length没有括号
            System.out.println(sb);
            result.add(sb.toString());  // 将字符构造器转换成字符串
            return;
        }
        // 1. 不选在指针位置的字符
        helper(set, sb, index + 1, result);
        // 2. 选在指针数位置的字符
        helper(set, sb.append(set[index]), index + 1, result);

        // 当检查前面那层的时候，移除被添加的字符串
        sb.deleteCharAt(sb.length() - 1);   // wtf! StringBuilder/String类的长度没有length()有括号!!!
    }                                       // 所有大写的非java原生类有括号length()

    public static void main(String[] args) {
        String st = "abc";
        st = "ab";
        AllSubsets1 all = new AllSubsets1();
        
        System.out.println(all.subSets(st));
    }
}
