import java.util.*; 

class Solution {
    List<String> list = new ArrayList<String>();
    int depth;
    String[] wordBunch = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        depth = 0;
        int answer = 0;
        recursion("", depth);
        
        // for(int i=0; i<list.size(); i++) {
        //     if(list.get(i).equals(word)) {
        //         answer = i;
        //         break;
        //     }
        // }
        
        return list.indexOf(word);
    }
    
    private void recursion(String str, int depth) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for(int i=0; i<wordBunch.length; i++) {
            recursion(str+wordBunch[i], depth+1);
        }
    }
}