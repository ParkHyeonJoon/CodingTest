import java.util.*; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        String answer = "";
        for(String player : participant) {
            playerMap.put(player, playerMap.getOrDefault(player, 0) + 1);
        }
        for(String player : completion) {
            playerMap.put(player, playerMap.get(player) - 1);
        }
        for(String key : playerMap.keySet()) {
            if(playerMap.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}