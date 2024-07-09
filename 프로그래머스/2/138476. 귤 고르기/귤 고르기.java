import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        // tangerine 번호, 갯수를 map에 저장
        // 갯수를 list에 넣고 내림차순
        // 거기서 k를 완성시키면 됨
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0; i<list.size(); i++) {
            if(sum + list.get(i) >= k) {
                answer++;
                break;
            } else {
                sum += list.get(i);
                answer++;
            }         
        }
        return answer;
    }
}