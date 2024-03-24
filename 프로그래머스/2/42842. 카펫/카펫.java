import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        // 1. brown+yellow의 제곱근까지 반복문을 돌려서 약수 짝을 만든다. 
        // 2. 그 짝들끼리의 차를 저장했을 때 차가 가장 적은 짝을 answer에 담는다.
        int sum = brown + yellow;
        int conNum = (int)Math.sqrt(sum);
        List<int[]> list = new ArrayList<>();
        
        for(int i=2; i<=conNum; i++) {
            if(sum % i == 0) {
                int j = sum / i;
                list.add(new int[]{i, j}); // i가 작은 값, j가 큰 값
            }
        }
        int min = Integer.MAX_VALUE;
        int[] result = {};
        
        for(int[] num : list) {
            int height = num[0];
            int width = num[1];
            
            if((height-2) * (width-2) == yellow) {
                result = new int[]{width, height};
                break;
            }
            
        }
        
        return result;
    }
}