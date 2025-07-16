class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        int lucky = -1;
        for (Map.Entry<Integer, Integer> set : mp.entrySet()) {
            if (set.getValue() == set.getKey() && set.getKey() > lucky) {
                lucky = set.getKey();
            }
        }

        return lucky;
    }
}