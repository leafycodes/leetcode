class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = 0;
        int emptyBottles = 0;

        while (numBottles != 0) {
            emptyBottles += numBottles;
            totalBottles += numBottles;
            numBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return totalBottles;
    }
}