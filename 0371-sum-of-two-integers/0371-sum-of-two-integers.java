class Solution {
    public int getSum(int a, int b) {
    // Base case: when there are no more carries to process
    if (b == 0) return a;
    // Calculate sum ignoring carries, and calculate the carry
    return getSum(a ^ b, (a & b) << 1);
}
}