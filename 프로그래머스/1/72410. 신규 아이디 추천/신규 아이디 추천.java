class Solution {
    public String solution(String new_id) {
        int firstLength = new_id.length();
        
        new_id = new_id.toLowerCase(); // 1단계. 모든 문자를 소문자로 변경
        
        // 2단계. 'a'부터'z', 0부터 9, '_', '-', '.' 를 제외하고는 모두 삭제
        new_id = new_id.replaceAll("[^a-z0-9_\\-.]", ""); 
        
        // 3단계. '.'이 2개 이상이면 '.'으로  변경
        new_id = new_id.replaceAll("\\.{2,}", "."); 
        
        // 4단계. 첫번째 글자가 '.'이면 첫번째 글자 삭제
        if(new_id.length() > 0) {
            if(new_id.substring(0, 1).equals(".")) { 
                new_id = new_id.substring(1, new_id.length());
            }
        }
          
        // 4단계. 마지막 글자가 '.'이면 마지막 글자 삭제
        if(new_id.length() > 0) {
            if(new_id.substring(new_id.length()-1, new_id.length()).equals(".")) {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        // 5단계. 글자가 빈 문자열이라면 "a"를 대입
        if(new_id.equals("")) {
            new_id = "a"; 
        }
        
        // 6단계. 글자 길이가 16이상이라면, 15글자만 저장. 
        // 제거 후 '.'가 마지막 글자라면 마지막 글자를 제거.
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.substring(new_id.length()-1).equals(".")) {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        // 7단계.  글자 길이가 2 이하라면, 길이가 3이 될 때 까지 
        // 마지막 글자를 더해준다.
        if(new_id.length() <= 2) {
            String lastWord = new_id.substring(new_id.length()-1);
            while(new_id.length() <  3) {
                new_id += lastWord;
            }
        }
        
        return new_id;
    }
}