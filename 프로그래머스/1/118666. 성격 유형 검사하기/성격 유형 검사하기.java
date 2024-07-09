import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    public String solution(String[] survey, int[] choices) {
        String[][] s = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        
        initScore(s, survey, choices);
        
        String result = returnChoices(map, s);
        
        return result;
    }
    
    private String returnChoices(HashMap<String, Integer> map, String[][] s) {
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
    
    private void initScore(String[][] s, String[] survey, int[] choices) {
        map = new HashMap<String, Integer>();
        for(int n=0; n<s.length; n++) {
            for(int m=0; m<s[0].length; m++) {
                map.put(s[n][m], 0);
            }
        }
        int index = 0; int point = 0;
        
        for(int i=0; i<survey.length; i++) {
            if(choices[i] > 4) {
                point = choices[i] - 4;
                map.put(survey[i].substring(1, 2), map.getOrDefault(survey[i].substring(1,2), 0)+point);
            }
            if(choices[i] < 4) {
                point = 4 - choices[i];
                map.put(survey[i].substring(0, 1), map.getOrDefault(survey[i].substring(0,1), 0)+point);
            }
        }
    }
}