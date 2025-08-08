package neetcode.topKelementsInList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = {1,1,2,3,3,1,1};
        System.out.println(solution.topKFrequent(nums,1));

    }

}
class Solution3 {

    public int[] topKFrequent(int[] nums, int k ){
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i: nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        return  map.entrySet().stream().parallel()
                .sorted((entrya,entryb) -> entryb.getValue()- entrya.getValue())
                .limit(k)
                .mapToInt((entry)->  entry.getKey())
                .toArray();

    }
}
