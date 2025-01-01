import java.io.*;
import java.util.*;
public class Main {

    static List<Character> list = new LinkedList<>();
    static List<String[]> commands = new ArrayList<>();
    static String inputString;
    static int M;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        inputString = br.readLine();
        for(char c : inputString.toCharArray()) {
            list.add(c);
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            String command = br.readLine();
            commands.add(command.split(" "));
        }
    }

    static void pro() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ListIterator<Character> cursor = list.listIterator(list.size());

        for(String[] command : commands) {
            if(command[0].equals("L")) {
                if(cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if(command[0].equals("D")) {
                if(cursor.hasNext()) {
                    cursor.next();
                }
            } else if(command[0].equals("B")) {
                if(cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if(command[0].equals("P")) {
                char charToInsert = command[1].charAt(0);
                cursor.add(charToInsert);
            }
        }
        
        for(char c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}