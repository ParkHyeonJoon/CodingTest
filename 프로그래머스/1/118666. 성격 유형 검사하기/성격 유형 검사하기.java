import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<Integer, String> reverseMap = new HashMap<Integer,String>();

        map.put("R", 0); map.put("T", 0); map.put("C", 0); map.put("F", 0);
        map.put("J", 0); map.put("M", 0); map.put("A", 0); map.put("N", 0);
        
        String[][] s = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        
        int index = 0; int point = 0;
        int[] score = new int[8];
        for(int i=0; i<survey.length; i++) {
            if(choices[i] > 4) {
                point = choices[i] - 4;
                index = map.get(survey[i].substring(1, 2));
                map.put(survey[i].substring(1, 2), index+point);
            }
            if(choices[i] < 4) {
                point = 4 - choices[i];
                index = map.get(survey[i].substring(0, 1));
                map.put(survey[i].substring(0, 1), index+point);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<4; i++) {
            if(map.get(s[i][0]) >= map.get(s[i][1])) {
                sb.append((s[i][0]));
            } else {
                sb.append((s[i][1]));
            }
        }

        return sb.toString();
    }
}