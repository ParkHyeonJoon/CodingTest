class Solution {
    public int solution(int n) {
        int answer = 0;
        // 2->2, 3->3, 4->5, 5->8, 
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for(int i=2; i<n; i++) {
            int num = arr[i-2] + arr[i-1];
            arr[i] = num % 1000000007;
        }
        return arr[n-1];
    }
}