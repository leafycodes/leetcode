class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        
        Deque<State> queue = new ArrayDeque<>();
        queue.add(new State((1 << n) - 1, 1));
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int mask = current.mask;
            int round = current.round;
            
            List<Integer> players = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    players.add(i + 1); 
                }
            }
            
            boolean found = false;
            int m = players.size();
            for (int i = 0; i < m / 2; i++) {
                int a = players.get(i);
                int b = players.get(m - 1 - i);
                if ((a == firstPlayer && b == secondPlayer) || (a == secondPlayer && b == firstPlayer)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                result[0] = Math.min(result[0], round);
                result[1] = Math.max(result[1], round);
                continue;
            }
            
            Set<Integer> nextMasks = new HashSet<>();
            generateMasks(0, m, players, firstPlayer, secondPlayer, mask, 0, nextMasks);
            
            for (int nextMask : nextMasks) {
                queue.add(new State(nextMask, round + 1));
            }
        }
        
        return result;
    }
    
    private void generateMasks(int pos, int m, List<Integer> players, int firstPlayer, int secondPlayer, int currentMask, int nextMask, Set<Integer> nextMasks) {
        if (pos >= (m + 1) / 2) {
            nextMasks.add(nextMask);
            return;
        }
        
        if (pos == m - 1 - pos) {
            int player = players.get(pos);
            generateMasks(pos + 1, m, players, firstPlayer, secondPlayer, currentMask, nextMask | (1 << (player - 1)), nextMasks);
        } else {
            int player1 = players.get(pos);
            int player2 = players.get(m - 1 - pos);
            
            if (player1 == firstPlayer || player1 == secondPlayer) {
                generateMasks(pos + 1, m, players, firstPlayer, secondPlayer, currentMask, nextMask | (1 << (player1 - 1)), nextMasks);
            } else if (player2 == firstPlayer || player2 == secondPlayer) {
                generateMasks(pos + 1, m, players, firstPlayer, secondPlayer, currentMask, nextMask | (1 << (player2 - 1)), nextMasks);
            } else {
                generateMasks(pos + 1, m, players, firstPlayer, secondPlayer, currentMask, nextMask | (1 << (player1 - 1)), nextMasks);
                generateMasks(pos + 1, m, players, firstPlayer, secondPlayer, currentMask, nextMask | (1 << (player2 - 1)), nextMasks);
            }
        }
    }
    
    static class State {
        int mask;
        int round;
        
        State(int mask, int round) {
            this.mask = mask;
            this.round = round;
        }
    }
}