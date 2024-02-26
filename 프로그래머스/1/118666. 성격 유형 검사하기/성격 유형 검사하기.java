import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<Integer, String> reverseMap = new HashMap<Integer,String>();
        map.put("R", 0); map.put("T", 1); map.put("C", 2); map.put("F", 3);
        map.put("J", 4); map.put("M", 5); map.put("A", 6); map.put("N", 7);
        
        reverseMap.put(0, "R"); reverseMap.put(1, "T");
        reverseMap.put(2, "C"); reverseMap.put(3, "F");
        reverseMap.put(4, "J"); reverseMap.put(5, "M");
        reverseMap.put(6, "A"); reverseMap.put(7, "N");
        
        
        int index = 0; int point = 0;
        int[] mbti = new int[8];
        for(int i=0; i<survey.length; i++) {
            if(choices[i] > 4) {
                point = choices[i] - 4;
                index = map.get(survey[i].substring(1, 2));
                mbti[index] += point;
            }
            if(choices[i] < 4) {
                point = 4 - choices[i];
                index = map.get(survey[i].substring(0, 1));
                mbti[index] += point;
            }
        }
        // A6, 1 / F3, 1 / J4, 2 / R0, 3 / N7, 1
        // 
        StringBuilder sb = new StringBuilder();
        if(mbti[0] >= mbti[1]) sb.append(reverseMap.get(0));
        if(mbti[1] > mbti[0]) sb.append(reverseMap.get(1));
        
        if(mbti[2] >= mbti[3]) sb.append(reverseMap.get(2));
        if(mbti[3] > mbti[2]) sb.append(reverseMap.get(3));
        
        if(mbti[4] >= mbti[5]) sb.append(reverseMap.get(4));
        if(mbti[5] > mbti[4]) sb.append(reverseMap.get(5));
        
        if(mbti[6] >= mbti[7]) sb.append(reverseMap.get(6));
        if(mbti[7] > mbti[6]) sb.append(reverseMap.get(7));
        
        return sb.toString();
    }
}