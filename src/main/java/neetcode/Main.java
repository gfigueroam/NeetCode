package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        solution.groupAnagrams(strs);
    }
}

class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap();
            for(String s: strs){
                char[] sArray = s.toCharArray();
                Arrays.sort(sArray);
                String key = new String(sArray);

                map.putIfAbsent(key, new ArrayList<String>());
                map.get(key).add(s);
            }
            System.out.println(map.values());

            return  map.values().stream().toList();
        }
 }

