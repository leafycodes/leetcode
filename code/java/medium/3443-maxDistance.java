public class Solution {
    public int maxDistance(String s, int k) {
        int nCount = 0, sCount = 0, eCount = 0, wCount = 0;
        int maxDist = 0;

        for (char dir : s.toCharArray()) {
            switch (dir) {
                case 'N':
                    nCount++;
                    break;
                case 'S':
                    sCount++;
                    break;
                case 'E':
                    eCount++;
                    break;
                case 'W':
                    wCount++;
                    break;
            }

            int maxNS = Math.max(nCount, sCount);
            int minNS = Math.min(nCount, sCount);
            int maxEW = Math.max(eCount, wCount);
            int minEW = Math.min(eCount, wCount);

            int changesLeft = k;

            if (changesLeft > 0) {
                int possible = Math.min(changesLeft, minNS);
                maxNS += possible;
                minNS -= possible;
                changesLeft -= possible;
            }

            if (changesLeft > 0) {
                int possible = Math.min(changesLeft, minEW);
                maxEW += possible;
                minEW -= possible;
                changesLeft -= possible;
            }

            int currDist = (maxNS - minNS) + (maxEW - minEW);
            maxDist = Math.max(maxDist, currDist);
        }

        return maxDist;
    }
}