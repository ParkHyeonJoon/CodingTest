import java.io.*;
import java.util.*;

public class Main {
    static int X;
    static int N;
    static List<Staff> validStaff;
    static class Staff {
        String name;
        int votes;
        int chips;

        Staff(String name, int votes) {
            this.name = name;
            this.votes = votes;
            this.chips = 0;
        }
    }

    static class Moment {
        String name;
        int value;

        Moment(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        validStaff = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int votes = Integer.parseInt(input[1]);

            if(votes >= 0.05*X) {
                validStaff.add(new Staff(name, votes));
            }
        }
    }
    static void pro() {
        validStaff.sort(Comparator.comparing(s -> s.name));

        List<Moment> moments = new ArrayList<>();
        for(Staff staff : validStaff) {
            for(int i=1; i<=14; i++) {
                moments.add(new Moment(staff.name, staff.votes/i));
            }
        }

        moments.sort((m1, m2) -> {
            if(m2.value != m1.value) {
                return Integer.compare(m2.value, m1.value);
            }
            return m1.name.compareTo(m2.name);
        });

        for(int i=0; i<14 && i<moments.size(); i++) {
            for(Staff staff : validStaff) {
                if(staff.name.equals(moments.get(i).name)) {
                    staff.chips++;
                    break;
                }
            }
        }

        validStaff.forEach(staff -> System.out.println(staff.name + " " + staff.chips));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}