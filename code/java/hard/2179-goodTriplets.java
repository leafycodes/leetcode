class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            indexMap[nums1[i]] = i;
        }

        int[] positionArray = new int[n];
        for (int i = 0; i < n; i++) {
            positionArray[i] = indexMap[nums2[i]];
        }

        List<Integer> sortedSeen = new ArrayList<>();
        long totalTriplets = 0;

        for (int i = 0; i < n; i++) {
            int currentIndex = positionArray[i];

            int leftCount = findInsertPosition(sortedSeen, currentIndex);

            int rightCount = (n - 1 - currentIndex) - (sortedSeen.size() - leftCount);

            totalTriplets += (long) leftCount * rightCount;

            sortedSeen.add(leftCount, currentIndex);
        }

        return totalTriplets;
    }

    private int findInsertPosition(List<Integer> sortedList, int target) {
        int low = 0, high = sortedList.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

//appraoch folowed from Sparsh Choudhary Solution: Appraoch 3