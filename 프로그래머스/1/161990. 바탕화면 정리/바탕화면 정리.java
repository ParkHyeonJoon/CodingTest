import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int minX, maxY;
        int maxX, minY;
        minX = minY = Integer.MAX_VALUE;
        maxX = maxY = Integer.MIN_VALUE;
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        answer[0] = minY; answer[1] = minX; answer[2] = maxY+1; answer[3] = maxX+1;
        return answer;
    }
}