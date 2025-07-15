class Solution {
    public int trap(int[] height) {
        int n = height.length, trappedWater = 0;

        int maxLeftBoundary[] = new int[n];

        maxLeftBoundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeftBoundary[i] = Math.max(height[i], maxLeftBoundary[i - 1]);
        }

        int maxRightBoundary[] = new int[n];

        maxRightBoundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRightBoundary[i] = Math.max(height[i], maxRightBoundary[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int totalHeightOfBar = Math.min(maxLeftBoundary[i], maxRightBoundary[i]);

            trappedWater += totalHeightOfBar - height[i];
        }

        return trappedWater;
    }
}

// way 2
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int popHeight = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }

                int currWidth = i - stack.peek() - 1;
                int currHeight = Math.min(height[stack.peek()], height[i]) - popHeight;

                water += (currHeight * currWidth);
            }

            stack.push(i);
        }

        return water;
    }
}