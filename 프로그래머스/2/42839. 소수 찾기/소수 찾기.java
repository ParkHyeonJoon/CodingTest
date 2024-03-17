import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public int solution(String numbers) {
        int count = 0;
        
        // 1. 각 종이 조각에 적힌 숫자로 만들 수 있는 모든 수를 찾는다.
        dfs("", numbers);
        
        // 2. 그 수들을 set에 저장 시킨다.
        
        // 3. set에서 하나씩 소수 판별하여 count++ 시킨다.
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            int num = iter.next();
            if(isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(String comb, String numbers) {
        if(!comb.equals("")) {
            set.add(Integer.parseInt(comb));
        }
        for(int i=0; i<numbers.length(); i++) {
            dfs(comb + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1));
            
        }
        
    }
    
    private boolean isPrime(int number) {
        if(number == 0 || number == 1) {
            return false;
        }
        
        int limit = (int)Math.sqrt(number);
        for(int i=2; i<=limit; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}