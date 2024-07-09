import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        String[] arr4 = new String[arr1.length];
        String[] answer = new String[arr1.length];
        
        for(int i=0; i<arr1.length; i++) {
            arr3[i] = arr1[i] | arr2[i];
            arr4[i] = String.format("%" + n + "s", Integer.toBinaryString(arr3[i])).replace(' ', '0');
        }
        
        for(int i=0; i<arr4.length; i++) {
            String wall = "";
            for(int j=0; j<n; j++) {
                if(arr4[i].charAt(j) == '0') {
                    wall += " ";
                }
                if(arr4[i].charAt(j) == '1') {
                    wall += "#";
                }
            }
            answer[i] = wall;
        }
        
        return answer;
    }
}