class Solution {
    public String[] solution(String[] strings, int n) {
        String temp = "";
        
        for(int i=0; i<strings.length-1; i++) {
            int minIdx = i;
            
            for(int j=i+1; j<strings.length; j++) {
                if(strings[minIdx].charAt(n) > strings[j].charAt(n) || 
                  (strings[minIdx].charAt(n) == strings[j].charAt(n) && 
                   strings[minIdx].compareTo(strings[j]) > 0)) {
                    minIdx = j;
                } 
            }
            temp = strings[i];
            strings[i] = strings[minIdx];
            strings[minIdx] = temp;
        }
        
        return strings;
    }
}