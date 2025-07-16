class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;
        
        while (count < n) {
            List<Long> palindromes = generatePalindromes(length);
            for (long num : palindromes) {
                if (isPalindrome(Long.toString(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) {
                        break;
                    }
                }
            }
            length++;
        }
        return sum;
    }
    
    private List<Long> generatePalindromes(int length) {
        List<Long> palindromes = new ArrayList<>();
        if (length == 1) {
            for (long i = 1; i <= 9; i++) {
                palindromes.add(i);
            }
        } else {
            int halfLength = (length + 1) / 2;
            long start = (long) Math.pow(10, halfLength - 1);
            long end = (long) Math.pow(10, halfLength);
            for (long i = start; i < end; i++) {
                String left = Long.toString(i);
                String right = new StringBuilder(left).reverse().toString();
                if (length % 2 == 1) {
                    right = right.substring(1);
                }
                String palindromeStr = left + right;
                palindromes.add(Long.parseLong(palindromeStr));
            }
        }
        return palindromes;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//much help from online sources