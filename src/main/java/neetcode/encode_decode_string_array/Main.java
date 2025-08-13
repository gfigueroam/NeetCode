package neetcode.encode_decode_string_array;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {

        List<String> strs = List.of(new String[]{"we","say",":","yes","!@#$%^&*()"});
        Solution solution = new Solution();
        String encoded = solution.encode(strs);
        System.out.println(solution.encode(strs));
        System.out.println(solution.decode(encoded));

    }


}
class Solution {

    public String encode(List<String> strs) {
        //Difference between StringBuilder and StringBuffer
        //StringBuffer is thread safe making it slower
        //String builder is more efficiente but not thread safe

        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append(s);
        }
        return  sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int encoderIndex=0;
        while(encoderIndex < str.length()){
          int length = str.charAt(encoderIndex)-'0';
          list.add(str.substring(encoderIndex+1,encoderIndex+1+length));
          encoderIndex = encoderIndex+1+length;
        }
        return list;
    }
}
