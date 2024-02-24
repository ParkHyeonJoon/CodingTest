import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, String> map = new HashMap<String, String>();
        HashMap<String, String> reversedMap = new HashMap<String, String>();

        for(int i=1; i<=n; i++) {
            String poketmon = sc.next();
            map.put(Integer.toString(i), poketmon);
            reversedMap.put(poketmon, Integer.toString(i));
        }

        HashMap<String, String> answer = new HashMap<String, String>();
        for(int i=1; i<=m; i++) {
            answer.put(Integer.toString(i), sc.next());
        }

        for(int i=1; i<=m; i++) {
            String result = answer.get(Integer.toString(i));

            if(map.containsKey(result)) {
                System.out.println(map.get(result));
            } else if(reversedMap.containsKey(result)) {
                System.out.println(reversedMap.get(result));
            }
        }
    }
}