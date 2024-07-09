import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
    
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            int winPlayer = map.get(callings[i]); // 3
            int losePlayer = winPlayer - 1; // 2
            
            String losePlayerName = players[losePlayer];
            players[losePlayer] = callings[i];
            players[winPlayer] = losePlayerName;
            
            map.put(callings[i], losePlayer);
            map.put(losePlayerName, winPlayer);
        }
        return players;
    }
}