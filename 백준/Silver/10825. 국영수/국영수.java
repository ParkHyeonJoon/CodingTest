import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int kor;
        int eng;
        int math;
        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Student> student = new ArrayList<Student>();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            student.add(new Student(name, kor, eng, math));
        }
        Collections.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.kor == o2.kor) {
                    if(o1.eng == o2.eng) {
                        if(o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kor - o1.kor;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Student list : student) {
            sb.append(list.name).append('\n');
        }
        System.out.println(sb);
    }
}