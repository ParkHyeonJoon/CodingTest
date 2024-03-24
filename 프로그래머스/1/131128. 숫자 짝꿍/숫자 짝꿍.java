import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        StringBuilder sb = new StringBuilder();

        for(String x : X.split("")) {
            xArr[Integer.parseInt(x)]++;
        }

        for(String y : Y.split("")) {
            yArr[Integer.parseInt(y)]++;
        }

        for(int i=9; i>=0; i--) {
            while(xArr[i] > 0 && yArr[i] > 0) {
                sb.append(i);
                xArr[i]--;
                yArr[i]--;
            }
        }
        
        int count = 0;
        for(int i=0; i<=9; i++) {
            while(xArr[i] > 0 && yArr[i] > 0) {
                count++;
                xArr[i]--;
                yArr[i]--;
            }
        }
        String[] result = new String[count];
        
        String answer = "";
        
        if(sb.toString().equals("")) answer = "-1";
        else if(sb.toString().substring(0, 1).equals("0")) answer = "0";
        else answer = sb.toString();
        
        return answer;
    }
}