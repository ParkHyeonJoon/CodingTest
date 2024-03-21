import java.util.*;

class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    private void dfs(int[] numbers, int target, int num, int depth) {
        if(depth == numbers.length) {
            if(num == target) {
                count++;
            }
            return;
        }   
        
        dfs(numbers, target, num+numbers[depth], depth+1);
        dfs(numbers, target, num-numbers[depth], depth+1);
    }
}