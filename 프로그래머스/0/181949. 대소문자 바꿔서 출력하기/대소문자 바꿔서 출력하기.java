import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<a.length(); i++) {
            int c = a.charAt(i);
            if((c >= 'A') && (c <= 'Z')) {
                sb.append((char)(c+32));
            } else if((c >= 'a') && (c <= 'z')) {
                sb.append((char)(c-32));
            } else {
                sb.append((char)(c));
            }
        }
        
        System.out.print(sb.toString());
    }
}