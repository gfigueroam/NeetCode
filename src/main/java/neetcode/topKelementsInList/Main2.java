package neetcode.topKelementsInList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1,1,2,3,3,1,1};
        System.out.println(solution.topKFrequent(nums,1));

    }

}
class Solution2 {

    public int[] topKFrequent(int[] nums, int k ){
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(k,(a, b) -> b[0] - a[0]);

        for(Integer i: nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(Map.Entry entry: map.entrySet()) {
            int[]  arr = {(int)  entry.getValue(), (int)entry.getKey()};
            heap.offer(arr);
        }
        int[] result = new int[k];
        for(int i =0; i<k; i++){
            result[i] = heap.poll()[1];

        }

        return result;
    }
}
