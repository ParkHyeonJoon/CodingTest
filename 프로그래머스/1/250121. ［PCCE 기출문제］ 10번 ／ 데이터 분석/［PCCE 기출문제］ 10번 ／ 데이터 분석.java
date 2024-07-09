import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // ext 값이 code, date, maximum, remain 중에 어떤 것인지?
        int index = 0; 
        if(ext.equals("code")) {
            index = 0;
        } else if(ext.equals("date")) {
            index = 1;
        } else if(ext.equals("maximum")) {
            index = 2;
        } else if(ext.equals("remain")) {
            index = 3;
        }
        
        int[][] filteredData = new int[data.length][4];  
        int count = 0;
        for(int i=0; i<data.length; i++) {
            // val_ext를 기준으로 비교해서 val_ext보다 작은 data들을 골라냄
            if(data[i][index] < val_ext) {
                filteredData[count++] = Arrays.copyOf(data[i], 4);
            }
        }
        
        // sort_by가 어떤 것인지? 
        int sortBy = 0;
        if(sort_by.equals("code")) {
            sortBy = 0;
        } else if(sort_by.equals("date")) {
            sortBy = 1;
        } else if(sort_by.equals("maximum")) {
            sortBy = 2;
        } else if(sort_by.equals("remain")) {
            sortBy = 3;
        }
        
        quickSort(filteredData, 0, count - 1, sortBy);
        
        int[][] answer = Arrays.copyOf(filteredData, count);
        
        return answer;
    }
    private void quickSort(int[][] arr, int low, int high, int sortBy) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, sortBy);

            quickSort(arr, low, partitionIndex - 1, sortBy);
            quickSort(arr, partitionIndex + 1, high, sortBy);
        }
    }
    
    private int partition(int[][] arr, int low, int high, int sortBy) {
        int pivot = arr[high][sortBy];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j][sortBy] <= pivot) {
                i++;

                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}