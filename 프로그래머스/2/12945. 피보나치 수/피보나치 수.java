import java.util.*;

class Solution {
    int[] memo;
    public int solution(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        return pibonacci(n);
    }
    
    private int pibonacci(int n) {
        if(n < 2) {
            return n;
        } 
        
        if(memo[n] != -1) {
            return memo[n];
        }
        
        memo[n] = (pibonacci(n-1) + pibonacci(n-2)) % 1234567;
        
        return memo[n];
    }
}