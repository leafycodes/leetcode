class Solution {
    private static class SegmentTree {
        private int[] tree;
        private int[] lazy;
        private int n;

        public SegmentTree(int[] nums) {
            this.n = nums.length;
            tree = new int[4 * n];
            lazy = new int[4 * n];
            build(nums, 1, 0, n - 1);
        }

        private void build(int[] nums, int node, int start, int end) {
            if (start == end) {
                tree[node] = nums[start];
            } else {
                int mid = (start + end) / 2;
                build(nums, 2 * node, start, mid);
                build(nums, 2 * node + 1, mid + 1, end);
            }
        }

        private void push(int node, int start, int end) {
            if (lazy[node] != 0) {
                tree[node] += lazy[node];
                if (start != end) { 
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        public void rangeDecrement(int l, int r, int val) {
            update(1, 0, n - 1, l, r, -val);
        }

        private void update(int node, int start, int end, int l, int r, int val) {
            push(node, start, end);

            if (start > end || start > r || end < l) {
                return;
            }

            if (l <= start && end <= r) {
                lazy[node] += val;
                push(node, start, end);
                return;
            }

            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);
        }

        public int query(int idx) {
            return query(1, 0, n - 1, idx);
        }

        private int query(int node, int start, int end, int idx) {
            push(node, start, end);

            if (start == end) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            if (idx <= mid) {
                return query(2 * node, start, mid, idx);
            } else {
                return query(2 * node + 1, mid + 1, end, idx);
            }
        }
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;

        List<List<int[]>> queriesByStartIdx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queriesByStartIdx.add(new ArrayList<>());
        }
        for (int[] query : queries) {
            queriesByStartIdx.get(query[0]).add(query);
        }
        SegmentTree segTree = new SegmentTree(nums);

        int numQueriesKept = 0;
        PriorityQueue<Integer> activeQueriesPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int[] query : queriesByStartIdx.get(i)) {
                activeQueriesPQ.add(query[1]);
            }
            while (segTree.query(i) > 0) {
                while (!activeQueriesPQ.isEmpty() && activeQueriesPQ.peek() < i) {
                    activeQueriesPQ.poll();
                }
                if (activeQueriesPQ.isEmpty()) {
                    return -1;
                }
                int rChosen = activeQueriesPQ.poll();
                segTree.rangeDecrement(i, rChosen, 1);

                numQueriesKept++;
            }
        }

        return queries.length - numQueriesKept;
    }
}

//huge help from online leetcode solutions sources