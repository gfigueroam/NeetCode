package neetcode.topKelementsInList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2,3,3,1,1};
        System.out.println(solution.topKFrequent(nums,1));

    }

}
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k ){

        int length = nums.length;
        for(Integer i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<int[]> list = new ArrayList<>();

        for(Map.Entry entry: map.entrySet()){
            int[]  arr = {(int)  entry.getValue(), (int)entry.getKey()};
            list.add(arr);
        }

        //ascending sorting
        list.sort( (a,b)->  b[0] - a[0] );

        //descending sorting
        //list.sort( (a,b)->  a[0] - b[0] );

        System.out.println(map);

        list.forEach((arr)->
            System.out.println(arr[0] +"-" +arr[1])
        );

        int[] result = new int[k];

        for(int i=0; i<k; i++) {
            result[i] = list.get(i)[1];
        }


        return result;
    }
}
