import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        Map<String, Integer> inTime = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];
            
            int minutes = convertToMinutes(time);
            
            if (action.equals("IN")) {
                inTime.put(carNumber, minutes);
            } else {
                int parkedTime = minutes - inTime.remove(carNumber);
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedTime);
            }
        }
        
        int endOfDay = convertToMinutes("23:59");
        for (String carNumber : inTime.keySet()) {
            int parkedTime = endOfDay - inTime.get(carNumber);
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedTime);
        }
        
        List<String> carNumbers = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carNumbers);
        
        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = parkingTime.get(carNumber);
            answer[i] = calculateFee(totalTime, fees);
        }
        
        return answer;
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    private int calculateFee(int totalTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (totalTime <= basicTime) {
            return basicFee;
        }
        
        int extraTime = totalTime - basicTime;
        int extraUnits = (int) Math.ceil((double) extraTime / unitTime);
        
        return basicFee + extraUnits * unitFee;
    }
}
