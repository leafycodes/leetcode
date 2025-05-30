class Solution {
    public long sumOfLargestPrimes(String s) {
        Set<Long> primes = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (sub.length() > 1 && sub.charAt(0) == '0'){
                    continue;
                }
                if (!isValidNumber(sub)){
                    continue;
                }
                long num = Long.parseLong(sub);
                if (isPrime(num)){
                    primes.add(num);
                }
            }
        }

        if (primes.isEmpty()){
            return 0;
        }

        List<Long> sorted = new ArrayList<>(primes);
        Collections.sort(sorted, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            sum += sorted.get(i);
        }
        return sum;
    }

    private boolean isPrime(long n) {
        if (n <= 1){
            return false;
        }
        if (n == 2){
            return true;
        }
        if (n % 2 == 0){
            return false;
        }
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    private boolean isValidNumber(String s) {
        if (s.length() > 10){
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}