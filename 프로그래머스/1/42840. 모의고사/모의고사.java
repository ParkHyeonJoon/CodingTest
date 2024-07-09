import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int count1 = 0; int count2 = 0; int count3 = 0;
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == p1[i%5]) count1++;
            if(answers[i] == p2[i%8]) count2++;
            if(answers[i] == p3[i%10]) count3++;
        }
        
        int maxScore = Math.max(count1, Math.max(count2, count3));
        List<Integer> list = new ArrayList<Integer>();
        
        if(maxScore == count1) list.add(1);
        if(maxScore == count2) list.add(2);
        if(maxScore == count3) list.add(3);
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}