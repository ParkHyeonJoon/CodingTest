class Solution {
    public boolean solution(int x) {
        String num = String.valueOf(x);
        int sum = 0;
        boolean answer = true;
        for(String number : num.split("")) {
            int res = Integer.parseInt(number);
            sum = sum + res;
        }
        if(x%sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}