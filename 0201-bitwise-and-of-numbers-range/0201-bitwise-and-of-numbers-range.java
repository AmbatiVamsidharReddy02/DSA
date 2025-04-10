class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    int shift = 0;
    // Shift both m and n until they are the same
    while (m < n) {
        m >>= 1;
        n >>= 1;
        shift++;
    }
    // Shift the common prefix back to its original position
    return m << shift;
}
}