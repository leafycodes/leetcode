// Time Limit Exceeded 
// 897 / 906 testcases passed

class Solution {
    public long maxArea(int[][] coords) {
        if (coords == null || coords.length < 3) {
            return -1;
        }

        double maxArea = 0;

        Map<Integer, List<Integer>> xAndY = new HashMap<>();
        Map<Integer, List<Integer>> yAndX = new HashMap<>();

        for (int[] point : coords) {
            int x = point[0];
            int y = point[1];

            xAndY.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            yAndX.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            for (Map.Entry<Integer, List<Integer>> entry : xAndY.entrySet()) {
                int xVal = entry.getKey();
                List<Integer> yCoords = entry.getValue();

                if (yCoords.size() < 2) {
                    continue;
                }

                int minY = Integer.MAX_VALUE;
                int maxY = Integer.MIN_VALUE;

                for (int Y : yCoords) {
                    minY = Math.min(minY, Y);
                    maxY = Math.max(maxY, Y);
                }

                double base = (double) (maxY - minY);

                if (base == 0) {
                    continue;
                }

                for (int[] otherPoint : coords) {
                    int otherX = otherPoint[0];
                    if (otherX != xVal) {
                        double height = Math.abs((double) (otherX - xVal));
                        double currArea = 0.5 * base * height;
                        maxArea = Math.max(maxArea, currArea);
                    }
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : yAndX.entrySet()) {
                int yVal = entry.getKey();
                List<Integer> xCoords = entry.getValue();

                if (xCoords.size() < 2) {
                    continue;
                }

                int minX = Integer.MAX_VALUE;
                int maxX = Integer.MIN_VALUE;

                for (int X : xCoords) {
                    minX = Math.min(minX, X);
                    maxX = Math.max(maxX, X);
                }

                double base = (double) (maxX - minX);

                if (base == 0) {
                    continue;
                }

                for (int[] otherPoint : coords) {
                    int otherY = otherPoint[1];
                    if (otherY != yVal) {
                        double height = Math.abs((double) (otherY - yVal));
                        double currArea = 0.5 * base * height;
                        maxArea = Math.max(maxArea, currArea);
                    }
                }
            }
        }
        if (maxArea > 0) {
            return (long) (2 * maxArea);
        } else {
            return -1;
        }
    }
}