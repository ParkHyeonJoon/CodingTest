import java.util.*;

class Solution {
    int count;
    int[] arr;
    public int solution(int n) {
        
        int answer = 0;
        // Q는 가로, 세로, 대각선으로 이동이 가능
        // 각 Q의 행과 열이 겹치지 않아야 함
        // Q의 열이 현재 열과 직전의 열이 2이상 차이 나야함
        arr = new int[n];
        backtracking(n, 0);
        
        return count;
        
    }
    
    public void backtracking(int n, int row) {
        if(n == row) {
            count++;
            return;
        }
        for(int i=0; i<n; i++) {
            arr[row] = i;
            if(check(row)) {
                backtracking(n, row+1);
            }
        }
    }
    
    public boolean check(int row) {
        for(int i=0; i<row; i++) {
            if(arr[i] == arr[row]) {
                return false;
            }
            
            if(Math.abs(row-i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
        
}