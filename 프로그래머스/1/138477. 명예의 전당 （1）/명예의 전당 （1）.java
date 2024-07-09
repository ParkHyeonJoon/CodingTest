import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        /*
        k, score[] 
        
        score 배열을 하나씩 돌아가면서 끊어.
        그리고 내림차순을 시켜. 
        짜른 배열의 사이즈가 k보다 작을 때 => 그 배열 안에서 가장 작은 원소를 꺼내서 넣어줌
        짜른 배열의 사이즈가 k보다 같거나 클 때 => 그 배열 안에서 인덱스가 2인 데이터를 꺼내서 넣어줌
        
        */
        int[] answer = new int[score.length]; // 10 
        
        for(int i=0; i<score.length; i++) {
            int[] arr = new int[i+1];
            for(int j=0; j<i+1; j++) {
                arr[j] = score[j];
            }
            // Arrays.sort(arr, Collections.reverseOrder());
            Arrays.sort(arr);
            if(arr.length <= k) { // k = 4
                answer[i] = arr[0]; // 0, 0, 0, 
            }
            if(arr.length > k) { // 0, 20
                answer[i] = arr[arr.length-k];
            }
        }
        return answer;
    }
}