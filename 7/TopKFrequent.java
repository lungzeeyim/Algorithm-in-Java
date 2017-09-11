/* Given a composition with different kinds of words, return a list of the top K most frequent words in the composition. */
/* Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”] */

import java.util.*;

public class TopKFrequent {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> freqMap = getFreqMap(combo);
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
            });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : combo) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s,1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent tp = new TopKFrequent();
        String[] st = {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        String[] result = tp.topKFrequent(st, 2);
        String re = Arrays.toString(result);
        System.out.println(re);
    }
}
