import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // HashMap에 id_list 원소와 인덱스를 <String, Integer>로 put
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], i);
        }
        // report를 split(" ")해서 String[] sue해서 sue[0]는 고소를 한 사람, sue[1]는 고소를 당한 사람
        // 2차원 배열 id_list.length x id_list.length 로 만들고 
        int[][] sueCountBoard = new int[id_list.length][id_list.length];
        
        for(int i=0; i<report.length; i++) { 
            String[] sue = report[i].split(" ");
            sueCountBoard[map.get(sue[0])][map.get(sue[1])] = 1;
        }
        int[] sueCount = new int[sueCountBoard.length]; // 해당 인원이 고소를 몇 번 당했는지 저장하는 배열
        int[] answer = new int[sueCountBoard.length]; // 해당 인원이 고소 확인서를 몇번 받는지 저장하는 배열
        
        for(int i=0; i<sueCountBoard.length; i++) {
            for(int j=0; j<sueCountBoard.length; j++) {
                sueCount[i] += sueCountBoard[j][i];
            }
            if(sueCount[i] >= k) {
                for(int m=0; m<sueCountBoard.length; m++) {
                    if(sueCountBoard[m][i] == 1) {
                        answer[m] += 1;
                    } 
                }
            }
        }
        
        return answer;
    }
}