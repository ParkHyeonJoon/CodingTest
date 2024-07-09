import java.util.*; 

class Solution {
    public int[] solution(int n, String[] words) {
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        System.out.println("Hello Java");
        
        String preWord = words[0];
        HashMap<String, Integer> map = new HashMap<>();
        map.put(preWord, 1);
        
        int count = 1;
        for(int i=1; i<words.length; i++) {
            count++;
            String curWord = words[i];
            
            if(preWord.charAt(preWord.length() - 1) != curWord.charAt(0) || map.containsKey(curWord)) {
                int failPlayerNum = (count-1)%n + 1;
                int failPlayerTurn = (count-1)/n +1;
                return new int[]{failPlayerNum, failPlayerTurn};
            } 
            map.put(curWord, map.getOrDefault(curWord, 0) + 1);
            preWord = curWord;
        }
        
        return new int[]{0, 0};
    }
}