import java.util.*; 

class Solution {
    public int solution(String dartResult) {
        int index = 0;
        int[] num = new int[3];
        
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(48 == c) {
                if(i==0) {
                    num[index] = Character.getNumericValue(c);
                    index++;
                    continue;
                } else {
                    char beforeC = dartResult.charAt(i-1);
                    if(48 < beforeC && beforeC <= 57) {
                        beforeC += '0';
                        num[index-1] = Character.getNumericValue(beforeC);
                        continue;
                    } else {
                        num[index] = Character.getNumericValue(c);
                        index++;
                        continue;
                    }
                }
            }
            if(48 < c && c <= 57) {
                num[index] = Character.getNumericValue(c);
                index++;
                continue;
            }
            if(c == 'S') num[index-1] = num[index-1] * 1;
            if(c == 'D') num[index-1] = num[index-1] * num[index-1];
            if(c == 'T') num[index-1] = num[index-1] * num[index-1] * num[index-1];
            if(c == '*') {
                if(index == 1) num[index-1] = num[index-1] * 2;
                if(index > 1) {
                    num[index-2] = num[index-2] * 2; 
                    num[index-1] = num[index-1] * 2;
                }
            }
            if(c == '#') num[index-1] = num[index-1] * -1;
        
        }
        return num[0] + num[1] + num[2];
    }
}