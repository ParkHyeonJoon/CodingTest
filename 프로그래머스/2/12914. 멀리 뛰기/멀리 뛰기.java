class Solution {
    public long solution(int n) {
        // n이 1 -> 1, 2 -> 2, 3 -> 3, 4 -> 5, 5 -> 8, 6 -> 13...  피보나치?
        long[] arr = new long[n+1];
        arr[0] = 1;
        arr[1] = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        for(int i=2; i<n; i++) {
            arr[i] = arr[i-1] % 1234567 + arr[i-2] % 1234567;
        }
        
        return arr[n-1] % 1234567;
    }
}