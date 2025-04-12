class Solution {
    public long countGoodIntegers(int n, int k) {
      final int half = (n + 1) / 2;
      final int min = (int) Math.pow(10, half - 1);
      final int max = (int) Math.pow(10, half);
      long res = 0;
      Set<String> set = new HashSet<>();
  
      for (int temp = min; temp < max; ++temp) {
        final String fh = String.valueOf(temp);
        final String sh = new StringBuilder(fh).reverse().toString();
        final String val = fh + sh.substring(n % 2);
        if (Long.parseLong(val) % k != 0)
          continue;
        char[] arr = val.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        if (set.contains(sorted))
          continue;
        set.add(sorted);
        int[] freq = new int[10];
        for (char ch : val.toCharArray())
          ++freq[ch - '0'];
        final int lead = n - freq[0];
        long perms = lead * factorial(n - 1);
        for (final int f : freq)
          if (f > 1)
            perms /= factorial(f);
        res += perms;
      }
  
      return res;
    }
  
    private long factorial(int temp) {
      long res = 1;
      for (int i = 2; i <= temp; ++i)
        res *= i;
      return res;
    }
  }
  
  //help from https://walkccc.me/LeetCode/problems