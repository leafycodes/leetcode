class Solution {
    public double myPow(double x, int n) {
        return pow(x,(long)n);
    }
    private double pow(double x, long n){
        if(n==0) return 1;
        if(n<0) return pow(1/x,-n);
        if(n%2==0) return pow(x*x,n/2);
        return x*pow(x*x,n/2);
    }
}

// way 2

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return (double) 1 / fastExp(x, -(n + 1)) / x;
        } else {
            return fastExp(x, n);
        }
    }

    private double fastExp(double x, int n) {
        double res = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }

        return res;
    }
}