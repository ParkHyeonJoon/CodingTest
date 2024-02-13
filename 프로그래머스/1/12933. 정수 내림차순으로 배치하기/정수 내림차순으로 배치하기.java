import java.util.*; 

class Solution {
    public long solution(long n) {
        String[] list = String.valueOf(n).split(""); // String으로 변환하고 split으로 하나씩 배열에 입력
        StringBuilder sb = new StringBuilder();
        Arrays.sort(list); // 오름차순으로 정렬
        
        for(String num : list) {
            sb.append(num);
        }
        long answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
}