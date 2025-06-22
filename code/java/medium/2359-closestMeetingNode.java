class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        dist1[node1] = 0;
        queue.offer(node1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int neighbor = edges[current];
            if (neighbor != -1 && dist1[neighbor] == -1) {
                dist1[neighbor] = dist1[current] + 1;
                queue.offer(neighbor);
            }
        }
        
        queue.clear();
        dist2[node2] = 0;
        queue.offer(node2);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int neighbor = edges[current];
            if (neighbor != -1 && dist2[neighbor] == -1) {
                dist2[neighbor] = dist2[current] + 1;
                queue.offer(neighbor);
            }
        }
        
        int minMaxDist = Integer.MAX_VALUE;
        int resultNode = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currentMax = Math.max(dist1[i], dist2[i]);
                if (currentMax < minMaxDist) {
                    minMaxDist = currentMax;
                    resultNode = i;
                } else if (currentMax == minMaxDist && i < resultNode) {
                    resultNode = i;
                }
            }
        }
        return resultNode;
    }
}