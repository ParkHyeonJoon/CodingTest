import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class 로그필터링 {

    static String startTime;
    static String endTime;
    static String keyword;

    static List<Log> logs = new ArrayList<>();

    static class Log {
        String time;
        String category;
        String content;

        public Log(String time, String category, String content) {
            this.time = time;
            this.category = category;
            this.content = content;
        }
    }

    static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] condition = reader.readLine().split(" ");
        startTime = condition[0];
        endTime = condition[1];
        keyword = condition[2].toLowerCase();

        int N = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++) {
            String log = reader.readLine();
            String[] parts = log.split(" ", 3);

            String time = parts[0];
            String category = parts[1].substring(1, parts[1].length() - 1);
            String content = parts[2];

            logs.add(new Log(time, category, content));
        }
    }

    static void solution() {

            // 시간과 키워드 필터링을 한 번의 반복으로 처리
            List<Log> filteredLogs = logs.stream()
                    .filter(log ->
                            isWithinTimeRange(log.time) &&
                                    log.content.toLowerCase().contains(keyword)
                    )
                    .collect(Collectors.toList());

            // 중복 로그 처리 로직 개선
            Map<String, List<Log>> groupedLogs = new HashMap<>();
            for (String category : new String[]{"INFO", "WARN", "ERROR"}) {
                groupedLogs.put(category, new ArrayList<>());
            }

            // 중복 로그 카운팅 개선
            Map<String, Long> duplicateCounts = filteredLogs.stream()
                    .collect(Collectors.groupingBy(
                            log -> log.content + "|" + log.category,
                            Collectors.counting()
                    ));

            // 중복 로그 처리
            Set<String> processedLogs = new HashSet<>();
            for (Log log : filteredLogs) {
                String logKey = log.content + "|" + log.category;

                if (!processedLogs.contains(logKey)) {
                    Long count = duplicateCounts.get(logKey);
                    List<Log> categoryLogs = groupedLogs.get(log.category);

                    if (count > 1) {
                        categoryLogs.add(new Log(
                                log.time,
                                log.category,
                                log.content + " (x" + count + ")"
                        ));
                        processedLogs.add(logKey);
                    } else {
                        categoryLogs.add(log);
                    }
                }
            }

            // 출력 로직 (기존과 동일)
            boolean foundLogs = false;
            for (String category : new String[]{"INFO", "WARN", "ERROR"}) {
                List<Log> categoryLogs = groupedLogs.get(category);
                if (!categoryLogs.isEmpty()) {
                    foundLogs = true;
                    System.out.println("[" + category + "]:");
                    for (Log log : categoryLogs) {
                        System.out.println("- " + log.time + " " + log.content);
                    }
                    System.out.println();
                }
            }

            if (!foundLogs) {
                System.out.println("No logs found");
            }
        }


    static int getRepeatCount(List<Log> logs, int startIndex) {
        int count = 1;
        Log baseLog = logs.get(startIndex);
        for (int i = startIndex + 1; i < logs.size(); i++) {
            if (logs.get(i).content.equals(baseLog.content) &&
                    logs.get(i).category.equals(baseLog.category)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    // 로그 시간대가 조건에 부합하는지 확인하는 메서드
    static boolean isWithinTimeRange(String logTime) {
        return (logTime.compareTo(startTime) >= 0 && logTime.compareTo(endTime) <= 0);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
