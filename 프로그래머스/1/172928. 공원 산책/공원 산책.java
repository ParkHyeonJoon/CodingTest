import java.util.*; 

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0; int y = 0;
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i; 
                    y = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            String[] move = routes[i].split(" ");
            String direction = move[0];
            String distance = move[1];
                
            if(direction.equals("E")) {
                int d = Integer.parseInt(distance);
                int nx = x; int ny = y + d;
                if(nx < 0 || nx >= park.length || ny < 0 || ny >= park[nx].length() || Ycheck(ny, y, nx, park)) {
                    continue;
                } 
                else {
                    x = nx; y = ny;
                }
            }
            
            if(direction.equals("W")) {
                int d = Integer.parseInt(distance);
                int nx = x; int ny = y - d;
                if(nx < 0 || nx >= park.length || ny < 0 || ny >= park[nx].length() || Ycheck(ny, y, nx, park)) {
                    continue;
                } 
                else {
                     x = nx; y = ny;
                }         
            }
            
            if(direction.equals("S")) {
                int d = Integer.parseInt(distance);
                int nx = x + d; int ny = y;
                if(nx < 0 || nx >= park.length || ny < 0 || ny >= park[nx].length() || Xcheck(nx, x, ny, park)) {
                    continue;
                } 
                else {
                    x = nx; y = ny;
                }
            }
            
            if(direction.equals("N")) {
                int d = Integer.parseInt(distance);
                int nx = x - d; int ny = y;
                if(nx < 0 || nx >= park.length || ny < 0 || ny >= park[nx].length() || Xcheck(nx, x, ny, park)) {
                    continue;
                } 
                else {
                    x = nx; y = ny;
                }
            }
        }
        int[] answer = new int[]{x, y};
        return answer;
    }
    
    private boolean Ycheck(int ny, int y, int nx, String[] park) {
        if(ny > y) {
            for(int m = y; m <= ny; m++) {
                if(park[nx].charAt(m) == 'X') return true;
            }
        }
        
        if(ny < y) {
            for(int m = y; m >= ny; m--) {
                if(park[nx].charAt(m) == 'X') return true;
            }
        }
        
        return false;
    }
    
    private boolean Xcheck(int nx, int x, int ny, String[] park) {
        if(nx > x) {
            for(int m = x; m <= nx; m++) {
                if(park[m].charAt(ny) == 'X') return true;
            }
        }
        
        if(nx < x) {
            for(int m = x; m >= nx; m--) {
                if(park[m].charAt(ny) == 'X') return true;
            }
        }
        
        return false; 
        
    }
    
    
}