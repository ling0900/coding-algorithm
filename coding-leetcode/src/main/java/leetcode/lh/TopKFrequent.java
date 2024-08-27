package leetcode.lh;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        Map<Integer, Integer> dic = new HashMap<>();

        for (int num : nums) {
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> dic.get(o2) - dic.get(o1));

        for (int key : dic.keySet()) {
            queue.add(key);
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;

    }
}
