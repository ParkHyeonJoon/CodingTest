import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int index = 0;
        int[] num = new int[3];

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                index = processDigit(c, i, index, num, dartResult);
            } else {
                processSymbol(c, index, num);
            }
        }

        return num[0] + num[1] + num[2];
    }

    private int processDigit(char c, int i, int index, int[] num, String dartResult) {
        int digit = Character.getNumericValue(c);

        if (index > 0 && Character.isDigit(dartResult.charAt(i - 1))) {
            num[index - 1] = num[index - 1] * 10;
        } else {
            num[index++] = digit;
        }

        return index;
    }

    private void processSymbol(char c, int index, int[] num) {
        switch (c) {
            case 'S':
                num[index - 1] = num[index - 1] * 1;
                break;
            case 'D':
                num[index - 1] = num[index - 1] * num[index - 1];
                break;
            case 'T':
                num[index - 1] = num[index - 1] * num[index - 1] * num[index - 1];
                break;
            case '*':
                if (index == 1) {
                    num[index - 1] = num[index - 1] * 2;
                }
                if (index > 1) {
                    num[index - 2] = num[index - 2] * 2;
                    num[index - 1] = num[index - 1] * 2;
                }
                break;
            case '#':
                num[index - 1] = num[index - 1] * -1;
                break;
        }
    }
}
