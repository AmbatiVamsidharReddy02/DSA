public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        double currentProduct = x;

        // Iterate while there's still power to consider
        while (N > 0) {
            // If N is odd, multiply result by current product
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the product for next power
            N /= 2; // Divide N by 2
        }

        return result;
    }
}