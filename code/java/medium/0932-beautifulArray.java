class Solution {
    ArrayList<Integer> res = new ArrayList<>();

    public int[] beautifulArray(int n) {
        buildBeautifulArray(1, 1, n);

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void buildBeautifulArray(int current, int step, int n) {
        if (current + step > n) {
            res.add(current);
            return;
        }

        buildBeautifulArray(current, step * 2, n);
        buildBeautifulArray(current + step, step * 2, n);
    }
}

// way 2

class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer e : ans) {
                if (2 * e <= n) {
                    temp.add(e * 2);
                }
            }
            for (Integer e : ans) {
                if (2 * e - 1 <= n) {
                    temp.add(e * 2 - 1);
                }
            }
            ans = temp;
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}