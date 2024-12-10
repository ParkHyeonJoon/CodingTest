import java.util.*;
public class Main {

    static int N;
    static Map<String, Integer> bookCountMap = new HashMap<>();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<N; i++) {
            String title = sc.nextLine();
            bookCountMap.put(title, bookCountMap.getOrDefault(title, 0) + 1);
        }
    }

    static void pro() {
        String maxBook = null;
        int maxCount = 0;

        for(Map.Entry<String, Integer> entry : bookCountMap.entrySet()) {
            String book = entry.getKey();
            int count = entry.getValue();
            
            if(count > maxCount || (count == maxCount && book.compareTo(maxBook) < 0)) {
                maxCount = count;
                maxBook = book;
            }
        }

        System.out.println(maxBook);

    }
    public static void main(String[] args) {
        input();
        pro();
    }
}