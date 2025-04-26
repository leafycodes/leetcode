import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50,
            'C', 100, 'D', 500, 'M', 1000
        );

        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int val = map.get(c);
            if (!stack.isEmpty() && stack.peek() < val) {
                int prev = stack.pop();
                stack.push(val - prev);
            } else {
                stack.push(val);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
